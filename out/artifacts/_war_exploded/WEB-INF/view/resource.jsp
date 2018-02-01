<%--
  Created by IntelliJ IDEA.
  User: 庞昆
  Date: 2018/1/30
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="ContentType" content="text/html;charset=utf-8">
    <title>资源</title>
    <link href="/asset/css/diary.css" rel="stylesheet">
</head>
<body>
<div class="head">
    <a href="/saying">高筑墙，广积粮，缓称王</a>
</div>
<hr/>
<div class="menu">
    <a href="/diary">日记</a>&nbsp&nbsp&nbsp&nbsp
    <a href="/resource">资源</a>&nbsp&nbsp&nbsp&nbsp
    <a href="/read">读书</a>&nbsp&nbsp&nbsp&nbsp
    <a href="#">学习</a>&nbsp&nbsp&nbsp&nbsp
    <a href="#">比特币</a>&nbsp&nbsp&nbsp&nbsp
</div>
<br>

<div class="publish">
    <div id="con_1">
        <form action="/resource/submit" method="post">
            <textarea type="text" placeholder="url..." id="payload_1" name="url"></textarea>
            <textarea type="text" placeholder="标题" id="title_1" name="title"></textarea>
            <input type="submit" id="submit_1" value="收藏">
        </form>
    </div>
    <br><br><br>
    <hr/>
    <ul>
        <c:forEach items="${resource_list}" step="1" var="resource">
            <br>
            <li>
                <h3>${resource.time}|<strong>${resource.title}</strong></h3>
                ${resource.url}
            </li>
            <br>
            <hr/>
        </c:forEach>
    </ul>
    <div id="label">
        <c:if test="${ifHaveLast}">
            <a href="/resource/last">上一页</a>&nbsp&nbsp&nbsp&nbsp
        </c:if>
        <c:if test="${ifHaveNext}">
            <a href="/resource/next">下一页</a>
        </c:if>
    </div>
</div>
</body>
</html>
