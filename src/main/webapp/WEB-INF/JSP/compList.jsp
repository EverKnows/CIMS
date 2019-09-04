<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>竞赛列表</title>
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
<button id="selectBtn" class="button button-3d" style="float: right">收缩</button>
<div class="filterBox">
<form id="data"  method="get" action="/CIMS/complist">
    <label>&nbsp;&nbsp;比赛级别:</label>
    <div class="radio">
        <label><input type="radio" name="level" value="default" class="queryItem" ${compList.level eq "default" ? "checked":""}> 全部</label>
        <label><input type="radio" name="level" value="province" class="queryItem" ${compList.level eq "province" ? "checked":""}> 省级</label>
        <label><input type="radio" name="level" value="school" class="queryItem" ${compList.level eq "school" ? "checked":""}> 校级</label>
        <label><input type="radio" name="level" value="college" class="queryItem" ${compList.level eq "college" ? "checked":""}> 院级</label>
    </div>
    <label>&nbsp;&nbsp;时间:</label>
    <div class="radio">
        <label><input type="radio" name="time" value="default" class="queryItem" ${compList.time eq "default" ? "checked":""}> 全部</label>
        <label><input type="radio" name="time" value="signup" class="queryItem" ${compList.time eq "signup" ? "checked":""}> 正在报名</label>
        <label><input type="radio" name="time" value="match" class="queryItem" ${compList.time eq "match" ? "checked":""}> 正在比赛</label>
    </div>
    <label>&nbsp;&nbsp;排序:</label>
    <div class="radio">
        <label><input type="radio" name="order" value="default" class="queryItem" ${compList.order eq "default" ? "checked":""}> 默认</label>
        <label><input type="radio" name="order" value="new" class="queryItem" ${compList.order eq "new" ? "checked":""}> 最新</label>
        <label><input type="radio" name="order" value="long" class="queryItem" ${compList.order eq "long" ? "checked":""}> 最久</label>
    </div>
</form>
</div>
<hr>

<div class="container">
    <c:forEach var="item" varStatus="status" items="${compList.compList}">
        <div class="row" style="padding:3px;border-left: gainsboro solid 1px;border-bottom: gainsboro solid 1px;border-top: gainsboro solid 1px">
            <div class="col-lg-2" style="padding: 3px">
                <img src="/CIMS/IMG/match1.jpg" class="img-rounded " width="100%" height="170px">
            </div>
            <div class="col-lg-4" style="padding: 3px;height: 176px;text-align: center">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist" >
                    <li role="presentation" class="active"><a href="#home${status.index}" aria-controls="home" role="tab" data-toggle="tab">简介</a></li>
                    <li role="presentation"><a href="#profile${status.index}" aria-controls="profile" role="tab" data-toggle="tab">比赛时间</a></li>
                    <li role="presentation"><a href="#messages${status.index}" aria-controls="messages" role="tab" data-toggle="tab">其他信息</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content" style="height: 78%;overflow: auto;" >
                    <div role="tabpanel" class="tab-pane active" id="home${status.index}">
                        <p>
                            ${item.introducation}
                        </p>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile${status.index}">
                        <p>
                            报名开始时间:${item.signUpStart}<br>
                            报名结束时间:${item.signUpEnd}<br>
                            比赛开始时间:${item.compStart}<br>
                            比赛结束时间：${item.compEnd}<br>
                        </p>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="messages${status.index}">
                        <p>
                            举办方:${item.organizer}<br>
                            学历限制:${item.eduLimit}<br>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-3" style="height: 100%;text-align: right;height: 176px;">
                <button type="button" class="button button-block " style="margin-top: 16%; display: inline-block;height: 50%;width: 60%">
                    <a href="/CIMS/teamlist?id=${item.id}&page.row=5&page.currentPage=1"><b>加入队伍</b></a>
                </button>
            </div>
            <div class="col-lg-3" style="height: 100%;text-align: center;height: 176px">
                <button type="button" class="button button-block " style="margin-top: 16%; display: inline-block;height: 50%;width: 60%">
                    <a href="/CIMS/createTeam?compId=${item.id}"><b>创建队伍</b></a>
                </button>
            </div>


        </div>
    </c:forEach>
    <div class="row">
        <div class="col-lg-12" style="text-align: center;height: 50px">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:if test="${compList.page.currentPage == 1}">
                        <li class="disabled">
                    </c:if>
                    <c:if test="${compList.page.currentPage != 1}">
                        <li>
                    </c:if>
                        <a href="/CIMS/complist?page.currentPage=${compList.page.currentPage - 1}&page.row=5" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="item" begin="1" end="${compList.page.totalPages}" varStatus="status">
                        <c:if test="${status.count == compList.page.currentPage}">
                            <li class="active">
                        </c:if>
                        <c:if test="${status.count != compList.page.currentPage}">
                            <li>
                        </c:if>
                        <a href="/CIMS/complist?page.currentPage=${status.count}&page.row=5">${status.count}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${compList.page.currentPage == compList.page.totalPages}">
                        <li class="disabled">
                    </c:if>
                    <c:if test="${compList.page.currentPage != compList.page.totalPages}">
                        <li>
                    </c:if>
                        <a href="/CIMS/complist?page.currentPage=${compList.page.currentPage + 1}&page.row=5" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>

<<script type="text/javascript">
    $(".queryItem").bind("ifChecked",function() {
        $("#data").submit();
    })
</script>
</body>
</html>