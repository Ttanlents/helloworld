<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<meta charset='UTF-8'>
  <head>
    <script src="js/jquery-1.7.2.js"></script>
    <title>欢迎光临！</title>
  </head>
<style type="text/css">
  #div1 {
    text-align: center;
  }
  #div4{
    margin-left: 40%;
  }
  table{
    margin: 0 auto;
  }
  #div2 a{
    margin-left: 25%;
  }


</style>
  <body>
  <div style="margin-left: 160px">
    <form action="select" method="post">
      姓名：<input type="text" name="name" placeholder="请输入姓名"/>&nbsp;&nbsp;&nbsp;
      <input type="submit" value="查询" style="background-color: dodgerblue"/>&nbsp;&nbsp;&nbsp;
    </form>
    <a href="toAddUser">添加</a>&nbsp;&nbsp;&nbsp;
    当前在线人数：${count}&nbsp;&nbsp; <c:if test="${session_name!=null}">当前用户：${session_name}</c:if>
    <c:if test="${session_name==null}">您还未登录，请先登录哦！</c:if>&nbsp;&nbsp;&nbsp; <a href="loginOut">退出登录</a>
    &nbsp;&nbsp; <a href="area.jsp">地区选择</a>

  </div>
  <br/>
  <div id="div1">
  <table border="1px" cellspacing="0" cellpadding="10">
    <tr>
      <th>序号</th>
      <th>姓名</th>
      <th>年龄</th>
      <th>性别</th>
      <th>工资</th>
      <th>生日</th>
      <th>创建时间</th>
      <th>操作</th>
    </tr>

    <c:forEach items="${page.data}" var="user" varStatus="status">
      <tr class="show">
        <td>${(status.count)+(page.pageCurrent-1)*page.pageSize}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.sex}</td>
        <td>${user.sal}</td>
        <td>
          <fmt:parseDate var="abc" value="${user.birth}" pattern="YYYY-MM-dd"></fmt:parseDate>
          <fmt:formatDate value="${abc}" pattern="YYYY年MM月dd日"></fmt:formatDate>
        </td>
        <td>
          <fmt:parseDate var="abc2" value="${user.createTime}" pattern="YYYY-MM-dd HH:mm:ss"></fmt:parseDate>
          <fmt:formatDate value="${abc2}" pattern="YYYY年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
        </td>
        <td>
          <a href="update?id=${user.id}" onclick="return confirm('确认要修改吗？')"/>修改
          <a href="delete?id=${user.id}&name=${name}&pageCurrent=${page.pageCurrent}" onclick="return confirm('确认要删除吗？')"/>删除
        </td>
      </tr>
    </c:forEach>
  </table>
  </div>
    <br>
    <div id="div4" style="">
      <a href="select?pageCurrent=1&name=${name}">首页</a>
      <a href="select?pageCurrent=${page.pageCurrent-1}&name=${name}">上一页</a>
      <a href="select?pageCurrent=${page.pageCurrent+1}&name=${name}">下一页</a>
      <a href="select?pageCurrent=${page.pageTotal}&name=${name}">尾页</a>
      <br/>
      当前${page.pageCurrent}页，每页${page.pageSize}条，共${page.count}条记录，共${page.pageTotal}页
    </div>
  </body>
<script>

</script>
<script>
  var page=1;
  var pageSize=2;

  $(function () {
      $('#but2').bind('click',function () {
          page++;
          console.log("message");
          $.ajax({
              url:"select",
              data:{page:page,pageSize:pageSize},
              dataType:'json',
              success:function (data) {
                      $('#div1').empty();
                  var mytable=$("<table border='1px' cellspacing='0' cellpadding='10'> </table>");
                  var mytr=$("<tr>\n" +
                      "      <th>序号</th>\n" +
                      "      <th>姓名</th>\n" +
                      "      <th>年龄</th>\n" +
                      "      <th>性别</th>\n" +
                      "      <th>工资</th>\n" +
                      "      <th>生日</th>\n" +
                      "      <th>创建时间</th>\n" +
                      "      <th>操作</th>\n" +
                      "    </tr>");
                  mytable.append(mytr);
                      $.each(data,function (i, user) {
                        console.log(i);
                        console.log(user);
                          var mydata=$("<tr class='show'>" +
                              "        <td>"+user.id+"</td>" +
                              "        <td>"+user.name+"</td>" +
                              "        <td>"+user.age+"</td>" +
                              "        <td>" +
                              "         <c\:choose>" +
                              "            <c\:when test='"+user.sex+"'>女</c\:when>" +
                              "            <c\:when test='"+user.sex+"'>男</c\:when>" +
                              "           <c\:otherwise>其他</c\:otherwise>" +
                              "          </c\:choose>" +
                              "        </td>" +
                              "        <td>"+user.sal+"</td>\n" +
                              "        <td>" +
                              "          <fmt\:parseDate var='abc' value='"+user.birth+"' pattern='YYYY-MM-dd'></fmt\:parseDate>" +
                              "          <fmt\:formatDate value='${abc}' pattern='YYYY年MM月dd日'></fmt\:formatDate>" +
                              "        </td>" +
                              "        <td>" +
                              "          <fmt\:parseDate var='abc2' value='"+user.createTime+"' pattern='YYYY-MM-dd HH:mm:ss'></fmt\:parseDate>\n" +
                              "          <fmt\:formatDate value='${abc2}' pattern='YYYY年MM月dd日 HH时mm分ss秒'></fmt\:formatDate>\n" +
                              "        </td>" +
                              "        <td>" +
                              "          <a href='update?id="+user.id+"' onclick='return confirm('确认要修改吗？')'/>修改" +
                              "          <a href='delete?id="+user.id+"' onclick='return confirm('确认要删除吗？')'/>删除" +
                              "        </td>" +
                              "      </tr>");
                          mytable.append(mydata);
                      });
                  $('#div1').append(mytable);
              }
          });
      })

  });
</script>
</html>
