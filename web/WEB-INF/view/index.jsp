<%--
  Created by IntelliJ IDEA.
  User: 庞昆
  Date: 2018/1/23
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="ContentType" content="text/html;charset=utf-8">
    <title>庞昆</title>
    <link href="/asset/css/style.css" rel="stylesheet">
    <script>
        function setTab(name, cursel, n) {
            $.ajax({
                url: "/index/diary",
                dataType: "json",
                type: "get",
                success: function (data) {

                },
                error: function () {
                    alert("系统内部错误")
                }
            });
        }
    </script>
</head>
<body>
<div class="head">
    <a href="/saying">高筑墙，广积粮，缓称王</a>
</div>
<hr/>
<div class="menu">
    <a href="/diary">日记</a>&nbsp&nbsp&nbsp&nbsp
    <a href="/resource">资源</a>&nbsp&nbsp&nbsp&nbsp<!--id url title info-->
    <a href="/read">读书</a>&nbsp&nbsp&nbsp&nbsp
    <a href="#">学习</a>&nbsp&nbsp&nbsp&nbsp
    <a href="#">比特币</a>&nbsp&nbsp&nbsp&nbsp
</div>
<c:forEach var="activity" items="${activity_list}"
           varStatus="varStatus" step="1">

    <c:choose>
        <c:when test="${varStatus.count==1}">
            <tr>
                <th>编号</th>
                <th>活动名称</th>
                <th>时间</th>
                <th>抢票地址</th>
                <th>总张数</th>
                <th>活动信息</th>
                <th>活动进度</th>
                <th>活动状态</th>
            </tr>
        </c:when>
        <c:when test="${varStatus.count%2==0}">
            <tr>
        </c:when>
        <c:otherwise>
            <tr>
        </c:otherwise>
    </c:choose>

    <td>${varStatus.count}</td>
    <td>${activity.name}</td>
    <td>${activity.time}</td>
    <td>aurorajl.com/rob/start?activityId=${activity.id}</td>
    <td>${activity.tickets}</td>
    <td>${activity.info}</td>
    <td>${activity.num}/${activity.tickets}
    </td>

    <td>
        <c:if test="${activity.ifEnd!='1'}">
            活动正在进行
        </c:if>
        <c:if test="${activity.ifEnd=='1'}">
            活动已结束
        </c:if>

    </td>
    </tr>

</c:forEach>
</body>


</html>
