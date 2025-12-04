<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"/>
<%--<h1>Thông tin thêm mới</h1>--%>
<%--<form action="/students?action=add" method="post">--%>
<%--    Name : <input onchange="checkValidate()" id="name" name="name"><br>--%>
<%--    <small id="errorName" class="text-danger"></small>--%>
<%--    Gender : <input type="radio" checked value="true" name="gender">Male--%>
<%--    <input type="radio" value="false" name="gender">Female<br>--%>
<%--    Score:<input onchange="checkValidate()" id="score" value="0" name="score"><br>--%>
<%--    <small id="errorScore" class="text-danger"></small>--%>
<%--    <button id="btn-save" disabled >Save</button>--%>
<%--</form>--%>

<div class="container mt-5" style="max-width: 600px;">
    <h1 class="text-center mb-4">Thông tin thêm mới</h1>

    <form action="/students?action=add" method="post" class="p-4 border rounded shadow-sm bg-white">

        <!-- Name -->
        <div class="mb-3">
            <label for="name" class="form-label fw-bold">Name</label>
            <input type="text" class="form-control" id="name" name="name" onchange="checkValidate()">
            <small id="errorName" class="text-danger"></small>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label class="form-label fw-bold d-block">Gender</label>

            <div class="form-check form-check-inline">
                <input class="form-check-input" checked type="radio" name="gender" id="male" value="true">
                <label class="form-check-label" for="male">Male</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" value="false">
                <label class="form-check-label" for="female">Female</label>
            </div>
        </div>

        <!-- Score -->
        <div class="mb-3">
            <label for="score" class="form-label fw-bold">Score</label>
            <input type="number" class="form-control" id="score" name="score" value="0" onchange="checkValidate()">
            <small id="errorScore" class="text-danger"></small>
        </div>

        <!-- Save button -->
        <button id="btn-save" class="btn btn-primary w-100" disabled>Save</button>
    </form>
</div>
<script>
    function checkValidate(){
        let name = document.getElementById("name").value;
        let score = document.getElementById("score").value;
        let isNameOK = false;
        let isScore = false;
        if (name===""){
            document.getElementById("errorName").innerHTML = "Tên không được để trống";
            isNameOK = false;
        }else if (!(/^[A-Z][a-z]*(\s[A-Z][a-z]*)+$/.test(name))){
            document.getElementById("errorName").innerHTML = "Tên không đúng định dạng"
            isNameOK = false;

        }else {
            document.getElementById("errorName").innerHTML = ""
            isNameOK = true;
        }
        if (score===""){
            document.getElementById("errorScore").innerHTML = "Điểm không được để trống!"
            isScore = false;
        }else if (!(/^\d+(\.?\d)?$/.test(score))){
            document.getElementById("errorScore").innerHTML = "Điểm không đúng định dạng!"
            isScore = false;
        }else if (score>10) {
            document.getElementById("errorScore").innerHTML = "Điểm phải nhỏ hơn 10!"
            isScore = false;

        }else {
            document.getElementById("errorScore").innerHTML = ""
            isScore = true;
        }
        if (isNameOK&& isScore){
            document.getElementById("btn-save").disabled = false;
        }else {
            document.getElementById("btn-save").disabled = true;
        }
    }
</script>
</body>
</html>
