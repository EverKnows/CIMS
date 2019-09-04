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
    <title>竞赛信息</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="<%=basePath%>/JS/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath%>/JS/bootstrap.min.js"></script>
    <script src="<%=basePath%>/JS/icheck.min.js"></script>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/CSS/font-awesome.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/skins/all.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>/CSS/buttons.css" rel="stylesheet">

    <style>
        .container{
            margin-top: 10px;
        }
        body {
            font-family: sans-serif;
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
<form id="formData">
<div class="container" >
    <div class="row" style="height: 60px;">
        <div class="col-lg-offset-3 col-lg-6" style="text-align: center;border-bottom: gainsboro solid 1px">
            <h2>个人信息</h2>
        </div>

    </div>
    <div class="row" style="height: 60px;padding: 4px;height: 52px">
        <div class="col-lg-offset-3 col-lg-6" style="padding: 2px">
            <button type="button" class="button button-block" id="modifiedBtn" style="float: right">保存个人资料</button>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-offset-3 col-lg-2" style="border: red  1px;padding: 4px;height: 208px;text-align: center">
            <img src="<%=basePath%>/IMG/slider3.jpg" class="img-circle" style="width: 200px;height: 200px;float: top">
        </div>
        <div class="col-lg-offset-1 col-lg-4" style="border: red  1px;padding: 4px;height: 208px;">
            <label style="font-size: 25px;">姓名: </label><input type="text" name="user.username" style="height: 30px" value="${user.username}"><br>
            <label style="font-size: 25px;">性别: </label><input type="text" name="user.gender" style="height: 30px" value="${user.gender}"><br>
            <label style="font-size: 25px;">学号: </label><input type="text" name="user.stdId" style="height: 30px" value="${user.stdId}"><br>
            <label style="font-size: 25px;">专业: </label><input type="text" name="user.pro" style="height: 30px" value="${user.pro}"><br>
            <label style="font-size: 25px;">学历: </label><input type="text" name="user.edu" style="height: 30px" value="${user.edu}"><br>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-3 col-lg-6" style="height: 20px;border-bottom: gainsboro solid 1px">
        </div>
    </div>
    <div class="row" style="margin-top: 20px;height: 208px;">
        <div class="col-lg-offset-3">
            <label style="font-size: 25px">个人简介</label><br>
            <textarea id="intro" name="user.intro" style="font-size: 20px;border: gainsboro solid 2px;height: 180px;width: 585px;overflow: auto">
                ${user.intro}
            </textarea>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-3 col-lg-6" style="margin-top: 20px;height: 20px;border-bottom: gainsboro solid 1px">
        </div>
    </div>
    <div class="row" style="margin-top: 20px;height: 208px;border-top: gainsboro  1px;">
        <div class="col-lg-offset-3">
            <label style="font-size: 25px">获得荣誉</label><br>
            <textarea id="awardexp" name="user.awardExp" style="font-size: 20px;border: gainsboro solid 2px;height: 180px;width: 585px;overflow: auto">
                ${user.awardExp}
            </textarea>
        </div>
    </div>
</div>
</div>
</form>
<script>
    $("#modifiedBtn").bind("click", submitData);
    function submitData() {
        var formdata = $("#formData").serialize();
        $.ajax({
            dataType: "json",
            data: formdata,
            type: "POST",
            url: "/CIMS/updateuserinfo",
            success: function(data) {
                if (data.status == "success") {
                    window.location.replace("/CIMS/info");
                } else {
                    alert("修改失败");
                }


            },
            error: function(data) {
                alert("遇到未知错误！");
            }
        });
    }

</script>
</body>
</html>