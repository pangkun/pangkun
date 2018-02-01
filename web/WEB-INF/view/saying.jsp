<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 庞昆
  Date: 2018/1/23
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
格言
<% session.setAttribute(",", "1");%>
<%=request.getSession().getAttribute(",")%>
</body>
</html>
