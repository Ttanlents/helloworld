<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <form action="addUser">
        姓名：<input type="text" name="name" value="<c:if test="${errorUser.name!=null}">${errorUser.name}</c:if>"/><br/><br/>
        年龄：<input type="text" name="age" value="<c:if test="${errorUser.age!=null}">${errorUser.age}</c:if>"/><br/><br/>
        性别：<input type="radio" name="sex" value="1" <c:if test="${errorUser.sex==1}">checked</c:if>/>男
                <input type="radio" name="sex" value="0" <c:if test="${errorUser.sex==0}">checked</c:if>/>女<br/><br/>
        工资: <input type="text" name="sal" value="<c:if test="${errorUser.sal!=null}">${errorUser.sal}</c:if>"/><br/><br/>
        生日：<input type="date" name="birth" value="<c:if test="${errorUser.birth!=null}">${errorUser.birth}</c:if>"/><br/><br/>
        <input type="submit" value="添加"/>
    </form>
</body>
</html>
