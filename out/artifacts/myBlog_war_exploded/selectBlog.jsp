<%@ page import="back.bean.Pagebean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/13
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Pagebean pagebean = (Pagebean) request.getSession().getAttribute("articalPagebean");
    int totalPage = pagebean.getTotalPage();
%>
<style>
    @import "css/selectBlog.css";

</style>
<head>
    <title>文章管理</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        文章管理
    </div>
    <div id="div4">
        <table border="1" cellspacing="0" width="100%" bgcolor="white">
            <tr>
                <td>文章标题</td>
                <td>发布时间</td>
                <td>浏览量</td>
                <td>所属分类</td>
                <td>发布状态</td>
                <td>操作</td>

            </tr>
            <c:forEach var="item" items="${articalPagebean.list}">
                <tr>
                    <td height="70px">${item.title}</td>
                    <td>${item.creatTime}</td>
                    <td>${item.views}</td>
                    <td>${item.kind}</td>
                    <td>
                        <img src="/image/yifabu.jpg" alt="">
                    </td>
                    <td>
                        <a href="SelectKindSignServlet?blogId=${item.id}"><img src="/image/bianji.jpg" alt=""></a>
                        <a href="DeleteBlogServlet?blogId=${item.id}"><img src="/image/shanchu.jpg" alt=""></a>
                        <a href="ArticleDisplayServlet?blogId=${item.id}"><img src="/image/yulan.jpg" alt=""></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <center>
            <span>
                <a href="SelectBlogServlet?pagenumber=<%=pagebean.getCurrentPage()-1%>">上一页</a>&nbsp;
                当前为${articalPagebean.currentPage}/${articalPagebean.totalPage}&nbsp;
                <a href="SelectBlogServlet?pagenumber=<%=pagebean.getCurrentPage()+1%>">下一页</a>&nbsp;
                <%

                    for (int i = 1; i <= totalPage; i++) {
                %>
                        <a href="SelectBlogServlet?pagenumber=<%=i%>"><%=i%></a>&nbsp;
                <%
                    }
                %>
            </span>
        </center>
    </div>
</div>
</body>
</html>
