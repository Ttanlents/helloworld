
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset='UTF-8'>
  <head>
    <title>欢迎注册</title>
  </head>
<style>

</style>
  <body>
  <fieldset style="border: solid 4px dodgerblue">
    <legend>添加用户</legend>
  <form action="register" method="post">
     <label for="name">姓名：</label>
    <input type="text" name="name" id="name" /><br/><br/>
    <label for="age">年龄：</label>
    <input type="text" name="age" id="age"/><br/><br/>
    <input type="radio" name="sex"  value="男"/>男
    <input type="radio" name="sex" value="女"/>女
    <input style="background-color:dodgerblue;color: red"  type="submit" value="保存"/>
  </form>
  </fieldset>
  </body>
</html>
