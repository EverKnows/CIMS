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
    <title>登录</title>
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
    <h1>Login</h1>
</div>

<div class="container" >
    <form class="form-horizontal" id="loginform" action="#" method="post">
        <div class="form-group text-center" style="padding: auto">
            <div class="col-lg-offset-3 col-lg-2 text-right" >
                <label for="username" class="control-label" style="margin-right: 5px">Username</label>
            </div>
            <div class="col-lg-4" style="width: 27%;">
                <input type="text" class="form-control" id="username" name="username" placeholder="Username">
            </div>
            <div class="col-lg-3" id="usernameSpan" style="height: 34px;text-align: left">

            </div>
        </div>
        <div class="form-group" style="padding: auto">
            <div class="col-lg-offset-3 col-lg-2 text-right" >
                <label for="password" class="control-label" style="margin-right: 5px">Password</label>
            </div>
            <div class="col-lg-4" style="width: 27%">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-5 col-lg-3" style="padding: 2px">
                <button type="button" id="submitBtn" class="button button-glow button-rounded button-pill" style="width: 69%"><b>登录</b></button>
            </div>
        </div>
    </form>
</div>
<script>
   $("#username").on("blur", function() {
       var reg = /^[a-zA-z][a-zA-Z0-9_]{3,4}$/;
       var username = $("#username").val();

   });
   $("#submitBtn").on("click", function() {
       var reg = /^[a-zA-z][a-zA-Z0-9_]{3,4}$/;
       var username = $("#username").val();
       var password = $("#password").val();
       if (true) {
           // $("#usernameSpan").html("<span style=\"color: green; font-size: 20px\">正确</span>");
           $.ajax({
               // dataType: "json",
               type: "GET",
               url: "/CIMS/loginCtrl",
               data: "username=" + username + "&" + "password=" + password,
               success: function(msg) {
                   if (msg.status == "fail") {
                       alert("用户名或密码错误");
                   } else {
                       window.location.replace(msg.address);
                   }
               },
               error: function(data) {
                   alert("失败");
               }
           });
       } else {
           //$("#usernameSpan").html("<span style=\"color: red; font-size: 20px\">失败</span>");
       }
   });
</script>
</body>
</html>