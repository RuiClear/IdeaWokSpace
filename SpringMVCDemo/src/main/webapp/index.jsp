<%--
  Created by IntelliJ IDEA.
  User: RuiClear
  Date: 2018/1/26
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <a href="/say">HelloWorld!</a>
  <form method="post" action="/delete/2">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="提交">
  </form>
 </body>
</html>
