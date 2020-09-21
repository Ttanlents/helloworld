<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<style>
    form{
        text-align: center;
    }
    fieldset{
        margin: auto 33%;
    }
</style>
<body>
<fieldset style="border: solid 4px dodgerblue">
    <legend>欢迎登陆</legend>
<form action="login" method="post">
    账号：<input type="text" value="<c:if test="${cookieName!=null}">${cookieName}</c:if>" name="name"/><br/>
    密码：<input type="password" value="<c:if test="${cookiePassword!=null}">${cookiePassword}</c:if>" name="password"/><br/>
    <select name="rememberNumber">
        <option value="1" selected>记住密码</option>
        <option value="2">七天</option>
        <option value="3">30天</option>
    </select>
    <input type="submit" value="登录"/>
</form>
</fieldset>
</body>
</html>
