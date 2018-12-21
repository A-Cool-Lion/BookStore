<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加图书</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
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
<h1>添加图书</h1>
<p style="font-weight: 900; color: red">${msg }</p>
<%--<form action="javascript:alert('添加图书成功！')" method="post" enctype="multipart/form-data">--%>
<form action="/admin/category/addBook" method="POST" enctype="multipart/form-data">
    图书名称：<input style="width: 150px; height: 20px;" type="text" name="bname" required="required"/><br/>
    图书图片：<input style="width: 223px; height: 20px;" type="file" name="image" required="required"/><br/>
    图书单价：<input style="width: 150px; height: 20px;" type="text" name="price" required="required"/><br/>
    图书作者：<input style="width: 150px; height: 20px;" type="text" name="author" required="required"/><br/>
    图书分类：<select style="width: 150px; height: 20px;" name="cid" id="categorySelect" >

</select>
    <br/>
    <input type="button" value="添加图书" data-toggle="modal" data-target="#myModal" name="btn"/>


    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Warning</h4>
                </div>
                <div class="modal-body">
                    是否添加图书
                </div>
                <div class="modal-footer">
                    <input id="btn" type="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal" value="提交">
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



        var bname = $('input[name = bname]');
        var image = $('input[name = image]');
        var price = $('input[name = price]');
        var author = $('input[name = author]');
        $('input[name = btn]').click(function () {

            var regex = /^([1-9]\d*(\.\d*[1-9])?)|(0\.\d*[1-9])$/;


            if (bname.val() == null & bname.val() == ''){
                alert('请填写商品的名称!');
                return false;
            }

            if (image.val() == null & bname.val() == ''){
                alert('请选择图片!');
                return false;
            }

            if (price.val() == null & bname.val() == ''){
                alert('请输入商品的价格!');
                return false;
            }

            if (!regex.test(price.val())){
                alert('商品价格的格式不正确!');
                return false;
            }

            if (author.val() == null & bname.val() == ''){
                alert('作者不能为空');
                return false;
            }




        })



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

                select.append(option);
            }


        }

    }

</script>


</html>
