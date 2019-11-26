<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        function ajaxFun(){
            $.ajax({
                type: "POST",                            //传数据的方式
                url: "user",                             //servlet地址

                data: $('#form').serialize(),            //传的数据  form表单 里面的数据
                success: function(result){               //传数据成功之后的操作   result是servlet传过来的数据  这个函数对result进行处理，让它显示在 输入框中
                    $("#results").val(result);           //找到输入框 并且将result的值 传进去
                }
            });
        }

    </script>
</head>
<body>
<H1 align="center">请输入两个字符串</H1>
<div align="center">
    <form id="form">
        first:<input type="text" name="first" id="first">
        second:<input type="text" name="second" id="second"><br>　　　　　
        <button type="button" onclick="ajaxFun()">button</button>
    </form>
    <input type="text" id="results">

</div>
</body>
</html>