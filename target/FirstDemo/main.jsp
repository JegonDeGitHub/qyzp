<%--
  Created by IntelliJ IDEA.
  User: RJG
  Date: 2019/3/6
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>

</head>
<body>

</body>
<script type="text/javascript">
    var json = ${json};
    var strJson = "<div>";
    for(var i=0;i<json.length;i++) {
        strJson+= "<ul>";
        for(var key in json[i]) {
            strJson+="<li>"+key+":"+json[i][key]+"</li>";
        }
        strJson+="</ul>";
    }
    strJson+="</div>";
    $(".show-hierarchy").html(strJson);
</script>
</html>
