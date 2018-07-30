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
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");
        //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");
        //支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //如果没有此目录的话，后续初始化SqlSessionFactory会报错，这里参考MybatisProperties的代码
        //这样纯使用注解，没有mapper目录也可以了
        org.springframework.core.io.Resource[] resources = null;
        if (!ObjectUtils.isEmpty(resources = resolveMapperLocations("classpath:mapper/**/*.xml"))) {
            factory.setMapperLocations(resources);
        }
        return factory.getObject();
    }

    @Configuration
    @AutoConfigureAfter(MybatisConfigurer.class)
    public static class MyBatisMapperScannerConfigurer {

        @Bean
        public MapperScannerConfigurer mapperScannerConfigurer() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
            mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);
            //配置通用mappers，详情请查阅官方文档
            Properties properties = new Properties();
            properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
            //insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
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

