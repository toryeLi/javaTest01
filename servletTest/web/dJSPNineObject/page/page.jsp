<%--
  Created by IntelliJ IDEA.
  User: Torey
  Date: 2018/6/27
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>存入内容</title>
</head>
<body>
ddd
<%
 pageContext.setAttribute("pc","pageContext的ss内容");
%>
<%
//重定向
response.sendRedirect("result.jsp");
//request.getRequestDispatcher("result.jsp").forward(request,response);

%>
</body>
</html>
