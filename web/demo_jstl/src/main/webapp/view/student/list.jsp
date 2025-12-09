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
<h2>${param.mess}</h2>
<table class="table table-dark table-striped">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Score</th>
        <th>Rank</th>
        <th>Class</th>
        <th>Delete</th>
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
            <td>${student.className}</td>
            <td>
                <button onclick="getInfoToDelete('${student.id}','${student.name}')" type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                 Delete
                </button>
            </td>

        </tr>

    </c:forEach>
    <tr>
        <c:if test="${studentList.isEmpty()}">
            <td colspan="6">Danh sách trống</td>
        </c:if>

    </tr>
</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/students?action=delete" method="post">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" name="deleteId" id="deleteId">
                    <span>Bạn có muốn xoá sinh viên </span><span id="deleteName" class="text-danger"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    function getInfoToDelete(id, name){
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerHTML = name;
    }
</script>
</body>
</html>
