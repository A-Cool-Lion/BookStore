<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/9/5
  Time: 上午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果页</title>
</head>
<body>
<h1 style="color: darkorange">${re}</h1>
<a href="${p}"><font>5</font>${m}</a>
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
