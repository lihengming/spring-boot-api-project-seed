#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=${DEPLOY_DIR}/config

SERVER_NAME=`sed '/server.servlet.application-display-name/!d;s/.*=//' config/application.properties | tr -d '\r'`
SERVER_PORT=`sed '/server.port/!d;s/.*=//' config/application.properties | tr -d '\r'`
PROFILES_ACTIVE=`sed '/spring.profiles.active/!d;s/.*=//' config/application.properties | tr -d '\r'`
LOGS_FILE=`sed '/logging.path/!d;s/.*=//' config/application.properties | tr -d '\r'`

ACTIVE_FILE=application-"$PROFILES_ACTIVE".properties
EXECUTE_FILE=spring-boot-api-project-seed-1.0.jar

if [ -z "$SERVER_NAME" ]; then
    SERVER_NAME=`hostname`
fi

PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

if [ -n "$SERVER_PORT" ]; then
    SERVER_PORT_COUNT=`netstat -tln | grep ${SERVER_PORT} | wc -l`
    if [ ${SERVER_PORT_COUNT} -gt 0 ]; then
        echo "ERROR: The $SERVER_NAME port $SERVER_PORT already used!"
        exit 1
    fi
fi

LOGS_DIR=""
if [ -n "$LOGS_FILE" ]; then
    LOGS_DIR=`dirname ${LOGS_FILE}`
else
    LOGS_DIR=$HOME/logs
fi
if [ ! -d ${LOGS_DIR} ]; then
    mkdir ${LOGS_DIR}
fi
STDOUT_FILE=${LOGS_DIR}/stdout-${SERVER_NAME}.log

LIB_DIR=${DEPLOY_DIR}/lib
LIB_JARS=`ls ${LIB_DIR}|grep .jar|awk '{print "'${LIB_DIR}'/"$0}'|tr "\n" ":"`

JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE \
    -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS=" -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false \
    -Dcom.sun.management.jmxremote.authenticate=false "
fi
JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC \
    -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m \
    -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi

echo -e "Starting the $SERVER_NAME ...\c"

nohup java ${JAVA_OPTS} ${JAVA_MEM_OPTS} ${JAVA_DEBUG_OPTS} ${JAVA_JMX_OPTS} \
-Dloader.path=${LIB_DIR},${CONF_DIR} -jar ${DEPLOY_DIR}/${EXECUTE_FILE} > ${STDOUT_FILE} 2>&1 &
#-Dspring.config.location=${CONF_DIR}/application.properties,${CONF_DIR}/${ACTIVE_FILE} > ${STDOUT_FILE} 2>&1 &

# 最长检测 1 分钟，可能的结果是标志文件不存在，这个要开发人员自己检查进程启动是否有问题.
CHECK_MAX_COUNT=30
COUNT=0
while [ ${CHECK_MAX_COUNT} -gt 1 ]; do
    echo -e ".\c"
    sleep 2
    if [ -n "$SERVER_PORT" ]; then
        COUNT=`netstat -an | grep ${SERVER_PORT} | wc -l`
    else
    	COUNT=`ps -ef | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
    fi
    if [ ${COUNT} -gt 0 ]; then
        break
    fi

    ((CHECK_MAX_COUNT--))
done

echo "OK!"
PIDS=`ps -ef | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"
