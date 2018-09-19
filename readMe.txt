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

  