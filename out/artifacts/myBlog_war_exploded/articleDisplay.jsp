<%@ page import="back.bean.Blog" %>
<%@ page import="back.service.BlogService" %>
<%@ page import="back.bean.Pagebean" %>
<%@ page import="java.util.List" %>
<%@ page import="back.bean.Comment" %>
<%@ page import="back.service.UserService" %>
<%@ page import="back.bean.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/16
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    @import "css/articleDisplay.css";
</style>
<head>
    <title>Title</title>
</head>
<body>
<div id="all">
    <div id="title">
        <img src="/image/logoWhite.jpg" height="100px" alt="">
        My Blog
    </div>
    <div id="page">
        <div id="pageTitle">
            <div id="littleTitle">
                ${blog.title}
            </div>
            <div id="time">
                发布于${blog.creatTime}
            </div>
            <div id="sign">
                ${blog.sign}
            </div>
        </div>
        <hr color="black">
        ${blog.concent}
        <hr color="black"><br>
        <div id="comment">
            <%
                Pagebean pagebean= (Pagebean) request.getAttribute("pageBean");
                List list=pagebean.getList();
                for (Object item : list) {
                    Comment comment=(Comment)item;
                    UserService userService=new UserService();
                    User user=userService.getUser(comment.getUserId());
                    %>
            <%=user.getName()%> : <%=comment.getContent()%><br><br>
            <%
                }
            %>
        </div>
        <form action="AddCommentServlet?blogId=${blog.id}" method="post">
            <input type="text" name="content" id="input1" placeholder="在此输入你的评论">&nbsp;<input type="submit" value="提交">
        </form>
        <br>
    </div>


</div>
</body>
</html>
