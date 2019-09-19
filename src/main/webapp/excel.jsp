<%--
  Created by IntelliJ IDEA.
  User: 李靖宇
  Date: 2019/9/19
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
    <script>
        $(function () {
           $("#doExport").click(function () {
               window.location.href="${pageContext.request.contextPath}/excel/export"
           });
        });
    </script>
</head>
<body>
    <button id="doExport">导出</button>
</body>
</html>
