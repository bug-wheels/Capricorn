# ♑ Capricorn

> 摩羯座是十二星座中最有耐心，行事最小心、也是最善良的星座。他们做事脚踏实地，也比较固执，不达目的是不会放手的。他们的忍耐力也是出奇的强大，同时也非常勤奋。他们心中总是背负着很多的责任感，但往往又很没有安全感，不会完全地相信别人。

![轮子](https://img.shields.io/badge/wheels-%E8%BD%AE%E5%AD%90-red)
[![Java CI with Maven](https://github.com/bug-wheels/Capricorn/actions/workflows/maven.yml/badge.svg)](https://github.com/bug-wheels/Capricorn/actions/workflows/maven.yml)
![GitHub](https://img.shields.io/github/license/bug-wheels/Capricorn)

**一个注册中心轮子**

# 你能了解到

- 如何实现一个最简单的注册中心 (增删改查就够了)
- 使用 OpenAPI 定义接口文档
- 使用 flyway 管理数据库脚本
- 如何集成 Spring Cloud
- 使用其作为 Apache Thrift 的注册中心
- 使用其作为 gRPC 的注册中心
- 一点点单元测试技术

# 开发部署

```sql
create database capricorn default character set utf8mb4 collate utf8mb4_unicode_ci;
use capricorn;
```

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
- capricorn-example 示例
- capricorn-server 服务，包括服务信息的 curd
- capricorn-client 客户端，主要用来和注册中心进行通信交互
- spring-cloud-starter-capricorn-discovery-server server 的 starter
- spring-cloud-starter-capricorn-discovery-client client 的 starter

## 一、大体设计

### 用到技术

- 使用 OpenAPI 来定义接口，接口文件在 docs/api.yaml
-

## 二、相关技术点简介

### 什么是 OpenAPI / Swagger

OpenAPI 规范（OAS）是一种通用的、和编程语言无关的 API 描述规范，使人类和计算机都可以发现和理解服务的功能，而无需访问源代码、文档或针对接口进行嗅探。 正确定义后，使用者可以使用最少的实现逻辑来理解远程服务并与之交互。

OpenAPI 始于 Swagger 规范，Swagger 规范已于 2015 年捐赠给 Linux 基金会后改名为 OpenAPI，并定义最新的规范为 OpenAPI 3.0。