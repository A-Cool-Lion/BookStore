<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 190px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body id="body">
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Java就业培训教程</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">精通Hibernate</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/9265169-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Head First java</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Java编程思想（第4版）</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">精通Spring2.x </a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/20285763-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Java核心技术卷1</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/20385925-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Struts2深入详解</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/22722790-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">Javascript权威指南</a>--%>
  <%--</div>--%>
   <%--<div class="icon">--%>
    <%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>"><img src="<c:url value='/book_img/22788412-1_l.jpg'/>" border="0"/></a>--%>
      <%--<br/>--%>
   	<%--<a href="<c:url value='/adminjsps/admin/category/desc.jsp'/>">JavaWeb开发详解</a>--%>
  <%--</div>--%>
  
  </body>

  <script>
      $(function () {
        let url = <%=request.getContextPath()%>"/book/list";

        $.get(url,examine);


      })

      function examine(resp) {
          if (resp.status === 200){


              var items = resp.data.items;
              var body = $('#body');

              for (var item of items) {

                  var path = '<%=request.getContextPath()%>/book-image/'+item.image;
                  var name = item.bname;
                  var price = item.price;
                  var author = item.author;
                  var cid = item.cid;
                  console.log(cid);
                  var cname = item.cname;
                  console.log(cname);


                  var div = $('<div></div>');
                  div.addClass('icon');
                  var a = $('<a href="desc.jsp?path='+path+'&name='+name+'&price='+price+'&author='+author+'&cid='+cid+'&cname='+cname+'"></a>')
                  <%--let img = $('<img src="<%=request.getContextPath()%>/book-image/'+item.image+'"/><br>');--%>
                  let img = $('<img style="width: 108px; height: 150px" src="'+path+'"/><br>');
                  a.append(img);
                  div.append(a);


                  var aa = $('<a href="desc.jsp?path='+path+'&name='+name+'&price='+price+'&author='+author+'"></a>').text(name);
                  div.append(aa);

                  body.append(div);
              }
          }

      }



  </script>

</html>

