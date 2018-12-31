# instruction

"事件分析平台————事件分析与事件详情分析"后端代码。

# 使用技术

## 框架

- Spring Boot
- Mybatis

## 版本控制

- Git

## 构建工具

- Gradle

# open into idea

```shell
./gradlew idea
open event-eap.ipr
```

# open into eclipse

```shell
./gradlew eclipse
```

# run this project

```shell
./gradlew run
#daemon mode
nohup ./gradlew run > /var/event-eap-backend 2>&1 &
```
