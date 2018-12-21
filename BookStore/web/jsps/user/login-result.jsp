<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/5
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录结果页面</title>
</head>
<body>
<h1 style="color: darkorange">${result}</h1>
<h1 style="color: red">${error}</h1>
<a href="${path}"><font>5</font>${message}</a>
</body>
<script>
    var font = document.getElementsByTagName('font')[0];
    var i = 5;
    var interval = setInterval(function () {

        if(i == 0){
            i = 5;
        }
        font.innerHTML = --i;
    },1000);
</script>
</html>
