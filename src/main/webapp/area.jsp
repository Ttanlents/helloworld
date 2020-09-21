
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery-3.4.1.js"></script>
 <script>
     window.onload=function(){
         var name="province";
         $.ajax({
             url:'area',
             type:'post',
             data:{"name":name},
             dataType:'json',
             success:function (data) {
                    var html='';
                    for (var i=0;data.length>i;i++){
                       html+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
                    }
                 $('#province').append(html);

             }
         });
     };
 </script>
<head>
    <title>地区</title>
    请选择省份：
    <select name="province" id="province" onclick="getCity()">
        <option value="0">请选择</option>
    </select>
    请选着市区：
    <select name="city" id="city" onclick="getRegion()">
        <option value="">请选择</option>
    </select>
    请选择地区：
    <select name="region" id="region" >
        <option value="">请选择</option>
    </select>
</head>
<body>
<script>
    function getCity() {
        var parentId=$('#province').val();
        $.ajax({
            url:'area',
            type:'post',
            data:{"parentId":parentId},
            dataType:'json',
            success:function (data) {
                $('#city').empty();
                var html='<option value="">请选择</option>';
                for (var i=0;data.length>i;i++){
                    html+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
                }
                $('#city').append(html);
            }
        });
    }
    function getRegion() {
        var parentId=$('#city').val();
        $.ajax({
            url:'area',
            type:'post',
            data:{"parentId":parentId},
            dataType:'json',
            success:function (data) {
                $('#region').empty();
                var html='<option value="">请选择</option>';
                for (var i=0;data.length>i;i++){
                    html+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
                }
                $('#region').append(html);
            }
        });
    }




</script>

</body>
</html>
