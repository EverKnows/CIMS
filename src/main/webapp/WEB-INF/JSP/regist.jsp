<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/buttons.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="<%=basePath%>/JS/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath%>/JS/bootstrap.min.js"></script>
    <style>
        .container{
            margin-top: 20px;
        }
    </style>

</head>
<body>
<nav class="navbar navbar-default" >
    <div class="container-fluid" >
        <!-- 页眉 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Togglenavigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/CIMS/index" style="padding:2px"><img src="<%=basePath%>/IMG/logo.png" width="200px" height="100%" /></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty username}" >
                    <li><a>${username}</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户中心<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <c:if test="${not empty username}">
                                <li><a href="/CIMS/info">个人信息</a></li>
                                <li><a href="#">我的队伍</a></li>
                                <li><a href="/CIMS/logout">注销</a></li>
                            </c:if>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${empty username}">
                    <li><a href="<%=basePath%>/login">登录</a></li>
                    <li><a href="/CIMS/regist">注册</a></li>
                </c:if>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid text-center" >
    <h1>Registration</h1>
</div>

<div class="container" >
    <form class="form-horizontal" id="formData">
        <div class="form-group" style="padding: auto">
            <div class="col-sm-offset-3 col-sm-2 text-right" >
                <label for="username" class="control-label" style="margin-right: 0px">Username</label>
            </div>
            <div class="col-sm-4" style="width: 27%;">
                <input type="text" class="form-control" id="username"  name="user.username" placeholder="Username">
            </div>
            <div class="col-sm-3">
                <span id="usernameSpan">

                </span>
            </div>
        </div>
        <div class="form-group" style="padding: auto">
            <div class="col-sm-offset-3 col-sm-2 text-right" >
                <label for="password" class="control-label" style="margin-right: 0px">Password</label>
            </div>
            <div class="col-sm-4" style="width: 27%">
                <input type="password" class="form-control" id="password" name="user.password" placeholder="Password">
            </div>
            <div class="col-sm-3">
                <span id="passwordSpan">

                </span>
            </div>
        </div>
        <div class="form-group" style="padding: auto">
            <div class="col-sm-offset-3 col-sm-2 text-right" >
                <label for="realname" class="control-label" style="margin-right: 0px">Realname</label>
            </div>
            <div class="col-sm-4" style="width: 27%">
                <input type="text" class="form-control" id="realname" name="user.realName" placeholder="Realname">
            </div>
            <div class="col-sm-3">
                <span  id="realnameSpan">

                </span>
            </div>
        </div>
        <div class="form-group" style="padding: auto">
            <div class="col-sm-offset-3 col-sm-2 text-right" >
                <label for="studentId" class="control-label" style="margin-right: 0px">StudentID</label>
            </div>
            <div class="col-sm-4" style="width: 27%">
                <input type="text" class="form-control" id="studentId" name="user.stdId" placeholder="StudentID">
            </div>
            <div class="col-sm-3">
                <span  id="studentidSpan">

                </span>
            </div>
        </div>
        <div class="form-group" style="padding: auto">
            <div class="col-sm-offset-3 col-sm-2 text-right" >
                <label class="control-label" style="margin-right: 0px">Verification Code</label>
            </div>
            <div class="col-sm-2" style="width: 12%">
                <input type="text" class="form-control" id="VerificationCode" name="checkCode" >
            </div>
            <div class="col-sm-2" style="height: 100%;">
                <img id="checkCodeImg" onclick="getCheckCode()" src="/CIMS/getCheckCode" height="33px" width="133px">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-3" style="padding: 2px">
                <button type="button" id="submitBtn" class="button button-glow button-rounded button-pill" style="width: 69%"><b>注册</b></button>
            </div>
        </div>

    </form>
</div>
<script>
    var usernameFlag = true;
    var passwordFlag = true;
    var realnameFlag = true;
    var studentidFlag = true;
    $("#username").bind("blur", validateUsername);
    $("#password").bind("blur", validatePassword);
    $("#realname").bind("blur", validateRealname);
    $("#studentId").bind("blur", validateStudentId);
    $("#submitBtn").bind("click", validateAllInfo);
    function validateUsername() {
        var usernameReg = /^[a-zA-Z][a-zA-Z0-9_]{4,10}$/;
        var name = $("#username").val();
        if (usernameReg.test(name)) {
            $("#usernameSpan").html("<v style=\"font-size: 20px; color: green\">正确</span>");
            usernameFlag = true;
        } else {
            $("#usernameSpan").html("<v style=\"font-size: 20px; color: red\">错误</span>");
            usernameFlag = false;
        }
    }
    function validatePassword() {
        var value = $("#password").val();
        if(!(new RegExp(" ").test(value)) && value.length <= 12) {
            passwordFlag = true;
            $("#passwordSpan").html("<v style=\"font-size: 20px; color: green\">正确</span>");
        } else {
            passwordFlag = false;
            $("#passwordSpan").html("<v style=\"font-size: 20px; color: red\">错误</span>");
        }
    }
    function validateRealname() {
        var value = $("#realname").val();
        if(!(new RegExp(" ").test(value)) && value.length <= 12) {
            realnameFlag = true
            $("#realnameSpan").html("<v style=\"font-size: 20px; color: green\">正确</span>");
        } else {
            realnameFlag = false;
            $("#realnameSpan").html("<v style=\"font-size: 20px; color: red\">错误</span>");
        }
    }
    function validateStudentId() {
        var id = $("#studentId").val();
        var reg = /^[0-9]{8}$/;
        if(reg.test(id)) {
            studentidFlag = true
            $("#studentidSpan").html("<v style=\"font-size: 20px; color: green\">正确</span>");
        } else {
            studentidFlag = false;
            $("#studentidSpan").html("<v style=\"font-size: 20px; color: red\">错误</span>");
        }
    }
    function getCheckCode() {
        var img = document.getElementById("checkCodeImg");
        img.src = "/CIMS/getCheckCode?time=" + new Date().getTime();
    }

    function validateAllInfo() {
        if (usernameFlag && passwordFlag && studentidFlag && realnameFlag) {
            var data = $("#formData").serialize();
            $.ajax({
               data: data,
               type: "POST",
               url: "/CIMS/registCtrl",
               success: function(data) {
                   if (data.status == "success") {
                       alert("注册成功，即将为您跳转到登录界面!")
                       setTimeout(function(){
                           window.location.replace("/CIMS/login");
                       }, 1000);
                   } else {
                       alert(data.errorInfo);
                   }
               },
               error: function(data) {
                   alert("遇到未知错误！");
               }
            });
        } else {
            alert("请检查您的注册信息！")
        }
    }
</script>
</body>
</html>