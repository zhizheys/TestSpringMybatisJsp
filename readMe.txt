本地开发网址：http://localhost:8080/TestSpringMybatis/
测试服务部署网址： 



网站开发相关技术：

0.spring mvc, jsp view页面

1.mybatis 作为ORM工具

2.数据库：sql server

3.日志： commons-logging , log4j

4.jquery ajax

5. 添加了全局异常处理， 全局拦截

6.session, cookie

7. 搭建表单提交验证最麻烦，一直出错 ！！！ 原因是有不少jar没有引用
  hibernate-validation
  jboss-logging
  valiation-api




8.ehcache 配置，建议使用低版本

<dependency>
    <artifactId>ehcache-core</artifactId>
    <version>2.6.11</version>
</dependency>


<dependency>
    <artifactId>spring-context-support</artifactId>
    <version>4.2.3.RELEASE</version>
</dependency>

<dependency>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>


9.上传单个文件， 在表单中同时上传多个文件


10. 该网站功能介绍


   Spring MVC + Jsp
   
   (1)spring mvc + jsp view page
   (2)Mybatis + CRUD
   (3)view 数据table展示， View数据if展示， 显示中文
   (4)view 表单提交； 日期格式化； view表单文件上传； java 后台数据验证
   (5)view ajax
   (6)jsp 后台权限管理，通过手工intercept拦截器实现; jsp后台日志记录， commons-logging 实现
   (7)jsp session, cookie管理
   (8)jsp encache缓存
   (9)web 项目发布到tomcat apache





  