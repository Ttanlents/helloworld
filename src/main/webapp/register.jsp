
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset='UTF-8'>
  <head>
    <title>欢迎注册</title>
  </head>
<script src="js/jquery-3.4.1.js"></script>
<style>
  form{
    text-align: center;
  }
  fieldset{
    margin: auto 33%;
  }
  #id-span{
    display: none;
    color: red;
  }
</style>
  <body>
  <fieldset style="border: solid 4px dodgerblue">
    <legend>注册用户</legend>
  <form action="register" method="post">
     <label for="name">账号：</label>
    <input type="text" name="name" id="name" onblur="checkName()"/>
    <span id="id-span">账号已存在</span><br/><br/>
    <label for="pwd">密码：</label>
    <input type="password" name="password" id="pwd"/><br/><br/>
    <input style="background-color:dodgerblue;color: red"  type="submit" value="保存" onclick="register()"/>
  </form>
  </fieldset>
  </body>
    <script>
        var flag=false;
      function  checkName(){
       var name= $('#name').val();
          $.ajax({
              url:'/checkName',
              type:'post',
              data:{"name":name},
              dataType:'json',
              async:true,
              success:function (data) {
                  if (data=='1'){
                      $('#id-span').css("display","inline-block");
                      flag=false;
                  } else {
                      $('#id-span').css("display","none");
                      flag=true;
                  }
              }

          });
      }

      function register() {
         if (!flag){
             alert('注册失败，账号已存在')
             return;
         }
          var name=$('#name').val();
          var password=$('#pwd').val();
          $.ajax({
              url:'/register',
              type:'post',
              data:{"name":name,"password":password},
              dataType:'json', //预期返回的数据类型
              async:true,
              success:function (data) {
                  if (data=='1'){
                      alert("恭喜注册成功");
                      window.location.href="index.jsp"
                  }
              }
          });
      }

    </script>
</html>
