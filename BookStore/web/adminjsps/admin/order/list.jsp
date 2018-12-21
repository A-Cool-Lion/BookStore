<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>订单列表</title>

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

        td{
            text-align: center;
        }
        body {
            background: rgb(254, 238, 189);
        }
    </style>
</head>

<body>
<h1>我的订单</h1>

<table align="center" border="1" cellpadding="0" cellspacing="0" id="head" width="100%">
    <%--<thead id="head">--%>

    <%--</thead>--%>
    <%--<tbody></tbody>--%>
</table>
</body>

<script>
    $(function () {
        let url = '<%=request.getContextPath()%>/order/getJson?status=<%=request.getParameter("status")%>';

        $.get(url, function (resp) {

            let head = $('#head');
            let temp = "a";
            let titleTh;
            for (let i = 0; i < resp.length; i++) {
                console.log(resp[i].ordertime);
                let titleTr = $('<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">');
                var tr = $('<tr></tr>');
                if (resp[i].onumber != temp) {
                    temp = resp[i].onumber;
                    titleTh = $('<th colspan="6"></th>');

                    var td1 = $('<td></td>');
                    var img =$('<img style="width: 80px;height:100px" src="<%=request.getContextPath()%>'+resp[i].image+'">');
                    td1.append(img);
                    var td2 = $('<td></td>').text("书名:" + resp[i].bname);
                    var td3 = $('<td></td>').text("单价:" + resp[i].price)
                    var td4 = $('<td></td>').text("作者:" + resp[i].author);
                    var td5 = $('<td></td>').text("数量:" + resp[i].count);
                    var td6 = $('<td></td>').text("小计:" + resp[i].subtotal);




                    tr.append(td1);
                    tr.append(td2);
                    tr.append(td3);
                    tr.append(td4);
                    tr.append(td5);
                    tr.append(td6);


                } else {
                    titleTh = $('<th colspan="6" style="display: none"></th>');


                    var ttd1 = $('<td></td>');
                    var img1 = $('<img style="width: 80px;height:100px" src="<%=request.getContextPath()%>'+resp[i].image+'">');
                    ttd1.append(img1);

                    var ttd2 = $('<td></td>').text("书名:" + resp[i].bname);
                    var ttd3 = $('<td></td>').text("单价:" + resp[i].price)
                    var ttd4 = $('<td></td>').text("作者:" + resp[i].author);
                    var ttd5 = $('<td></td>').text("数量:" + resp[i].count);
                    var ttd6 = $('<td></td>').text("小计:" + resp[i].subtotal);




                    tr.append(ttd1);
                    tr.append(ttd2);
                    tr.append(ttd3);
                    tr.append(ttd4);
                    tr.append(ttd5);
                    tr.append(ttd6);

                }




                console.log(resp[i].status);
                switch (resp[i].status) {
                    case 1:
                        titleTh.html(
                                "订单编号：" + resp[i].onumber +
                                "　成交时间：" + resp[i].ordertime +
                                "　金额：" + resp[i].total + "元" +
                                '<div style="display: inline; position: relative;">' + "&emsp;" +
                                '<span>未付款</span>' + '</div>'
                        );

                    <%--<%=session.setAttribute("pay", );%>--%>

                        break;
                    case 2:

                        console.log(resp[i].onumber);
                        titleTh.html(
                                "订单编号：" + resp[i].onumber +
                                "　成交时间：" + resp[i].ordertime +
                                "　金额：" + resp[i].total + "元" +
                                '<div style="display: inline; position: relative;">' + "&emsp;" +
                                '<a href="/order/modifyState?status=3&No='+resp[i].onumber+'" class="status">发货</a>' +
                                '</div>'
                        );
                        break;
                    case 3:
                        titleTh.html(
                                "订单编号：" + resp[i].onumber +
                                "　成交时间：" + resp[i].ordertime +
                                "　金额：" + resp[i].total + "元" +
                                '<div style="display: inline; position: relative;">' + "&emsp;" +
                                '<span>已发货</span>'  +
                                '</div>'
                        );
                        break;
                    case 4:
                        titleTh.html(
                                "订单编号：" + resp[i].onumber +
                                "　成交时间：" + resp[i].ordertime +
                                "　金额：" + resp[i].total + "元" +
                                '<div style="display: inline; position: relative;">' + "&emsp;" +
                                '<span>已收货(完成)</span>'  +
                                '</div>'
                        );
                        break;
                }



                titleTr.append(titleTh);

                head.append(titleTr);
                head.append(tr);
            }
            

            
            
        })
    })
</script>

</html>
