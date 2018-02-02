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
    <script type="text/javascript" src="/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#json").click(function(){
                var url = this.href;
                var args = {};
                $.post(url, args, function(data){
                    for(var i = 0; i < data.length; i++){
                        var id = data[i].id;
                        var name = data[i].name;

                        alert(id + ": " + name);
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>
  <a href="/say">HelloWorld!</a>
  <form method="post" action="/delete/2">
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="提交">
  </form>
  <a href="/hello/1.3/ruiClear">hello</a>
  <a href="/session">session</a>
 </body>

<form method="post" action="/testModel?id=1">
    UserName:<input type="text" name="name" value="rui"><br>
    UserAge:<input type="text" name="age" value="21"><br>
    <input type="submit" value="提交">
</form>
<a href="/testhello">testhello</a>

<a href="/json" id="json">Test Json</a>
</html>
