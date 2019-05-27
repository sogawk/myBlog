<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/11
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
@import "css/backIndex.css";
</style>
<head>
    <title>后台</title>
</head>
<body>
<div id="div1">
    <img src="image/aaaa.jpg" alt="" height="120px">
    <a href="FrontDeskServlet"><img id="img2" src="image/menu.jpg" alt=""></a>
    <a href="exit.jsp"><img id="img3" src="image/out.jpg" alt="退出登录"></a>
</div>
<div id="div2">
    <a href="DashBoardServlet"><img src="image/wei-1-yibiaopan.jpg" class="wei-1" alt=""></a>
    <a href="SelectKindSignServlet?pathh=1"><img src="image/wei-1-fabuwenzhang.jpg" class="wei-1" alt=""></a>
    <a href="/SelectBlogServlet"><img src="image/wei-1-wenzhangguanli.jpg" class="wei-1" alt=""></a>
    <%--<a href="page.jsp"><img src="../image/wei-1-yemianguanli.jpg" class="wei-1" alt=""></a>--%>
    <%--<a href="comments.jsp"><img src="image/wei-1-pinglunguanli.jpg" class="wei-1" alt=""></a>--%>
    <a href="SelectKindSignServlet"><img src="image/wei-1-fenleibiaoqian.jpg" class="wei-1" alt=""></a>
    <a href="files.jsp"><img src="image/wei-1-wenjianguanli.jpg" class="wei-1" alt=""></a>
    <a href="SelectFriendLinkServlet"><img src="image/wei-1-youlian.jpg" class="wei-1" alt=""></a>
    <a href="sysSetting.jsp"><img src="image/wei-1-xitongshezhi.jpg" class="wei-1" alt=""></a>
</div>

<div id="div8">
    &nbsp;2019 @Mr xu
</div>
</body>
</html>
