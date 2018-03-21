<%@ page import="com.yx.po.Myuser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>檀香小筑</title>
    <link rel="shortcut icon" href="images/favicon.png">
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/focus.js"></script>
</head>

<body>
<div class="head">
    <div class="top w1200 fn-clear">
        <div class="logo"><img src="images/logo.fw.png" width="190" height="60"  alt=""/></div>
        <div class="nav">
            <ul class="fn-clear"><!--版头-->
                <li><a href="./index.jsp">首页</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=1&&page=1">网络文学</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=2&&page=1">小说</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=3&&page=1">文艺</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=4&&page=1">人文社科</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=5&&page=1">童书</a></li>
                <li><a href="/book?type=manyBook&&bigCateId=6&&page=1">生活</a></li>
            </ul>
        </div>
        <div class="searchbox">
            <form action="#" method="post"><!--搜索框-->
                <input type="text" name="keywords" class="searchtext" placeholder="请输入关键词" />
                <button type="submit" class="searchbut"></button>
            </form>
        </div>
        <%
            Myuser myuser = (Myuser) session.getAttribute("user");
            if (myuser == null) {   //没有登录
        %>
        <div class="uinfo"><!--登录注册链接-->
            <a href="./login.jsp">登录</a> |
            <a href="./register.jsp">注册</a>
        </div>
        <%
        } else { //已登录
        %>
        <div class="uinfo">
            <span><%=myuser.getUserName()%> | <a href="/user?action=logout" id="logout">注销</a></span>
        </div>
        <%
            }
        %>
    </div>
</div>
</body>
</html>