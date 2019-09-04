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
    <title>精华帖</title>
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
    <div class="container" style="margin-top: 100px">
        <c:forEach items="${forumVo.topicList}" varStatus="status" var="item">
            <div class="row" style="height: 50px;border: black solid 1px">
                <div class="col-lg-10" style="padding: 10px;text-align: center;height: 50px; overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
                    <b style="font-size: 20px">${item.topicTitle}</b>
                </div>
                <div class="col-lg-2" style="text-align: center;padding-right: 0px">
                    <button class="button button-rounded" style="height: 48px;width: 100%"><a href="/CIMS/forumInfo?id=${item.id}">查看详情</a></button>
                </div>
            </div>
        </c:forEach>

        <div class="row">
            <div class="col-lg-12" style="text-align: center;height: 50px">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${forumVo.page.currentPage == 1}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${forumVo.page.currentPage != 1}">
                        <li>
                        </c:if>
                            <a href="/CIMS/forumList?boardId=2&page.currentPage=${forumVo.page.currentPage - 1}&page.row=5" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach var="item" begin="1" end="${forumVo.page.totalPages}" varStatus="status">
                            <c:if test="${status.count == forumVo.page.currentPage}">
                                <li class="active">
                            </c:if>
                            <c:if test="${status.count != forumVo.page.currentPage}">
                                <li>
                            </c:if>
                            <a href="/CIMS/forumList?boardId=2&page.currentPage=${status.count}&page.row=5">${status.count}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${forumVo.page.currentPage == forumVo.page.totalPages}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${forumVo.page.currentPage != forumVo.page.totalPages}">
                        <li>
                            </c:if>
                            <a href="/CIMS/forumList?boardId=2&page.currentPage=${forumVo.page.currentPage + 1}&page.row=5" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

    </div>
</body>
</html>