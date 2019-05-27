<%@ page import="back.bean.Pagebean" %>
<%@ page import="back.bean.Blog" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/19
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    @import "css/front.css";
</style>
<head>
    <title>MyBlog</title>
</head>
<body>
<div id="all">
    <div id="title">
        <img src="/image/logoWhite.jpg" height="100px" alt="">
        My Blog
        <a href="DashBoardServlet"><img id="img2" src="image/menu.jpg" alt=""></a>
        <a href="exit.jsp"><img id="img3" src="image/out.jpg" alt="退出登录"></a>
    </div>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(0).id}">
        <div id="div1" class="main">
            <div>${blogPagebean.list.get(0).title}</div>
        </div>
    </a>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(1).id}">
        <div id="div2" class="main">
            <div>${blogPagebean.list.get(1).title}</div>
        </div>
    </a>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(2).id}">
        <div id="div3" class="main">
            <div>${blogPagebean.list.get(2).title}</div>
        </div>
    </a>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(3).id}">
        <div id="div4" class="main">
            <div>${blogPagebean.list.get(3).title}</div>
        </div>
    </a>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(4).id}">
        <div id="div5" class="main">
            <div>${blogPagebean.list.get(4).title}</div>
        </div>
    </a>
    <a href="ArticleDisplayServlet?blogId=${blogPagebean.list.get(5).id}">
        <div id="div6" class="main">
            <div>${blogPagebean.list.get(5).title}</div>
        </div>
    </a>
</div>
</body>
</html>
