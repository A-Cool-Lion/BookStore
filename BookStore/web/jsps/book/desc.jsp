<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书详细</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <style type="text/css">
        body {
            font-size: 10pt;
        }

        div {
            margin: 20px;
            border: solid 2px gray;
            width: 150px;
            height: 150px;
            text-align: center;
        }

        li {
            margin: 10px;
        }

        a {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -70px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        a:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -106px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }
    </style>
</head>

<body>
<div>
    <img style="width: 108px; height: 150px" src="<c:url value='<%=request.getParameter("path")%>'/>" border="0"/>
</div>
<ul>
    <li style="display: none" id="bid"><%=request.getParameter("bid")%></li>
    <li>书名：<%=request.getParameter("name")%></li>
    <li>作者：<%=request.getParameter("author")%></li>
    <li>单价：<%=request.getParameter("price")%></li>
</ul>
<form id="form" action="/cart/add" method="post">
    <input type="text" size="3" name="amount" required="required" value="1" id="count" style="width:50px"/>
    <%--<input type="text" name="amount" onBlur="this.value=parseInt(this.value);if (isNaN(this.value) || this.value<=0){alert('输入错误');this.focus();};">--%>
    <input type="hidden" value="<%=request.getParameter("path")%>" name="bookImage">
    <input type="hidden" value="<%=request.getParameter("bid")%>" name="bookId">
    <input type="hidden" value="<%=request.getParameter("name")%>" name="bookName">
    <input type="hidden" value="<%=request.getParameter("author")%>" name="bookAuthor">
    <input type="hidden" value="<%=request.getParameter("price")%>" name="bookPrice">

</form>
<a id="add" href="javascript:document.getElementById('form').submit();"></a>
</body>

<script>
    $(function () {

        $('#add').click(function () {
            var number = $('#count').val();
            var regex = /^\+?[1-9][0-9]*$/;
            if (!regex.test(number)){
                alert('商品数量只能是正整数');
                return false;
            }
        })


    })

</script>
</html>
