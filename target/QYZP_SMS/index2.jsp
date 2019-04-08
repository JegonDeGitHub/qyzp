<%--
  Created by IntelliJ IDEA.
  User: RJG
  Date: 2019/3/28
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>青阅招聘首页</title>
    <link href="http://www.chenbz.cn/bootstrap3/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="http://www.chenbz.cn/bootstrap3/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="http://www.chenbz.cn/bootstrap3/js/bootstrap.min.js"></script>
    <link href="http://www.chenbz.cn/qyzp/style/index.css" rel="stylesheet" type="text/css">
    <script src="http://www.chenbz.cn/qyzp/style/index.js"></script>
</head>
<body onload="list()">


<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0; background-color: white;">
    <div class="container">
        <div class="navbar-header">

            <a href="index.jsp" class="navbar-brand">
                <span class="logo_qyzp">青阅招聘</span>
            </a>

            <div id="nav" class="pull-left">
                <p style="margin-top: 17px; margin-left: 15px;">登陆后查看更多！</p>
            </div>
        </div>


        <form class="navbar-form navbar-right" role="search">
            <button type="button" class="btn btn-login"data-toggle="modal" data-target="#myModal">登录</button>
            <a href="registered.jsp" class="btn btn-default">注册</a>
        </form>

        <div class="navbar-right">
            <ul id="nav-ui" class="nav navbar-nav">
                <li><a href="#">简历制作</a></li>
                <li><a href="#">个人中心</a></li>
            </ul>
        </div>

    </div>
</nav>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <!--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                -->
                <div class="row">
                    <ul class="nav nav-tabs text-center" role="tablist">
                        <li role="presentation" class="active col-md-6 col-xs-6"><a href="#login1" aria-controls="login" role="tab" data-toggle="tab">用户登录</a></li>
                        <li role="presentation" class="col-md-6 col-xs-6"><a href="#login2" aria-controls="registered" role="tab" data-toggle="tab">企业登录</a></li>
                    </ul>
                </div>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="login1">
                            <form class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1">
                                <br>
                                <div class="input-group">
                                    <samp class="input-group-addon"><span class="glyphicon glyphicon-user"></span></samp>
                                    <input type="text" class="form-control padding-25-15" id="inpName1" placeholder="输入用户名">
                                </div>
                                <br>
                                <div class="input-group">
                                    <samp class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></samp>
                                    <input type="password" class="form-control padding-25-15" id="inpPassword1" placeholder="输入密码">
                                </div>
                                <br>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">记住密码
                                    </label>
                                    <a href="#" class="pull-right">忘记密码?</a>
                                </div>
                                <br>
                                <button type="button" class="btn btn-lg col-md-10 col-md-offset-1 background_q col-xs-8 col-xs-offset-2" data-dismiss="modal" onclick="login()">登录</button>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="login2">
                            <form class="col-md-10 col-md-offset-1 col-xs-10 col-xs-offset-1">
                                <br>
                                <div class="input-group">
                                    <samp class="input-group-addon"><span class="glyphicon glyphicon-user"></span></samp>
                                    <input type="text" class="form-control padding-25-15" id="inpName2" placeholder="输入用户名">
                                </div>
                                <br>
                                <div class="input-group">
                                    <samp class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></samp>
                                    <input type="password" class="form-control padding-25-15" id="inpPassword2" placeholder="输入密码">
                                </div>
                                <br>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox">记住密码
                                    </label>
                                    <a href="#" class="pull-right">忘记密码?</a>
                                </div>
                                <br>
                                <button type="button" class="btn btn-info btn-lg col-md-10 col-md-offset-1 col-xs-8 col-xs-offset-2" data-dismiss="modal">登录</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container-fluid background_img" style="height: 500px;">
    <div class="row">
        <div style="margin-top: 216.5px;">
            <div class="col-md-5 col-md-offset-3 col-xs-5 col-xs-offset-3" style="padding-right: 0;">
                <form role="form">
                    <div class="form-group">
                        <input type="text" class="form-control" id="name" placeholder="请输入名称" style="padding: 25px 15px;
               border-top-right-radius: 0; border-bottom-right-radius: 0;">
                    </div>
                </form>
            </div>
            <div class="col-md-2 col-xs-2" style="padding-left: 0;">
                <button type="button" class="btn btn-default" style="padding: 15px 10px; width: 70px;
           border-top-left-radius: 0; border-bottom-left-radius: 0;">搜索</button>
            </div>
        </div>
    </div>
</div>


<div class="container" style="padding: 0;">
    <ul class="nav nav-tabs">
        <li role="presentation" class="active"><a data-toggle="tab" href="#recruitment"><h4>最新招聘</h4></a></li>
        <li role="presentation"><a data-toggle="tab" href="#recruitment"><h4>热门招聘</h4></a></li>
    </ul>
</div>


<div class="container">
    <div class="row">
        <div class="tab-content">
            <div id="recruitment" class="tab-pane active">
                <a href="#" class="list-group-item">
                    <div class="row">
                        <div style="padding: 15px;">
                            <div class="col-md-6 col-xs-6">
                                <h4>java开发工程师</h4>
                            </div>
                            <div class="col-md-6 col-xs-6">
                                <h4 class="pull-right">阳江有限公司</h4>
                            </div>
                            <div class="col-md-12 col-xs-12">
                                <h4>10K - 15K</h4>
                            </div>
                            <div class="col-md-11 col-xs-10">
                                <h5>阳江/大专/经验不限</h5>
                            </div>
                            <div class="col-md-1 col-xs-2">
                                <button type="button" class="btn btn-info">申请职位</button>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>


<div class="container" style="background-color: white; padding: 50px;">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3">
            <ul class="pagination pagination-lg">
                <li><a href="#">&laquo;</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>
    </div>
</div>


<div class="jumbotron text-center" style="margin: 0;">
    <p>©2019 Qingyue Recruitment. All rights reserved.</p>
</div>
</body>
</html>

