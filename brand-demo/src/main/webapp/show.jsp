<%--
  Created by IntelliJ IDEA.
  User: cxw
  Date: 2023/6/28
  Time: 15:03
  重写 brand.jsp 页面，使用el 和 jstl 来替换jsp的java代码截断
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面展示</title>
</head>
<body>
<h1>${user.username},欢迎你</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

        <c:forEach items="${brands}" var="brand" varStatus="num">
            <tr align="center">
                <td>${num.count}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status == 0}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status == 1}">
                    <td>禁用</td>
                </c:if>
                <td><a href="/brand/selectById?id=${brand.id}">修改</a> <a href="/brand/deleteById?id=${brand.id}">删除</a></td>
            </tr>
        </c:forEach>
    </tr>

</table>

<script>
     document.getElementById("add").onclick = function () {
        location.href = "/brand/addbrand.jsp";
     }
</script>

</body>
</html>
