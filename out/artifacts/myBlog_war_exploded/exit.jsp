<%@ page import="back.service.SysNoteService" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/19
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.invalidate();
    SysNoteService sysNoteService=new SysNoteService();
    sysNoteService.addSysNote("退出系统");
%>

<c:redirect url="login.jsp"/>
</body>
</html>
