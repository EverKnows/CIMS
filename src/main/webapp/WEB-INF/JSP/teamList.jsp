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
    <meta charset="UTF-8">
    <title>队伍信息</title>
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
        <div class="col-lg-offset-4 col-lg-4" style="text-align: center">
            <h3>队伍列表</h3>
        </div>
    </div>
    <c:forEach varStatus="status" items="${teamList.teamList}" var="item">
        <div class="row" style="border: gainsboro solid 1px;margin: 5px">
                <div class="col-lg-4" style="padding: 10px;text-align: center;height: 50px;border-right: gainsboro solid 1px; overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
                    <b style="font-size: 20px">${item.teamName}</b>
                </div>
                <div class="col-lg-6" style="padding: 10px;text-align: center;height: 50px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
                    <i name="username" style="font-size: 20px">队长:${teamList.userNameList[status.index]}</i>
                </div>
                <div class="col-lg-2" style="text-align: center;padding-right: 0px">
                    <button type="button" id="joinBtn" onclick="joinTeam(${item.id})"  class="button button-rounded" style="height: 50px;width: 100%">立即加入</button>
                </div>
        </div>
    </c:forEach>
    <div class="row">
        <div class="col-lg-12" style="text-align: center;height: 50px">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${teamList.page.currentPage == 1}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${teamList.page.currentPage != 1}">
                    <li>
                        </c:if>
                        <a href="/CIMS/teamlist?id=1&page.currentPage=${teamList.page.currentPage - 1}&page.row=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="item" begin="1" end="${teamList.page.totalPages}" varStatus="status">
                        <c:if test="${status.count == teamList.page.currentPage}">
                            <li class="active">
                        </c:if>
                        <c:if test="${status.count != teamList.page.currentPage}">
                            <li>
                        </c:if>
                        <a href="/CIMS/teamlist?id=1&page.currentPage=${status.count}&page.row=5">${status.count}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${teamList.page.currentPage == teamList.page.totalPages}">
                    <li class="disabled">
                        </c:if>
                        <c:if test="${teamList.page.currentPage != teamList.page.totalPages}">
                    <li>
                        </c:if>
                        <a href="/CIMS/teamlist?id=1&page.currentPage=${teamList.page.currentPage + 1}&page.row=5" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script>
    function joinTeam(id) {
        $.ajax({
           type: "GET",
           data: "id=" + id,
           url: "/CIMS/jointeam",
            success: function(data) {
               if (data.status == "success") {
                   alert("成功加入队伍");
               } else {
                   alert(data.errorInfo);
               }
            },
            error: function(data)
            {
                alert("遇到未知的错误");
            }
        });
    }
</script>
</body>
</html>