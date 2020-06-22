# springBoot_demo
 springboot练习项目
 
内容：springboot基本使用,用户增删改查,热部署,thymeleaf,resful风格,redis

- 数据库 MySQL
- 表
```sql
CREATE TABLE User (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```
- 项目目录结构
    1. 项目依赖\
    pom.xml
    
    2. springboot配置\
    src\main\resources\application.properties
    
    3. web页面
    http://127.0.0.1:8080/hello\
src\main\java\com\example\springboot\springbootdemo\web\hellWord.java

    4. thymeleaf页面
    http://127.0.0.1:8080/hellothymeleaf\
src\main\java\com\example\springboot\springbootdemo\web\hellWord.java

    5. mysql+mybatis增删改查\
src\main\java\com\example\springboot\springbootdemo\mapper\UserMapper.java

    6. thymeleaf用户管理
    http://127.0.0.1:8080/listUser\
src\main\resources\templates\listUser.html
src\main\resources\templates\editUser.html
src\main\java\com\example\springboot\springbootdemo\web\UserController.java

    7. RESTful风格 用户管理
    http://127.0.0.1:8080/user\
src\main\resources\templates\RESTlistUser.html
src\main\resources\templates\RESTeditUser.html
src\main\java\com\example\springboot\springbootdemo\web\RESTUserController.java

    8. redis
存一个值 http://127.0.0.1:8080/redis/set?key=1&value=test
src\main\resources\templates\redisTest.html
src\main\java\com\example\springboot\springbootdemo\config\RedisConfig.java
src\main\java\com\example\springboot\springbootdemo\util\RedisUtil.java
src\main\java\com\example\springboot\springbootdemo\util\Status.java
src\main\java\com\example\springboot\springbootdemo\web\RedisController.java






