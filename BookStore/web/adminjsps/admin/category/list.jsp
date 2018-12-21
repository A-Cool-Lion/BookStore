<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>分类列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="/js/jquery-3.3.1.js"></script>

    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <style type="text/css">
        body {
            background: rgb(254, 238, 189);
        }

        table {
            font-family: 宋体;
            font-size: 11pt;
            border-color: rgb(78, 78, 78);
            width: 60%;
        }

        #th {
            background: rgb(78, 78, 78);
        }
    </style>
</head>

<body>
<h2 style="text-align: center;">分类列表</h2>
<%--<table align="center" border="1" cellpadding="0" cellspacing="0">--%>
    <%--<tr id="th" bordercolor="rgb(78,78,78)">--%>
        <%--<th>分类名称</th>--%>
        <%--<th>操作</th>--%>
    <%--</tr>--%>

    <%--<tr bordercolor="rgb(78,78,78)">--%>
        <%--<td>1</td>--%>
        <%--<td>--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/mod.jsp'/>">修改</a> |--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/del.jsp'/>">删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr bordercolor="rgb(78,78,78)">--%>
        <%--<td>JavaEE</td>--%>
        <%--<td>--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/mod.jsp'/>">修改</a> |--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/del.jsp'/>">删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr bordercolor="rgb(78,78,78)">--%>
        <%--<td>Javascript</td>--%>
        <%--<td>--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/mod.jsp'/>">修改</a> |--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/del.jsp'/>">删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr bordercolor="rgb(78,78,78)">--%>
        <%--<td>Struts</td>--%>
        <%--<td>--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/mod.jsp'/>">修改</a> |--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/del.jsp'/>">删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr bordercolor="rgb(78,78,78)">--%>
        <%--<td>hibernate</td>--%>
        <%--<td>--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/mod.jsp'/>">修改</a> |--%>
            <%--<a href="<c:url value='/adminjsps/admin/category/del.jsp'/>">删除</a>--%>
        <%--</td>--%>
    <%--</tr>--%>


<%--</table>--%>
<table align="center" border="1" cellpadding="0" cellspacing="0">
    <thead>
    <tr id="th" bordercolor="rgb(78,78,78)">
        <th>分类名称</th>
        <th colspan="2">操作</th>
        <%--<th>删除</th>--%>

    </tr>
    </thead>
    <tbody id="body"></tbody>
</table>



</body>
<script>
    $(function () {
    let url = '<%=request.getContextPath()%>/admin/category/getJson';

        $.get(url, function (resp) {
            if (resp.status === 200) {
                // let totalCount = resp.data.totalCount;
                let beanList = resp.data.beanList;
                console.log(beanList);
                let body = $('#body');
                body.empty();

                for (let bean of beanList) {
                    let tr = $('<tr bordercolor="rgb(78,78,78)"></tr>');
                    let cName = $('<td></td>').text(bean.cName);

                    let modUrl = "<a href=\"<c:url value='/adminjsps/admin/category/mod.jsp?name=";
                    modUrl = modUrl + bean.cName;
                    let modUrl2 = "'/>\">修改</a>";
                    modUrl = modUrl + modUrl2;

                    let delUrl = "<a href=\"<c:url value='/adminjsps/admin/category/del.jsp?name=";
                    delUrl = delUrl + bean.cName;
                    let delUrl2 = "'/>\">删除</a>";
                    delUrl = delUrl + delUrl2;


                    let edit = $('<td></td>').html(modUrl);
                    let del = $('<td></td>').html(delUrl);

                    tr.append(cName).append(edit).append(del);
                    body.append(tr);




                }
            }
        })
    })
</script>
</html>
