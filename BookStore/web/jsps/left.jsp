<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lanou.bookstore.category.domain.CategoryBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    <base target="body"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script src="/js/jquery-3.3.1.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
			text-align: center;
		}
		div {
			background: #87CEFA; 
			margin: 3px; 
			padding: 3px;
		}
		a {
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
<div>
	<a href="<c:url value='/jsps/book/list.jsp?cid=0'/>">全部分类</a>
</div>

<%
	List<CategoryBean> categoryList = (List<CategoryBean>) session.getAttribute("categorylist");
	for (int i = 0; i < categoryList.size(); i++) {
		int cId = categoryList.get(i).getcId();
		String cname = categoryList.get(i).getcName();
		session.setAttribute("cIdkey", cId);
		session.setAttribute("cName",cname);
%>
<div>
	<a href="/jsps/book/list.jsp?cid=${cIdkey}">${cName}</a>
</div>
<%}%>

<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">JavaSE分类</a>--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">JavaEE分类</a>--%>
<%--</div>--%>
<%--<div>--%>
	<%--<a href="<c:url value='/jsps/book/list.jsp'/>">Javascript分类</a>--%>
<%--</div>--%>
  </body>





</html>
