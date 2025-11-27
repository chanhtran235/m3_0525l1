<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 11/27/2025
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<h1>Student List</h1>
<a class="btn btn-sm btn-success" href="/students?action=add">Add new student</a>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Score</th>
        <th>Rank</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <c:if test="${student.isGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.isGender()}">
                <td>Nữ</td>
            </c:if>
            <td>${student.getScore()}</td>
            <td>
                <c:choose>
                    <c:when test="${student.getScore()>=8}">
                        <span>Giỏi</span>
                    </c:when>
                    <c:when test="${student.getScore()>=7}">
                        <span>Khá</span>
                    </c:when>
                    <c:when test="${student.getScore()>=5}">
                        <span>Trung bình</span>
                    </c:when>
                    <c:otherwise>
                        <span>Yêu sắc yếu</span>
                    </c:otherwise>
                </c:choose>
            </td>

        </tr>

    </c:forEach>
    <tr>
        <c:if test="${studentList.isEmpty()}">
            <td colspan="6">Danh sách trống</td>
        </c:if>

    </tr>
</table>

</body>
</html>
