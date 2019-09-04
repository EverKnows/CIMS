<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/7/12
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>创建队伍</title>
    <script src="<%=basePath%>/JS/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath%>/JS/bootstrap.min.js"></script>
    <script src="../JS/icheck.min.js"></script>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/CSS/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/skins/all.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/buttons.css" rel="stylesheet">
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
<div class="container">
    <div class="row" style="margin-top: 40px">
        <div class="col-lg-12" style="height: 40px;text-align: center;">
            <b style="font-size: 30px">创建你的队伍</b>
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-lg-offset-3 col-lg-2" style="text-align: right;height: 30px">
            <b style="font-size: 20px">你的队伍名:</b>
        </div>
        <div class="col-lg-3" style="height: 20px">
            <input class="form-control" id="userName" style="height: 30px;width: 300px" type="text" name="teamName">
        </div>
    </div>
    <div class="row" style="margin-top: 20px">
        <div class="col-lg-offset-5 col-lg-2">
            <button type="button" id="subBtn" class="button button-glow"><b>创建</b></button>
        </div>

    </div>
    <div>
        <input type="hidden" id="compId" value="${compId}">
    </div>
</div>
<script>
    $("#subBtn").bind("click", function() {
        var userName = $("#userName").val();
        var compId = $("#compId").val();
       $.ajax({
         type: "POST",
         data: "teamName=" + userName + "&compId=" + compId,
           url: "/CIMS/addTeam",
           success: function(data) {
             if (data.status == "success") {
                 alert("创建成功");
             } else {
                 alert(data.errorInfo);
             }
           },
           error: function(data) {
             alert("遇到未知错误");
           }
       });
    });
</script>
</body>
</html>
