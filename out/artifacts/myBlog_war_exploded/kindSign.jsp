<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/13
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    @import "css/kindSign.css";

</style>
<head>
    <title>分类/标签</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        分类/标签管理
    </div>
    <div id="div4">
        <span>
        <div id="div41">
            <img src="/image/fenleiliebiao.jpg" width="650px" alt="">
            <c:forEach items="${kindList}" var="item">
                ${item.name}(${item.number})&nbsp;
            </c:forEach>
        </div>
        <div id="div42">
            <img src="/image/biaoqianliebiao.jpg" width="650px" alt="">
            <c:forEach items="${signList}" var="item">
                ${item.name}(${item.number}) &nbsp;
            </c:forEach>
        </div>
        </span>
        <div id="div5">
            <form action="AddKindSignServlet" method="post">
                <div><input type="text" id="input1" name="kind" height="40px"></div>
                <div><input type="image" src="/image/baocunfenlei.jpg" id="input2"></div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
