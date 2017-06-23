### 简介

Spring Boot API Project Seed 用于快速构建纯API的项目，该种子项目已经历过两个真实项目的实践，稳定、简单、快速，轻松编码、摆脱加班。

#### 特征

- 统一JSON响应结果封装及生成工具
- 统一异常处理
- 基础方法（CRUD）Service 抽象封装
- 基于通用Mapper插件、PageHelper实现单表业务零SQL
- 基础代码使用模板直接生成（Model、Mapper、MapperXML、Service、Controller），可根据自己的业务定制模板，摆脱重复劳动

### 快速开始
1. 克隆项目
2. 对test包内的代码生成器```CodeGenerator```进行配置
3. 运行```mian()```方法，刷新项目文件夹，基础代码即生成成功
4. 根据业务在基础代码上进行扩展即可

### 技术选型&文档
- Spring Boot（[查看文档](http://docs.spring.io/spring-boot/docs/1.5.3.RELEASE/reference/htmlsingle/)）
- MyBatis （[查看文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatis Mapper插件、PageHelper分页插件 （[查看文档](http://www.mybatis.tk/)）