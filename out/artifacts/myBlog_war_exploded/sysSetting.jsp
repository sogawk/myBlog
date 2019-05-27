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
    @import "css/sysSetting.css";

</style>
<head>
    <title>系统设置</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        系统设置
    </div>
    <div id="div4">
        <span>
        <div id="div41">
            <img src="/image/gerenxinxi.jpg" width="650px" alt="">
            <form action="UpdateUserServlet" method="post">
                <div class="ss"> 账号：<input type="text" value="${loginUser.name}"></div>
                <div class="ss"> 姓名：<input type="text" value="${loginUser.xingming}" name="xingming"></div>
                <div class="ss"> 邮箱：<input type="text" value="${loginUser.email}" name="email"></div>
            <div class="haha">
                <input type="image" src="/image/baocunxinxi.jpg">
            </div>
            </form>

        </div>
        <div id="div42">
            <img src="/image/xiugaimima.jpg" width="650px" alt="">
            <form action="UpdatePasswordServlet" method="post">
                <div class="ss"> 输入旧密码：<input type="text" name="oldPass"></div>
                <div class="ss"> 输入新密码：<input type="text" name="newPass"></div>
                <div class="ss"> 确认新密码：<input type="text" name="rePass"></div>
            <div class="haha">
                <input type="image" src="/image/shezhimima.jpg">
            </div>
            </form>
        </div>
        </span>
    </div>
</div>
</body>
</html>
