<%@ page import="back.service.BlogService" %>
<%@ page import="back.bean.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="back.bean.KindOrSign" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/13
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    @import "../../css/addBlog.css";

</style>
<head>
    <title>文章</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <c:if test="${empty blogId}">
        <div id="div3">发布文章</div>
    </c:if>

    <c:if test="${not empty param.blogId}">
        <div id="div3">修改文章</div>
    </c:if>

    <div id="div4">
        <c:choose>
            <c:when test="${empty blogId}">
                <c:set var="urll" value="AddBlogServlet"/>
            </c:when>
            <c:otherwise>
                <%
                    String blogId = (String) request.getAttribute("blogId");
                    int id = Integer.parseInt(blogId);
                    System.out.println("blogId=" + id);
                    BlogService blogService = new BlogService();
                    Blog blog = blogService.getBlog(id);
                    request.setAttribute("bb", blog);
                %>
                <c:set var="urll" value="/UpdateBlogServlet?blogId=${blogId}"/>
            </c:otherwise>
        </c:choose>

        <form action="${urll}" method="post">
                <span>
                <input type="text" name="title" placeholder="标题" class="left" value="${bb.title}">
                    <input type="text" name="way" placeholder="路径"><br>
                <input type="text" name="sign" placeholder="标签" class="left" value="${bb.sign}">
                    <select name="kind" id="kind">
                        <c:forEach items="${kindList}" var="item">
                            <option value="${item.name}">${item.name}</option>
                        </c:forEach>
                    </select>
                </span>
            <div id="div41">
                <textarea name="content" id="" cols="130" rows="15">${bb.concent}</textarea>
            </div>
            <div id="div42">
                <input type="image" src="/image/baocunwenzhang.jpg" width="100px">
                <a href="selectBlog.jsp"><img src="/image/fanhiuliebiao.jpg" width="100px" alt=""></a>
                <a href="#"><img src="/image/cunwei.jpg" width="100px" alt=""></a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
