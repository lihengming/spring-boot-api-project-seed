package com.company.project.configurer;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ObjectUtils;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import static com.company.project.core.ProjectConstant.*;

/**
 * Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {
    @Resource
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(MODEL_PACKAGE);

        //分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //如果没有此目录的话，后续初始化SqlSessionFactory会报错，这里参考MybatisProperties的代码
        org.springframework.core.io.Resource[] resources = null;
        if (!ObjectUtils.isEmpty(resources = resolveMapperLocations("classpath:mapper/**/*.xml"))) {
            bean.setMapperLocations(resources);
        }
        return bean.getObject();
    }

    @Configuration
    @AutoConfigureAfter(MybatisConfigurer.class)
    public static class MyBatisMapperScannerConfigurer {

        @Bean
        public MapperScannerConfigurer mapperScannerConfigurer() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
            mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);
            //配置通用mappers
            Properties properties = new Properties();
            properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
            properties.setProperty("notEmpty", "false");
            properties.setProperty("IDENTITY", "MYSQL");
            mapperScannerConfigurer.setProperties(properties);

            return mapperScannerConfigurer;
        }

    }

    public org.springframework.core.io.Resource[] resolveMapperLocations(String... mapperLocations) {

        PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        ArrayList resources = new ArrayList();
        if(mapperLocations != null) {
            int total = mapperLocations.length;

            for(int i = 0; i < total; ++i) {
                String mapperLocation = mapperLocations[i];
                try {
                    org.springframework.core.io.Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException ex) {
                    ;
                }
            }
        }

        return (org.springframework.core.io.Resource[])resources.toArray(new org.springframework.core.io.Resource[resources.size()]);
    }
}

