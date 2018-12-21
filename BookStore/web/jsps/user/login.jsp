<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Lanou商城</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="../../css/style.css" />
	<link rel="stylesheet" type="text/css" href="../../css/body.css"/>
</head>
<body>

<div class="container">
	<section id="content">
		<form action="/user/login" method="post">
			<h1>会员登录</h1>
			<div>
				<input type="text" placeholder="用户名" required="" id="username" name="username" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" name="password" />
			</div>
			<div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>
			</div>
			<div>
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
				<a href="../../jsps/user/regist.jsp">注册</a>
			</div>
		</form>
		<div class="button">
			<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>

		</div>
	</section>
</div>

</body>
</html>