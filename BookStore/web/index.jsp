<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<jsp:forward page="/jsps/main.jsp" />--%>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
    <link href="css/style_1.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <%--<script>var __links = document.querySelectorAll('a');function __linkClick(e) --%>
    <%--{ parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>--%>
    <script src="js/jquery.min.js"></script>
    <script>$(document).ready(function(c) {
        $('.alert-close').on('click', function(c){
            $('.message').fadeOut('slow', function(c){
                $('.message').remove();
            });
        });
    });
    </script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>Lanou书城欢迎您!</h1>
            <div class="alert-close"> </div>
        </div>
        <form>
            <button type="button" class="btn btn-success">
                <a href="/jsps/user/regist.jsp">用户注册页面</a>
            </button>
            <br>
            <button type="button" class="btn btn-info">
            <a href="/jsps/user/login.jsp">用户登录页面</a> <br>
            </button>
            <button type="button" class="btn btn-primary">
            <a href="/jsps/main.jsp">LanOu书城</a>
            </button>




        </form>
    </div>
</div>
</div>
</body>
</html>