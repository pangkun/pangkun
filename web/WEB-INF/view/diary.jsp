<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 庞昆
  Date: 2018/1/25
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="ContentType" content="text/html;charset=utf-8">
    <title>日记</title>
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
        <form action="/diary/submit" method="post">
            <textarea type="text" placeholder="每天记一点..." id="payload_1" name="payload"></textarea>
            <textarea type="text" placeholder="顺便起个标题..." id="title_1" name="title"></textarea>
            <input type="submit" id="submit_1" value="提交">
        </form>
    </div>
    <br><br><br>
    <hr/>
    <ul>
        <c:forEach items="${diary_list}" step="1" var="diary">
            <br>
            <li>
                <h3>${diary.time}|<strong>${diary.title}</strong></h3>
                    ${diary.payload}
            </li>
            <br>
            <hr/>
        </c:forEach>
    </ul>
    <div id="label">
        <c:if test="${ifHaveLast}">
            <a href="/diary/last">上一页</a>&nbsp&nbsp&nbsp&nbsp
        </c:if>
        <c:if test="${ifHaveNext}">
            <a href="/diary/next">下一页</a>
        </c:if>
    </div>
</div>
</body>
</html>
