<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>首页</title>

    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/jquery.pagination.js"></script>

    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: deepskyblue;
            border-radius: 4px;
        }
        #unameFlag{
            display: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    基于SSM框架的管理系统：简单实现增、删、改、查。
                </h1>
            </div>
        </div>
    </div>
</div>
<br><br>
<h3>
    <a href="/api/item/list">点击进入管理页面</a>
</h3>

<form action="/api/user/register" method="post" >
    用户名：<input type="text" name="uname" id="unameInput"><span id="showResult"></span><br>
    密码：<input type="password" name="password"><br>
    RoleTypeId：<input name="role_type.value" type="text"/><br>
    RoleTypeName：<input name="role_type.desc" type="text"/><br>
    <input type="submit" value="注册">
</form>

<form action="/api/user/testRoleType" method="post">
    RoleTypeId：<input name="value" type="text"/>
    RoleTypeName：<input name="desc" type="text"/>
    <input type="submit" value="提交">
</form>

<a class="M-box" href="http://192.168.1.171:8081/api/item/list/all?page_num=1&page_size=20"></a>

<form action="/api/user/login" method="post">
    用户名：<input name="uname" type="text"/>
    密码：<input name="password" type="password"/>
    <input type="submit" value="提交">
</form>

<form action="/api/upload/saveAndThumbnail?id=${sessionScope.user.id}&roleType=${sessionScope.user.roleType.value}"
      enctype="multipart/form-data" method="post">
    <%--需要上传的图片文件：<input type="file" name="file" onchange="uploadFile(this)" >--%>
    需要上传的图片文件：<input type="file" name="file"  >
    <div id="down"></div>
    <input type="submit" value="提交">
</form>

${sessionScope.user.uname}

</body>

<script type="text/javascript">
    $('.M-box').pagination({
        callback: function (api) {
            $('.now').text(api.getCurrent());
        }
    }, function (api) {
        $('.now').text(api.getCurrent());
    });
    /*var json = \\${json};
    var strJson = "<div>";
    for(var i=0;i<json.length;i++) {
        strJson+= "<ul>";
        for(var key in json[i]) {
            strJson+="<li>"+key+":"+json[i][key]+"</li>";
        }
        strJson+="</ul>";
    }
    strJson+="</div>";
    $(".show-hierarchy").html(strJson);*/

    $("#unameInput").blur(function () {
        //alert("sdsds");
        checkIsExist();
    });

    function checkIsExist() {
        var userName = $.trim($("#unameInput").val());
        $.ajax({
            type: "POST",   //http请求方式
            async:true,//异步
            url: "/api/user/registerCheck" ,//发送给服务器的url
            data: "uname=" + userName, //发送给服务器的参数
            dataType: "boolean",  //告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
            beforeSend:function() {
                $("#unameInput").addClass("sending").text("提交中");
            },
            complete:function() {
                $("#unameInput").removeClass("sending").text("注册");
            },
            success: function (msg) {
                if (eval("(" + msg.responseText + ")")) {
                    $("#showResult").html("<font color='red'>用户名已存在</font>");
                } else {
                    $("#showResult").html("");
                }
            }//定义交互完成,并且服务器正确返回数据时调用回调函数
        });
    }
</script>

</html>