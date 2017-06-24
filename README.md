### 简介

Spring Boot API Project Seed 是一个基于Spring Boot&MyBatis的模板项目，用于快速构建纯API的项目，该模板项目已经历过两个真实项目的实践，稳定、简单、快速、摆脱加班。

#### 特征
- 统一JSON响应结果封装、生成工具快速生成
- 统一异常处理
- 常用基础方法抽象封装
- 基于通用Mapper插件、PageHelper实现单表业务零SQL
- Model、Mapper、MapperXML、Service、Controller使用代码生成器利用模板直接生成，可根据自己的业务定制模板，摆脱重复劳动
- 另有彩蛋，待你探索

### 快速开始
1. 克隆项目
2. 对```test```包内的代码生成器```CodeGenerator```进行配置
3. 运行```CodeGenerator.mian()```方法，刷新项目目录，基础代码即生成成功
4. 根据业务在基础代码上进行扩展即可

下面是一个简单的演示，看如何基于本项目在短短几秒钟内实现一套基础API，并可以运行提供服务。
![](http://chuantu.biz/t5/114/1498213687x2890174321.gif)

### 技术选型&文档
- Spring Boot（[查看文档](http://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/htmlsingle/)）
- MyBatis （[查看文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatis Mapper插件、PageHelper分页插件 （[查看文档](http://www.mybatis.tk/)）