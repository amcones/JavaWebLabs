<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/12/2
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    if(request.getAttribute("ans")!=null){
        out.print(request.getAttribute("ans"));
    }
%>
<form action="servlet1" method="post" >
    系统随机生成一个1——100之间的数 <br>
    请在下面的文本框输入你猜的数<br>
    <input type="text" name="num">
    <input type="submit">
</form>
</body>
</html>
