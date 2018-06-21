<!DOCTYPE html>
<html lang="en">
<head>
    <#include "./../common/header.ftl"/>
    <style>
        .ui-jqgrid {
            font-size: 0.8rem
        }
    </style>
</head>
<body>
<div style="margin-left:20px;margin-top:20px">
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
    <span class="oi oi-person"></span>
</div>
    <#include "./../common/footer.ftl"/>
<script>
    $.jgrid.defaults.width = 780;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap4';
    $.jgrid.defaults.iconSet = "Octicons";
    $(document).ready(function () {
        // altrows are set with table striped class for Boostrap
        //$.jgrid.styleUI.Bootstrap.base.rowTable = "table table-bordered table-striped";

        $("#jqGrid").jqGrid({
            url: '${base}/getAuthUserList',
            mtype: 'POST',
            datatype: "json",
            colModel: [
                {label: '登录名', name: 'loginName', width: 75, editable: true},
                {label: '角色', name: 'roleName', width: 90, editable: true}
            ],
            //rownumbers : true,
            //multiselect : true,
            width: 780,
            hoverrows : true,
            height: 200,
            rowNum: 20,
            caption : '用户列表',
            pager: "#jqGridPager"
        });


    });

</script>
</body>
</html>