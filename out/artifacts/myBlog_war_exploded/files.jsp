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
    @import "css/files.css";

</style>
<head>
    <title>文件管理</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        文件管理
    </div>
    <fieldset id="div4">
        <form action="/AddFilesServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="files">
            <input type="submit">
        </form>
    </fieldset>
    <div id="div5">

    </div>
</div>
</body>
</html>
