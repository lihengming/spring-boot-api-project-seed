### 简介
Spring Boot API Project Seed 是一个基于Spring Boot & MyBatis的种子项目，用于快速构建纯API的项目（中小型项目)，该种子项目已经有过多个真实项目的实践，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码编写，减少加班。下面是一个简单的使用演示，看如何基于本项目在短短几秒钟内实现一套简单的API，并运行提供服务。
![](http://chuantu.biz/t5/114/1498213687x2890174321.gif)

### 特征&提供
- 最佳实践的项目结构、配置文件及精简的Maven依赖
- 统一响应结果封装及生成工具
- 统一异常处理
- 常用基础方法抽象封装
- 集成MyBatis、通用Mapper插件、PageHelper分页插件，实现单表业务零SQL（相关使用文档在最下面有地址)
- 提供代码生成器根据表名生成对应的Model、Mapper、MapperXML、Service、ServiceImpl、Controller（默认提供post和rest两套Controller模板)等基础代码，代码模板可根据实际项目的需求来定制，以便渐少重复劳动（由于每个公司业务都不太一样，所以只提供了一些简单的通用方法模板，主要是提供一个思路来减少重复代码的编写，在我们公司的使用中，其实根据业务的抽象编写了大量的代码模板，下次再做类似的项目几天就完工了)
- 另有彩蛋，待你探索
 
### 快速开始
1. 克隆项目
2. 对```test```包内的代码生成器```CodeGenerator```进行配置，主要是JDBC，因为要根据表名来生成代码
3. 如果只是想根据上面的演示来亲自试试的话可以使用test resources 下的的```demo-user.sql```，否则忽略该步
3. 输入表名，运行```CodeGenerator.mian()```方法，刷新项目目录，基础代码（Model、Mapper、MapperXML、Service、Controller)即生成成功
4. 根据业务在基础代码上进行扩展即可
5. 对开发环境配置文件```application-dev.properties```进行配置，启动项目，Have Fun！
 
### 开发建议
- 表名，应使用小写，多个单词使用下划线拼接
- Model内成员变量建议于表字段相等，如需扩展成员变量(比如连表查询)，建议创建DTO，否则需在对应字段上加@Transist注解，详情见[通用Mapper插件文档说明]。
- 建议业务失败使用```ServiceException(""message")```抛出，由统一异常处理器来封装JSON结果，比如```throw new ServiceException("该手机号已存在")```，会直接被封装为```{"code":400,"message":"该手机号已存在"}```返回，无需自己处理，尽情抛出。
- 开发规范建议遵循阿里巴巴开发手册（[最新版下载]())
 
### 技术选型&文档
- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatisb通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- 其他略
