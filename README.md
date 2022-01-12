# ♑ Capricorn

> 摩羯座是十二星座中最有耐心，行事最小心、也是最善良的星座。他们做事脚踏实地，也比较固执，不达目的是不会放手的。他们的忍耐力也是出奇的强大，同时也非常勤奋。他们心中总是背负着很多的责任感，但往往又很没有安全感，不会完全地相信别人。

![轮子](https://img.shields.io/badge/wheels-%E8%BD%AE%E5%AD%90-red)

一个注册中心轮子

# 你能了解到

- 如何实现一个最简单的注册中心 (增删改查就够了)
- 使用 OpenAPI 定义接口文档
- 使用 flyway 管理数据库脚本
- 如何集成 Spring Cloud
- 使用其作为 Apache Thrift 的注册中心
- 使用其作为 gRPC 的注册中心
- 一点点单元测试技术

# 开发文档

## 接口信息

以下是提供的一些通用 HTTP 接口操作。 

| 操作             | **请求**                                   | **说明**                                 |
| ---------------- | ------------------------------------------ | ---------------------------------------- |
| 注册一个服务实例 | POST /api/v1/dc/ns/instance                | 返回 200 说明成功                        |
| 剔除一个服务实例 | DELETE /api/v1/dc/ns/instance/{instanceId} | 返回 200 说明成功                        |
| 发送实例心跳包   | PUT /api/v1/dc/ns/instance/{instanceId}    | 返回 200 说明成功，返回 404 则实例不存在 |
| 查询实例信息     | GET /api/v1/dc/ns/instance                 | 返回 200 说明成功                        |

具体接口文档信息见 docs/open-api.yaml，IDEA 和 VSCode 可以安装 OpenAPI 预览插件，或者复制到 https://editor.swagger.io/ 查看



## 预期项目结构

- capricorn-commons
- capricorn-
- capricorn-
- capricorn-
- capricorn-
- capricorn-
- capricorn-
- capricorn-

