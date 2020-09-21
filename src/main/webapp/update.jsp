<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<meta charset='UTF-8'>
  <head>
    <title>欢迎光临！</title>
  </head>
  <body>
  <form action="update2" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    姓名：<input type="text" name="name" value="${user.name}"/><br/><br/>
    年龄：<input type="text" name="age" value="${user.age}"/><br/><br/>
    性别：<input type="radio" name="sex" value="1"  <c:if test="${user.sex==1}">checked</c:if>/>男
    <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>/>女<br/><br/>
    工资: <input type="text" name="sal" value="${user.sal}"/><br/><br/>
    生日：<input type="date" name="birth" value="${user.birth}"/><br/><br/>
    <input type="submit" value="修改"/>
  </form>
  </body>
</html>
