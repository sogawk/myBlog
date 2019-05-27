<%@ page import="java.util.List" %>
<%@ page import="back.bean.Pagebean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/13
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%
    Pagebean pagebean = (Pagebean) request.getSession().getAttribute("friendLinkPagebean");
    System.out.println("friendLinkPagebean=" + pagebean.getList());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    @import "../../css/friend.css";

</style>
<head>
    <title>友链管理</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        友链管理hahah
    </div>
    <div id="div4">
        <table border="1" cellspacing="0" width="100%">
            <tr>
                <td>链接名称</td>
                <td>链接地址</td>
                <td>链接LOGO</td>
                <td>链接排序</td>
                <td>操作</td>
            </tr>
            <c:forEach var="item" items="${friendLinkPagebean.list}">
                <tr>
                    <td height="50px">${item.name}</td>
                    <td>${item.address}</td>
                    <td></td>
                    <td>${item.id}</td>

                    <td><a href="DeleteFriendLinkServlet?id=${item.id}"><img src="../../image/deleteFriend.jpg" alt=""
                                                                             height="40px"></a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="div5">
        <img src="/image/baocunyoulilan.jpg" width="1320px" alt="">

        <form action="/AddFriendLinkServlet" method="post">
            <div id="div51">
                <input type="text" name="title" placeholder="输入友链名称">
                <input type="text" name="address" placeholder="输入友链地址">
                <input type="text" name="logo" placeholder="输入友链logo">
                <input type="text" name="turn" placeholder="输入友链排序">
            </div>
            <div id="div52">
                <input type="image" height="40px" src="/image/baocunlianjie.jpg">
            </div>
        </form>

    </div>
</div>
</body>
</html>