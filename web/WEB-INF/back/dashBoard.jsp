<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 2019/5/12
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
@import "../../css/dashBoard.css";
</style>
<head>
    <title>后台</title>
</head>
<body>
<div id="all">
    <c:import url="backIndex.jsp"/>
    <div id="div3">
        Tale 仪表盘
    </div>
    <div id="div4">

        <a href="SelectBlogServlet">
            <div id="div4-1" class="div4--">
                <div>发表了 <br> <span>${blogNumber}</span> <br>篇文章</div>
            </div>
        </a>
        <a href="comments.jsp">
            <div id="div4-2" class="div4--">
                <div>收到了 <br> <span>${commentNumber}</span> <br>条留言</div>
            </div>
        </a>
        <a href="#">
            <div id="div4-3" class="div4--">
                <div>上传了 <br> <span>0</span> <br>个附件</div>
            </div>
        </a>
        <a href="SelectFriendLinkServlet">
            <div id="div4-4" class="div4--">
                <div>友链了 <br> <span>${linkNumber}</span> <br>个好友</div>
            </div>
        </a>

    </div>
    <div id="div5" class="xia">
        <span class="span1">最新文章</span>
        <div>
            <table border="1" width="100%" height="250px">
                <c:forEach var="item" items="${blogPagebean.list}">
                    <tr>
                        <td>
                            <a href="ArticleDisplayServlet?blogId=${item.id}"> ${item.title}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="div6" class="xia">
        <span class="span1">最新留言</span>
        <div>
            <table border="1" width="100%" height="250px">
                <c:forEach var="item" items="${commentPageBean.list}">
                    <tr>
                        <td>
                            <a href="ArticleDisplayServlet?blogId=${item.tableId}">${item.content}</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <div id="div7" class="xia">
        <span class="span1">系统日志</span>
        <div>
            <table border="1" width="100%" height="250px">
                <c:forEach var="item" items="${sysNotePagebean.list}">
                    <tr>
                        <td>
                            ${item.time} : ${item.content}
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</div>

</body>
</html>
