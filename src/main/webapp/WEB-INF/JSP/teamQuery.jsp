<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/7
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="<%=basePath%>/CSS/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="<%=basePath%>/JS/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="<%=basePath%>/JS/bootstrap.min.js"></script>
    <title>Query</title>

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
<hr>
<div class="container-fluid" style="margin-bottom:2%;width:40%;text-align: center">
<h1>队伍列表</h1>
</div>
    <%--<span style="float:left;" >--%>
        <%--<input class="btn btn-default" type="button" id="add" href="#" value="添加" >--%>
        <%--<input class="btn btn-default" type="button" onclick="confirmDeleteMore()" id="deleteSelect"  value="删除选中" >--%>
    <%--</span>--%>

<form action="<%=basePath%>deleteServlet" method="get" id="delForm">
<div class="container-fluid" style="width:80%">
<table class="table table-hover  table-condensed table-striped" style="width:100%;">
    <tr>
        <th class="col-1" style="text-align: center">姓名</th>
        <th class="col-1" style="text-align: center">年龄</th>
        <th class="col-1" style="text-align: center">性别</th>
        <th class="col-1" style="text-align: center">邮箱</th>
        <th class="col-1" style="text-align: center">QQ</th>
        <th class="col-1" style="text-align: center">电话号码</th>
        <th class="col-1" style="text-align: center">操作</th>
    </tr>

        <c:forEach items="${pageBean.list}" var="consumer" varStatus="status">
            <tr >
                <td class="col-1" style="text-align: center">${consumer.name}</td>
                <td class="col-1" style="text-align: center">${consumer.age}</td>
                <td class="col-1" style="text-align: center">${consumer.gender}</td>
                <td class="col-1" style="text-align: center">${consumer.email}</td>
                <td class="col-1" style="text-align: center">${consumer.qq}</td>
                <td class="col-1" style="text-align: center">${consumer.telephone}</td>
                <td  style="text-align: center">
                    <button class="btn btn-default"  id="reset${status.index}"  >修改</button>
                    <button class="btn btn-default"  id="delete${status.index}" onclick="confirmDelete('<%=basePath%>'+'deleteServlet?deletename='+'${consumer.name}')">删除</button>
                </td>
            </tr>
        </c:forEach>

</table>
</div>
</form>
<div class="container-fluid" style="width:30%;text-align: center;margin-left:35%;float:left">
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.currentPage == 1}">
                <li class="disabled">
            </c:if>
            <c:if test="${pageBean.currentPage != 1}">
                <li>
            </c:if>
                <a href="${pageContext.request.contextPath}/managerServlet?currentPage=${pageBean.currentPage - 1}&rows=5" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach begin="1" end="${pageBean.totalPage}" var="index" varStatus="status">
                <c:if test="${index == pageBean.currentPage}">
                    <li class="active">
                </c:if>
                <c:if test="${index != pageBean.currentPage}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/managerServlet?currentPage=${status.count}&rows=5">${index}</a>
                </li>
            </c:forEach>
                <c:if test="${pageBean.currentPage == pageBean.totalPage}">
                    <li class="disabled">
                </c:if>
                <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                    <li>
                </c:if>
                    <a href="${pageContext.request.contextPath}/managerServlet?currentPage=${pageBean.currentPage + 1}&rows=5" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

    <span style="float:left;width: 15%;padding: 1.5%">
        共${pageBean.totalRecord}条记录
    </span>

<script>

    function confirmDelete(path) {
        if (confirm("确定删除此条记录吗？")) {
            window.location.href = path;
        }
    }
    function confirmDeleteMore(event) {
        if(confirm("确定删除选中记录吗？")) {
            var btn = document.getElementById("delForm");
            btn.submit();
        }
    }
    function selectALL(obj) {

        var status = $(obj).prop("checked");
        $(".selNode").prop("checked", status);
    }
</script>
</body>
</html>
