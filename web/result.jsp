<%--
  Created by IntelliJ IDEA.
  User: jamesamcones
  Date: 2022/11/11
  Time: 08:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游戏结果</title>
</head>
<body>
<h1>游戏结果</h1>
<p>
    <%
        out.print(request.getAttribute("result"));
    %>
</p>
</body>
</html>
