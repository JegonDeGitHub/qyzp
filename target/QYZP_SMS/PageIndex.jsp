<%--
  Created by IntelliJ IDEA.
  User: RJG
  Date: 2019/3/25
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页Test</title>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/jquery.pagination.js"></script>
</head>
<body>

<form id="form-list">
    <input type="hidden" name="page_num" value="1" />
    <input type="hidden" name="page_size" value="20" />
</form>
<div id="div-list"></div>

<script type="text/javascript">
    var baseApiUrl = "http://192.168.1.171:8081";
    var pageUrl = "/net/pagedemo/index.html";

    $(function() {
        var pageNum = getQueryVariable("page_num");
        pageNum = pageNum || 1;
        getList(pageNum);
    });

    function getList(pageNum) {
        $("#form-list").find("input[name=page_num]").val(pageNum);
        $.ajax({
            url: baseApiUrl + "/api/item/list/all",
            type: "get",
            data: $("#form-list").serialize(),
            dataType: "json",
            cache: false,
            beforeSend: function () {
            },
            complete: function () {
            },
            success: function (result) {
                var html = '<ul>';
                var data = result.data;
                var list = data.list;
                for (x in list) {
                    html += '<li>' + list[x].id + " - " +  list[x].name + '</li>';
                }
                html += '</ul>';
                html += '<div class="page-box"></div>';
                var $html = $(html);
                $("#div-list").html($html);

                var page_box = $html.siblings(".page-box");
                page_box.pagination({
                    current: data.page_num,
                    pageCount: data.pages,
                    count: 2,
                    jump: false,
                    coping: true,
                    prevContent: '上页',
                    nextContent: '下一页',
                    callback: function (api) {
                        var pageNum = api.getCurrent();
                        getList(pageNum);
                        //window.location.href = pageUrl + "?page_num=" + pageNum;
                    }
                });
            }, error: function (result) {
                alert("请求失败");
            }
        });
    }

    function getQueryVariable(variable) {
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
            var pair = vars[i].split("=");
            if (pair[0] == variable) return pair[1];
        }
    }
</script>
</body>
</html>
