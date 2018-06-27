<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-06-20
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<a href="/my?tokent=sfsfe12">get请s求</a>
<img src="/images/car.jpg">

<form action="/my" method="post">
<%--<form action="/my" method="post">--%>
    <p>编号1:<input type="text" name="disabledTest" value="URK0001121" disabled="disabled" /></p>
    <p>编号2:<input type="text" name="readonlyTest" value="URK0001121" readonly="readonly" /></p>
    <p>爱好: <select name="hobby" multiple="multiple" size="4">
        <option value="1">爱好1</option>
        <option value="2">爱好2</option>
        <option value="3">爱好3</option>
        <option value="4">爱好4</option>
    </select></p>
    <input type="submit" value="post请求">
</form>
</body>
</html>
