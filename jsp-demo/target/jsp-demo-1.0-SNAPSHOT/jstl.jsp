<%--
  Created by IntelliJ IDEA.
  User: cxw
  Date: 2023/6/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test= "${flag == 1}">
        启用
    </c:if>

    <c:if test= "${flag == 0}">
        禁用
    </c:if>

</body>
</html>
