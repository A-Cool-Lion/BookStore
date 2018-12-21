<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'bookdesc.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>

    <style type="text/css">
        body {
            font-size: 10pt;
            background: rgb(254, 238, 189);
        }

        .picDiv {
            margin: 20px;
            border: solid 2px gray;
            width: 150px;
            height: 170px;
            text-align: center;
        }

        li {
            margin: 10px;
        }
    </style>
</head>

<body>
<div class="picDiv">
    <img style="width: 108px; height: 150px" src="<c:url value='<%=request.getParameter("path")%>'/>" border="0"/>
</div>

<form style="margin:20px;" id="form" action="/admin/category/operation" method="post">
    <input type="hidden" name="oname" value="<%=request.getParameter("name")%>"/><br/>
    图书名称：<input type="text" required="required" name="bname" value="<%=request.getParameter("name")%>"/><br/>
    图书单价：<input type="number" required="required" name="price" value="<%=request.getParameter("price")%>"/><br/>
    图书作者：<input type="text" required="required" name="author" value="<%=request.getParameter("author")%>"/><br/>
    图书分类：<select style="width: 150px; height: 20px;" name="cid" id="categorySelect">
    <option id="o" value="<%=request.getParameter("cid")%>"><%=request.getParameter("cname")%>
    </option>

</select><br/>


    <input id="btn_del" name="method" type="button" value="del" data-toggle="modal" data-target="#myModal1"/>
    <input id="btn_mod" name="method" type="button" value="mod" data-toggle="modal" data-target="#myModal2"/>


    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel1">Warning</h4>
                </div>
                <div class="modal-body">
                    是否删除图书信息
                </div>
                <div class="modal-footer">
                    <input type="submit" name="method" class="btn btn-default" data-toggle="modal"
                           data-target="#myModal1" value="del">
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">Warning</h4>
                </div>
                <div class="modal-body">
                    是否更改图书信息
                </div>
                <div class="modal-footer">
                    <input type="submit" name="method" class="btn btn-default" data-toggle="modal"
                           data-target="#myModal2" value="mod">
                </div>
            </div>
        </div>
    </div>


</form>

</body>
<script>
    $(function () {
        let url = "<%=request.getContextPath()%>/select";
        $.get(url, result);
    });

    function result(resp) {
        if (resp.status === 200) {
            var select = $('#categorySelect');
            var items = resp.data.items;
            for (var item of items) {
                var option = $('<option></option>');
                option.val(item.cid);
                option.text(item.cname);
                console.log(item.cid);
                console.log(item.cname);
                if ($('#o').val() != item.cid){
                    select.append(option);
                }

            }
        }
    }

</script>
</html>
