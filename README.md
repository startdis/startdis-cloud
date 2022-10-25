<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Startdis Cloud v1.0.0</h1>
<h4 align="center">基于Spring Boot/Spring Cloud & Alibaba 分布式微服务架构</h4>

## 平台简介

启迪是一套全部开源的快速开发平台，毫无保留给个人及企业免费使用。

* 前端采用Vue3、Vite、TypeScript、Pinia
* 后端采用Spring Boot、Spring Cloud & Alibaba
* 注册中心、配置中心选型Nacos
* 权限认证使用Spring Security、OAuth2
* 流量控制框架选型Sentinel，分布式事务选型Seata

## 在线体验（部署中）

- startdis/startdis2022

演示地址：http://cloud.startdis.org.cn  
文档地址：http://docs.startdis.org.cn

## 系统模块（开发中）

~~~
com.startdis     
├── docker                                               // 容器部署
├── docs                                                 // 说明文档
├── drawid                                               // 流程图设计
├── pdman                                                // 数据库设计
├── sqls                                                 // 脚本模块
├── startdis-base                                        // 基础模块
│       └── base-gateway                                 // 网关模块 [8080]
│       └── base-auth                                    // 认证中心 [9100]
│       └── base-visual                                  // 监控中心 [9200]
├── startdis-common                                      // 通用模块
│       └── common-core                                  // 核心模块
│       └── common-domain                                // 领域模型
│       └── common-jdbc                                  // 数据配置
│       └── common-datascope                             // 数据权限
│       └── common-datasource                            // 多数据源
│       └── common-exception                             // 异常模块
│       └── common-feign                                 // 通信模块
│       └── common-job                                   // 任务模块
│       └── common-log                                   // 日志记录
│       └── common-file-minio                            // MinIo 文件存储
│       └── common-file-s3                               // S3 对象存储
│       └── common-file-fastdfs                          // FastDFS文件存储
│       └── common-mq-active                             // ActiveMQ
│       └── common-mq-rabbit                             // RabbitMQ
│       └── common-mq-rocket                             // RocketMQ
│       └── common-redis                                 // 缓存服务
│       └── common-utils                                 // 工具类
│       └── common-thread                                // 线程池
│       └── common-saprfc                                // Sap Rfc
│       └── common-webservice                            // WebService
│       └── common-websocket                             // WebSocket
│       └── common-netty                                 // Netty
│       └── common-security                              // 安全模块
│       └── common-swagger                               // 系统接口
├── startdis-system                                     // 业务模块
│       └── system-api                                  // 服务间门面接口模块
│       └── system-app                                  // H5、小程序、App等C端门面接口模块 [18082]
│       └── system-domain                               // 领域实体模块，包含实体、值对象、聚合、事件等
│       └── system-infra                                // 领域基础设施模块，包含持久化
│       └── system-gen                                  // 基础数据代码生成模块
│       └── system-job                                  // 分布式任务实现模块
│       └── system-server                               // 业务服务实现模块
│       └── system-web                                  // B端门户接口模块 [18081]
├── startdis-ui                                          // 前端模块
├──pom.xml                                               // 公共依赖
~~~

## 系统架构（规划中）

<img src=""/>

## 系统功能（开发中）

1.  部门管理：配置系统组织公司（公司、部门、小组），树结构展现支持数据权限。
2.  岗位管理：配置系统用户所属担任职务。
3.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按公司进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。 
7.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
