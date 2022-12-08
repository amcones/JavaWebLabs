<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/2
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
恭喜你，猜对了。<br>
共猜了
<%


    if(request.getAttribute("ans")!=null){
        out.print(request.getAttribute("ans"));
    }
%>
次
<br>
<a href="index.jsp">再来一局</a>
</body>
</html>
