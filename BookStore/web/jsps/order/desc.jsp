<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.lanou.bookstore.cart.Cart" %>
<%@ page import="com.lanou.bookstore.cart.domain.CartItem" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    
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
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#pay {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -412px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#pay:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -448px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
    .mainCart{
        text-align: center;
    }
</style>
  </head>
  
  <body>
<h1>当前订单</h1>

<table border="1" width="100%" cellspacing="0">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			订单编号：<%=session.getAttribute("orderNo")%>　
            成交时间：<%=session.getAttribute("orderTime")%>　
            金额：<%=session.getAttribute("finalPrice")%>元
		</td>
	</tr>

    <tr>
        <th>图片</th>
        <th>书名</th>
        <th>作者</th>
        <th>单价</th>
        <th>数量</th>
        <th>小计</th>
    </tr>
    <%
        Cart cart = (Cart) session.getAttribute("cart");

        Map<String, CartItem> map = cart.getMap();

        for (Map.Entry<String, CartItem> entry : map.entrySet()) {%>
    <tr class="mainCart">
        <td><img style="width: 80px;height: 100px" src="<%=entry.getValue().getBookImage()%>" border="0"/></td>
        <td><%=entry.getValue().getBookName()%></td>
        <td><%=entry.getValue().getBookAuthor()%></td>
        <td><%=entry.getValue().getBookPrice()%>元</td>
        <td><%=entry.getValue().getAmount()%></td>
        <td><%=entry.getValue().getTotalPrice()%>元</td>

    </tr>

    <%}%>

</table>
<br/>
<form method="post" action="/order/payment" id="form" target="_parent">
	收货地址：<input id="addr" type="text" name="address" size="50" value="大连黑石礁街道软件园10号楼3楼蓝鸥科技有限公司"/><br/>

	选择银行：<br/>
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
	<img src="../../bank_img/icbc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="../../bank_img/bc.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="../../bank_img/abc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="../../bank_img/ccb.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="../../bank_img/bcc.bmp" align="middle"/><br/>
</form>
<a id="pay" href="javascript:document.getElementById('form').submit();"></a>

  </body>


  <script>
      $(() => {
          $("#pay").click(function () {
              let flag = $('#addr').val();
              if (flag == null) {
                  alert('请填写收获地址!');
                  return false;
              } else {
                  return true;
              }
          })


      })
  </script>
</html>

