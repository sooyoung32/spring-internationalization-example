<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: Sooyoung
  Date: 2016-07-29
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>${hello}!!!</h1>
Language : <a href="?language=en">English</a>|<a href="?language=ko">Korean</a>|<a href="?language=cn">China</a>
</br>
<spring:message code="message.test"/>
<spring:message code="message.test2"/>
<spring:message code="message.test3"/>
</body>
</html>
