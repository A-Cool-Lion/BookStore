<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改分类</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

    <style type="text/css">
        body {
            background: rgb(254, 238, 189);
        }
    </style>
</head>

<body>
<h1>修改分类</h1>
<form action="/admin/category/modCategory" method="post">
    <input type="hidden" name="ocname" value="<%=request.getParameter("name")%>"/>
    分类名称：<input type="text" name="cname" value="<%=request.getParameter("name")%>"/>
    <input type="button" value="修改分类" data-toggle="modal" data-target="#myModal"/>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Warning</h4>
                </div>
                <div class="modal-body">
                    是否修改图书分类
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal" value="提交">
                </div>
            </div>
        </div>
    </div>

</form>
</body>


</html>
