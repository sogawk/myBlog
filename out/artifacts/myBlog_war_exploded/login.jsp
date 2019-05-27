<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/10
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = null;
    String password = null;
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("loginUser")) {
            String temp = URLDecoder.decode(cookie.getValue(), "utf8");
            name = temp.split("-")[0];
            password = temp.split("-")[1];
            request.setAttribute("name", name);
            request.setAttribute("password", password);
        }
    }

%>
<html>
<style>
    @import "css/login.css";

</style>
<head>
    <title>登陆</title>
</head>
<body>
<div id="div1">

    <div id="div2">
        <form action="LoginServlet" method="post">
            <center>
                <input type="text" name="name" class="input" id="inputName" value="${name}" placeholder="用户名："><br/>
                <input type="password" name="password" class="input" value="${password}" placeholder="密码："><br/><br/>
            </center>
            <input type="checkbox" id="check1" name="ck" checked="checked">记住密码 <br/>
            <center>
                <input type="image" src="image/loginButton.jpg" width="400px">
            </center>
        </form>
    </div>

</div>
</body>
</html>
