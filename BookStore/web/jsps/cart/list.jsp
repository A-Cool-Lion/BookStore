<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.lanou.bookstore.cart.Cart" %>
<%@ page import="com.lanou.bookstore.cart.domain.CartItem" %>
<%@ page import="com.mysql.fabric.xmlrpc.base.Value" %>
<%@ page import="com.lanou.bookstore.common.MathFormat" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>购物车列表</title>

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
        * {
            font-size: 11pt;
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

        #buy {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -902px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        #buy:HOVER {
            background: url(<c:url value='/images/all.png'/>) no-repeat;
            display: inline-block;

            background-position: 0 -938px;
            margin-left: 30px;
            height: 36px;
            width: 146px;
        }

        .mainCart > td {
            text-align: center;
        }

    </style>
</head>

<body>
<h1>购物车</h1>

<table border="1" width="100%" cellspacing="0">
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <a href="/cart/empty">清空购物车</a>
        </td>
    </tr>
    <tr>
        <th>图片</th>
        <th>书名</th>
        <th>作者</th>
        <th>单价</th>
        <th>数量</th>
        <th>小计</th>
        <th>操作</th>
    </tr>


    <%
        Cart cart = (Cart) session.getAttribute("cart");

        Map<String, CartItem> map = cart.getMap();

        double finalPrice = 0;
        for (Map.Entry<String, CartItem> entry : map.entrySet()) {%>
    <tr class="mainCart">
        <td><img style="width: 108px; height: 150px" src="<%=entry.getValue().getBookImage()%>" border="0"/></td>
        <td><%=entry.getValue().getBookName()%></td>
        <td><%=entry.getValue().getBookAuthor()%></td>
        <td><%=entry.getValue().getBookPrice()%>元</td>
        <td><%=entry.getValue().getAmount()%></td>
        <td><%=entry.getValue().getTotalPrice()%>元</td>
        <td>
            <form action="/cart/delete" method="post">
                <input type="hidden" name="key" value="<%=entry.getKey()%>"/>
                <input type="submit" value="删除"/>
            </form>
        </td>
    </tr>

    <%
            finalPrice += entry.getValue().getTotalPrice();

        }
        finalPrice = MathFormat.formatDouble(finalPrice);
        session.setAttribute("finalPrice", finalPrice);
    %>


    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            合计：<%out.println(finalPrice);%>元
        </td>
    </tr>
    <tr>
        <td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
            <a id="buy" href="<c:url value='/order/buy'/>"></a>
        </td>
    </tr>
</table>
</body>
<script>
    $(() => {
        $("#buy").click(function () {
            let flag = '<%=((Cart) session.getAttribute("cart")).getMap().size()%>';
            if (flag == '0') {
                alert('购物车不能为空!');
                return false;
            } else {
                return true;
            }
        })


    })
</script>
</html>
