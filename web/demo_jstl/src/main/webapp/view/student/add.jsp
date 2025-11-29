
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<h1>Thông tin thêm mới</h1>
<form action="/students?action=add" method="post">
    ID : <input name="id"><br>
    Name : <input name="name"><br>
    Gender : <input type="radio" value="true" name="gender">Male
             <input type="radio" value="false" name="gender">Female<br>
    Score:<input  value="0" name="score">Female<br>
    <button>Save</button>
</form>
</body>
</html>
