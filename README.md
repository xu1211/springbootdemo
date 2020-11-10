# springBoot_demo
 springboot练习项目
 
## 项目内容：
  - springboot基本使用
  - 热部署
  - thymeleaf
  - 用户CRUD
  - resful风格
  - redis
---
- 数据库 MySQL
  - 表
```sql
CREATE TABLE User (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```


## 项目目录结构

1. 项目依赖
- pom.xml

2. 资源目录 `src\main\resources\`
    1. springboot配置
       - application.properties
    2. templates页面模板
       - thymeleaf.html
       - listUser.html
       - editUser.html
       - RESTlistUser.html
       - RESTeditUser.html
       - redisTest.html
3. 代码目录 `src\main\java\com\example\springboot\springbootdemo\`
    1. 启动类
       - SpringbootdemoApplication.java
       
    2. Controller
        1. 返回字符串，返回thymeleaf页面
           - web\hellWord.java
           - web\hellThymeleaf
        2. thymeleaf页面-用户CRUD
           - web\UserController.java
        3. RESTful风格-用户CRUD
           - web\RESTUserController.java
        4. redis
           - web\RedisController.java

    3. mysql+mybatis CRUD
       - mapper\UserMapper.java
       
    4. redis
       1. RedisTemplate配置类
          - config\RedisConfig.java
       2. 封装RedisTemplate方法
          - util\RedisUtil.java    
          - util\Status.java    



- 主页    http://127.0.0.1:8080/hello
- thymeleaf主页    http://127.0.0.1:8080/hellothymeleaf
- thymeleaf 用户管理    http://127.0.0.1:8080/listUser
- RESTful风格 用户管理 http://127.0.0.1:8080/user
- redis 
    - http://127.0.0.1:8080/redis/set?key=1&value=test
    - http://127.0.0.1:8080/redis/get?key=1
    - http://127.0.0.1:8080/redis/expire?key=1



