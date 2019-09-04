<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>你的队伍</title>
    <script src="<%=basePath%>/JS/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath%>/JS/bootstrap.min.js"></script>
    <script src="<%=basePath%>/JS/icheck.min.js"></script>
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
    <div class="row">
        <div class=" col-lg-12" style="height: 90px">
            <blockquote>
                <b style="font-size: 40px">${teamVo.team.teamName}</b>
            </blockquote>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4" style="border-bottom: gainsboro solid 3px">

        </div>

    </div>
    <div class="row">
        <div class="col-lg-12" style="text-align: right;padding: 3px;border:   1px;height: 55px">
            <b style="font-size: 30px">${teamVo.comp.compName}</b>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-offset-9" style="border-top: gainsboro solid 3px">

        </div>

    </div>
    <div class="row">
        <div class="col-lg-12" style="height: 52px">
            <b style="font-size: 26px">你的队友</b>
        </div>
    </div>
    <div class="row" style="margin-top: 5px">
        <div class="col-lg-12" style="text-align: center;border-top: gainsboro solid 3px">
            <table class="table table-hover">
                <th>
                    <td>NickName</td>
                    <td>RealName</td>
                    <td>StudentID</td>
                </th>
                <c:forEach varStatus="status" var="item" items="${teamVo.userList}">
                    <tr>
                        <td></td>
                        <td>${item.username}</td>
                        <td>${item.realName}</td>
                        <td>${item.stdId}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</div>
</body>
</html>