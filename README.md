<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">TDCD Cloud</h1>
<h4 align="center">通电传导项目基于Startdis Cloud分布式微服务架构</h4>

## 平台简介

Startdis Cloud(启迪)是一套完全开源的企业数智化平台快速开发框架，基于MIT协议，毫无保留给个人及企业免费使用，由【江苏点九科技有限公司】技术团队提供技术支持。

* 前端采用Vue3、Vite、TypeScript、Pinia
* 后端采用Spring Boot、Spring Cloud & Alibaba
* 网关服务基于Gateway
* 注册中心、配置中心选型Nacos
* 权限认证使用Spring Security、OAuth2
* 流量控制框架选型Sentinel，分布式事务选型Seata

## 相关链接

### 关于点九
点九科技：https://dianjiu.cc

点九开源：https://dianjiuorg.com

点九智云：https://dianjiuyun.com

点九先生：https://dianjiu.co

### 关于启迪
启迪官网：http://startdis.com

文档地址：http://docs.startdis.cn

体验地址：http://uat.startdis.cn  
- startdis/startdis2022

## 系统架构（）

<img src=""/>

## 功能菜单
~~~
Startdis Cloud    
├── 欢迎页：（开发中）                                                
├── 集团管理（已完成）                                                  
│       └── 公司管理：配置集团公司结构，树结构展现集团及子公司数据
│       └── 部门管理：配置公司组织结构，树结构展现部门、小组数据
│       └── 岗位管理：配置公司岗位职责，一键分配公司员工所担任的职务
├── 权限管理（已完成）                                                  
│       └── 用户管理：配置公司人员信息，扁平化展示员工信息及归属（部门、岗位、角色）
│       └── 角色管理：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色
│       └── 菜单管理：配置公司菜单信息，一键分配菜单权限、操作权限、按钮权限、角色菜单
├── 权限管理（已完成）                                                  
│       └── 用户管理：配置公司人员信息，扁平化展示员工信息及归属（部门、岗位、角色）
│       └── 角色管理：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色
│       └── 菜单管理：配置公司菜单信息，一键分配菜单权限、操作权限、按钮权限、角色菜单
├── 系统管理（已完成）                                                  
│       └── 公告设置：配置公司公告信息，先审核后发布，公司后台实时全员推送
│       └── 敏感过滤：配置公司敏感词，全局过滤拦截员工危险言论
│       └── 全局变量：配置公司全局信息，动态配置公司的主题色、公司logo等新信息
│       └── 字典管理：配置公司字典信息，对系统中经常使用的一些较为固定的数据进行维护
│       └── 文件管理：配置公司文件仓库，支持文件上传、下载、复制、分享、删除、图列切换
├── 系统日志（开发中）                                                  
│       └── 登陆日志：记录人员登陆日志，支持员工登陆日志的查询和统计分析（开发中）
│       └── 操作日志：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色（开发中）
├── 系统监控（开发中）                                                  
│       └── 在线用户：实时展示公司在线人数，登陆设备、IP等信息
│       └── 服务监控：监控当前系统服务器运行状态（硬盘、内存、CPU等）
│       └── 数据监控：监控当前系统关系数据库运行状态（硬盘、内存、CPU等）
│       └── 缓存监控：监控当前系统缓存数据库运行状态（硬盘、内存、CPU等）
~~~

## 系统模块

~~~
startdis-boot     
├── docker                                               // 容器部署
├── docs                                                 // 说明文档
├── drawid                                               // 流程图设计
├── pdman                                                // 数据库设计
├── sqls                                                 // 脚本模块
├── startdis-base                                        // 基础模块
│       └── gateway                                      // 网关模块 [18080]
├── startdis-comm                                        // 通用模块
│       └── comm-auth                                    // 权限控制
│       └── comm-core                                    // 核心模块
│       └── comm-domain                                  // 领域模型
│       └── comm-jdbc                                    // 数据配置
│       └── comm-datascope                               // 数据权限
│       └── comm-datasource                              // 多数据源
│       └── comm-exception                               // 异常模块
│       └── comm-feign                                   // 通信模块
│       └── comm-job                                     // 任务模块
│       └── comm-minio                                   // MinIo 文件存储
│       └── comm-s3                                      // S3 对象存储
│       └── comm-fastdfs                                 // FastDFS文件存储
│       └── comm-activemq                                // ActiveMQ
│       └── comm-rabbitmq                                // RabbitMQ
│       └── comm-rocketmq                                // RocketMQ
│       └── comm-redis                                   // 缓存服务
│       └── comm-utils                                   // 工具类
│       └── comm-thread                                  // 线程池
│       └── comm-safe                                    // 安全控制
│       └── comm-saprfc                                  // Sap Rfc
│       └── comm-web                                     // Web
│       └── comm-webservice                              // WebService
│       └── comm-websocket                               // WebSocket
│       └── comm-netty                                   // Netty
│       └── comm-security                                // 安全模块
│       └── comm-swagger                                 // 系统接口
├── startdis-sys                                         // 业务模块
│       └── sys-api                                      // 服务间门面接口模块
│       └── sys-app                                      // H5、小程序、App等C端门面接口模块 [18082]
│       └── sys-domain                                   // 领域实体模块，包含实体、值对象、聚合、事件等
│       └── sys-infra                                    // 领域基础设施模块，包含持久化
│       └── sys-gen                                      // 基础数据代码生成模块
│       └── sys-job                                      // 分布式任务实现模块
│       └── sys-server                                   // 业务服务实现模块
│       └── sys-web                                      // B端门户接口模块 [8081]
├── pom.xml                                              // 公共依赖
~~~
