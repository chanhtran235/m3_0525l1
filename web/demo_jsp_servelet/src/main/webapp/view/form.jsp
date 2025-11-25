<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/25/2025
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sum" method="post">
    <h2>Tính tổng</h2>
    <input name="n1" placeholder="nhập n1">
    <input name="n2" placeholder="nhập n2">
    <button>Tính tổng</button>
</form>
<h2>Ket quả là: ${sum}</h2>
</body>
</html>
