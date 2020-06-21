# springBoot_demo
 springboot练习项目
 
内容：springboot基本使用，用户增删改查，热部署，thymeleaf

- 数据库 MySQL
- 表
```sql
CREATE TABLE User (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
```
- web页面
http://127.0.0.1:8080/hello

- thymeleaf
http://127.0.0.1:8080/hellothymeleaf

- 用户管理
http://127.0.0.1:8080/listUser

- thymeleaf用户管理
http://127.0.0.1:8080/user
