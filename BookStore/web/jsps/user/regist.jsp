<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>注册</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script type="application/javascript" src="../../js/jquery-3.3.1.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/body.css"/>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->


</head>

<body>

<div class="container">
    <section id="content">
        <form action="/user/register" method="post">
            <h1>会员登录</h1>
            <div>
                <input type="hidden" name="method" value="regist"/>
                用户名&emsp;：<input type="text" placeholder="用户名" name="username" id="username" required="required"/>
                <span id="user_error" style="color: #ff0000;display: none">用户名长度必须为6~16位</span>
                <span id="user_ok" style="color: aquamarine ;display: none">用户名格式正确</span>
            </div>
            <div>
                密&emsp;&emsp;码：<input type="password" placeholder="密码" name="password" id="password"
                                      required="required"/>
            </div>
            <div>
                确认密码：<input type="password" name="password" id="repeat" required="required"/>
                <span id="repeat_error" style="color: #ff0000;display: none">两次密码输入不一致</span>
                <span id="ok" style="color: aquamarine ;display: none">两次密码输入一致</span>
            </div>
            <div>
                邮&emsp;&emsp;箱：<input type="email" name="email" id="email" value="" required="required"/>
                <span id="mail_error" style="display: none;color: red"></span>
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpin">&nbsp;</span></div>
            <div>
                <input type="submit" value="注册" class="btn btn-primary" id="js-btn-login"/>
            </div>
        </form>
        <div class="button">
            <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>

        </div>
    </section>
</div>
</body>
<script>
    $(function () {
        var username = document.getElementById("username");
        var user_error = document.getElementById("user_error");
        var user_ok = document.getElementById("user_ok");
        var password = document.getElementById("password");
        var repeat = document.getElementById("repeat");
        var repeat_error = document.getElementById("repeat_error");
        var ok = document.getElementById("ok");


        var btn =  $('#js-btn-login');




        username.onfocus = function () {
            user_error.style.display = 'none';
            user_ok.style.display = 'none';
        }

        username.onblur = function () {
            var text = username.value;

            if (text.length < 6 || text.length > 16) {
                user_error.style.display = 'inline';
               btn.prop("disabled",true);

            } else {
                user_ok.style.display = 'inline';
               btn.prop("disabled",false);
            }

        }

        password.onfocus = function () {
            repeat_error.style.display = 'none';
            ok.style.display = 'none';

        }

        password.onblur = function () {
            var pass = password.value;
            var rep = repeat.value;

            if (pass != rep) {
                repeat_error.style.display = 'inline';
                btn.prop("disabled",true);
            } else if (pass.length != 0) {
                ok.style.display = 'inline';
                btn.prop("disabled",false);
            }

            if (pass.length == 0) {
                alert('密码不能为空')
            }
        }


        repeat.onfocus = function () {
            repeat_error.style.display = 'none';

        }


        repeat.onblur = function () {
            var pass = password.value;
            var rep = repeat.value;

            if (pass != rep) {
                repeat_error.style.display = 'inline';
                btn.prop("disabled",true);
            }else if (pass.length != 0) {
                ok.style.display = 'inline';
                btn.prop("disabled",false);
            }
        }




    });
</script>

</html>
