<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="service.IMenuService" %>
<%@ page import="service.imp.MenuService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/8/16
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test JSP</title>
<body>
<h2>Hello World!</h2>
<%
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    //IoC控制反转
    Object obj = applicationContext.getBean("menuService");
    IMenuService menuService = (MenuService) obj;
    System.out.println(menuService.find());
%>
<%=menuService.find()%>
</body>
</html>

