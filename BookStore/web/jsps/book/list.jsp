  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
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
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

  <div id="body"></div>
  </body>


  <script>
      <%-- 全部分类发送的请求--%>
      $(function () {
          let url = '<%=request.getContextPath()%>/s/category/book?cid=<%=request.getParameter("cid")%>';
          console.log(url);
          if ("<%=request.getParameter("cid")%>" == 0){


              let url = <%=request.getContextPath()%>"/book/list";

              $.get(url,examine);



      function examine(resp) {
          if (resp.status === 200){


              var items = resp.data.items;
              var body = $('#body');

              for (var item of items) {

                  var bid = item.bid;
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
                  var a = $('<a href="desc.jsp?path='+path+'&name='+name+'&price='+price+'&author='+author+'&cid='+cid+'&cname='+cname+'&bid='+bid+'"></a>')
                  <%--let img = $('<img src="<%=request.getContextPath()%>/book-image/'+item.image+'"/><br>');--%>
                  let img = $('<img style="width: 108px; height: 150px" src="'+path+'"/><br>');
                  a.append(img);
                  div.append(a);


                  var aa = $('<a href="desc.jsp?path='+path+'&name='+name+'&price='+price+'&author='+author+'&cid='+cid+'&cname='+cname+'&bid='+bid+'"></a>').text(name);
                  div.append(aa);

                  body.append(div);
              }
          }

      }


      }

//     个别分类发送的请求

          $.get(url,function(resp){
              /*for(var a of resp){
               console.log(a);
               }*/
              var bbody = $('#body');
              bbody.empty();
              for(var i=0;i<resp.length;i++){
                 var item = resp[i];


                  var bid = item.bid;
                  var path = '<%=request.getContextPath()%>/book-image/' + item.image;
                  var name = item.bname;
                  var price = item.price;
                  var author = item.author;
                  var cid = item.cid;




                  var div = $('<div></div>');
                  div.addClass('icon');
                  var a = $('<a href="desc.jsp?path=' + path + '&name=' + name + '&price=' + price + '&author=' + author + '&cid=' + cid + '&bid='+bid+'"></a>')
                  <%--let img = $('<img src="<%=request.getContextPath()%>/book-image/'+item.image+'"/><br>');--%>
                  let img = $('<img style="width: 108px; height: 150px" src="' + path + '"/><br>');
                  a.append(img);
                  div.append(a);


                  var aa = $('<a href="desc.jsp?path=' + path + '&name=' + name + '&price=' + price + '&author=' + author + '&cid='+cid+'&bid='+bid+'"></a>').text(name);

                  div.append(aa);

                  bbody.append(div);

              }
          })



      })



</script>
</html>