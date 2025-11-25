<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<a href="/trang-chu">vào doget</a>
<form action="/trang-chu" method="get">
    <button>vào get</button>
</form>

<form action="/trang-chu" method="post">
<button >vào do post</button>
</form>
</body>
</html>