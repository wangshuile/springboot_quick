## 全球带项目 REST-API

### 框架技术，数据库:

- spring-boot,jetty,mongodb,redis

### 包约定:
- asyn: 异步方法类 (异步方法不放在service中，必须独立)
- config: spring-boot相关配置类
- dao.mongo: mongodb数据访问层
- dao.redis: redis数据访问层
- domain: 存放实体类
- protocol: 存放request和response 参数对象
- task:定时任务

### GUIDE
- 安装MongoDB v3.4以上，并启动
- 安装Redis，并启动
- 下载代码到本地
- cd 到当前目录
- mvn spring-boot:run 即可启动项目
- 访问http://localhost:8019/public/test 返回success则成功




