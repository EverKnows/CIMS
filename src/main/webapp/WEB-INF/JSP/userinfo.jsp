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
    <script>
        $(function() {
            $(".queryItem[type='radio']").iCheck({
                labelHover : false,
                cursor : true,
                radioClass : 'iradio_square-blue',
                width: '5px',
                height: '5px',
                increaseArea : '20%'
            });
            $(".queryItem[type='radio']").on("ifChanged", function() {
                // $("#data").submit();
            })

            $("#selectBtn").on("click", function(){
                if($(this).text() == "收缩") {
                    $(this).text("展开")
                } else {
                    $(this).text("收缩")
                }
                $(".filterBox").toggle(function(){
                    $(this).next("#data").animate({height: 'toggle', opacity: 'toggle'}, "slow");
                },function(){
                    $(this).next("#data").animate({height: 'toggle', opacity: 'toggle'}, "slow");
                    $("#selectBtn").val("收缩");
                });
            });
        });
    </script>
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
<div class="container" >
    <div class="row" style="height: 60px;">
        <div class="col-lg-offset-3 col-lg-6" style="text-align: center;border-bottom: gainsboro solid 1px">
            <h2>个人信息</h2>
        </div>

    </div>
    <div class="row" style="height: 60px;padding: 4px;height: 52px">
        <div class="col-lg-offset-3 col-lg-6" style="padding: 2px">
            <button type="button" class="button button-block" id="modifiedBtn" style="float: right">编辑个人资料</button>
        </div>
    </div>
    <div class="row" >
        <div class="col-lg-offset-3 col-lg-2" style="border: red  1px;padding: 4px;height: 208px;text-align: center">
            <img src="<%=basePath%>/IMG/slider3.jpg" class="img-circle" style="width: 200px;height: 200px;float: top">
            <!--<button class="button button-glow" style="float: bottom">修改头像</button>-->
        </div>
        <div class="col-lg-offset-1 col-lg-4" style="border: red  1px;padding: 4px;height: 208px;">
            <label style="font-size: 25px;">姓名: </label><i style="font-size: 25px"> ${user.username}</i><br>
            <label style="font-size: 25px;">性别: </label><i style="font-size: 25px"> ${user.gender}</i><br>
            <label style="font-size: 25px">学号: </label><i style="font-size: 25px"> ${user.stdId}</i><br>
            <label style="font-size: 25px">专业: </label><i style="font-size: 25px"> ${user.pro}</i><br>
            <label style="font-size: 25px">学历: </label><i style="font-size: 25px"> ${user.edu}</i>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-3 col-lg-6" style="height: 20px;border-bottom: gainsboro solid 1px">
        </div>
    </div>
    <div class="row" style="margin-top: 20px;height: 208px;">
        <div class="col-lg-offset-3">
            <label style="font-size: 25px">个人简介</label>
            <p style="font-size: 20px;border: gainsboro solid 2px;height: 180px;width: 585px;overflow: auto">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                ${user.intro}
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-3 col-lg-6" style="margin-top: 20px;height: 20px;border-bottom: gainsboro solid 1px">
        </div>
    </div>
    <div class="row" style="margin-top: 20px;height: 208px;border-top: gainsboro  1px;">
        <div class="col-lg-offset-3">
            <label style="font-size: 25px">获得荣誉</label>
            <p style="font-size: 20px;border: gainsboro solid 2px;height: 180px;width: 585px;overflow: auto">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                ${user.awardExp}
            </p>
        </div>
    </div>
</div>
</div>
<script>
    $("#modifiedBtn").bind("click", modifyInfo);
    function modifyInfo() {
        window.location.replace("/CIMS/modifyuserinfo");
    }
</script>
</body>
</html>