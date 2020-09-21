<%--
  Created by IntelliJ IDEA.
  User: FT
  Date: 2020/9/21
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery-3.4.1.js"></script>
<script>
    $(function () {
       $('#but').click(function () {
           $.ajax({
               url:'/getMess',
               type:'get',
               data:'',
               async:true,
               dataType:'json',
               success:function (data) {
                   $('#div1').append(data);
               }
           });
       });
    });
</script>
<head>
    <title>ajax</title>
    <button id="but">查询</button>
    <div id="div1" style="font-size: 20px"></div>
</head>
<body>
</body>
</html>
