package com.company.project;

import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  环境常量枚举类
 * @author LErry.li
 * Date: 2018-06-16
 * Time: 14:43
 */
public enum EnvironmentEnum {
    //开发
    DEV,
    //生产
    PROD,
    //联调
    FE,
    //测试
    QA,
    //仿真
    STG;

    public static boolean isProdEnv(Environment env) {
        Assert.notNull(env, "env parameter not null.");
        return EnvironmentEnum.PROD.name().equalsIgnoreCase(env.getProperty("spring.profiles.active"));
    }

    @Override
    public String toString() {
        return this.name();
    }
}
