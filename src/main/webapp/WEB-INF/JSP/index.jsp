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
    <title>首页</title>
    <!-- Bootstrap -->
    <link href="<%=basePath%>/CSS/bootstrap.min.css" rel="stylesheet">
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
                                <li><a href="/CIMS/yourteam">我的队伍</a></li>
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
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-ride="carousel" data-interval="2000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner " role="listbox">
            <div class="item active">
                <a href="#"><img src="<%=basePath%>/IMG/match1.jpg" class="center-block" width="50%"></a>
                <div class="carousel-caption">
                    Match1
                </div>
            </div>
            <div class="item">
                <a href="#"><img src="<%=basePath%>/IMG/match2.png" class="center-block" width="50%"></a>
                <div class="carousel-caption">
                    Match2
                </div>
            </div>
            <div class="item">
                <a href="#"><img src="<%=basePath%>/IMG/match3.png" class="center-block" width="50%"></a>
                <div class="carousel-caption">
                    Match3
                </div>
            </div>

        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div class="container" >
    <div class="row">
        <span><b>功能入口</b></span>
        <hr>
    </div>
    <div class="row " > <!--style="height: 200px;"-->
        <div class="col-lg-offset-2 col-lg-3" style="padding: auto;" >
            <a href="/CIMS/complist?page.row=5&page.currentPage=1&order=default&level=default&time=default"><img class="img-thumbnail img-responsive center-block"  src="<%=basePath%>/IMG/match.jpg" style="width: 80%;height: 200px"></a>
        </div>

        <div class="col-lg-offset-2 col-lg-3" style="padding: auto;" >
            <a href="/CIMS/forumList?page.currentPage=1&page.row=5&boardId=2" ><img class="img-thumbnail img-responsive center-block"  src="<%=basePath%>/IMG/classic.jpg" style="width: 80%;height: 200px"></a>
        </div>
    </div>
</div>
</div>
<hr>
</body>
</html>