<!DOCTYPE html>
<html>
<head>
    <#include "./../common/header.ftl"/>
</head>
<body>
<div class="py-5" >
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0 text-dark">权限管理</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item">系统管理</li>
                            <li class="breadcrumb-item active">权限管理</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <section class="content">
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 bg-white">
                            <div class="container">
                            <div class="col-md-12">
                                <h4>菜单列表</h4>
                            </div>
                            <nav class="mt-2">
                                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                                    data-accordion="false">
                                    <!-- Add icons to the links using the .nav-icon class
                                         with font-awesome or any other icon font library -->
                                    <#list menu as iteam>
                                        <#if iteam.pId==0 && iteam.flag=0>
                                             <li class="nav-item">
                                                 <a href="javascript:getPermissionList(${menu.id},'${iteam.name}')" class="nav-link">
                                                     <i class="nav-icon ${iteam.icon}"></i>
                                                     <p>${iteam.name}<i class="right fa fa-angle-left"></i></p>
                                                 </a>
                                                 <ul class="nav nav-treeview">
                                            <#list menu as iteamSecond>
                                                <#if iteam.id==iteamSecond.pId && iteamSecond.flag==0>
                                                <a href="javascript:getPermissionList(${iteamSecond.id},'${iteamSecond.name}')" class="nav-link">
                                                    <i class="${iteamSecond.icon} nav-icon"></i>
                                                    <p> ${iteamSecond.name}</i>
                                                    </p>
                                                </a>
                                                </#if>
                                            </#list>
                                                 </ul>
                                             </li>
                                        </#if>
                                    </#list>
                                </ul>
                            </nav>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-7 bg-white">
                            <div class="container">
                            <div class="col-md-12">
                                <h4>权限列表<label id="menuLable"></label></h4>
                            </div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>权限名称</th>
                                    <th>权限标识</th>
                                </tr>
                                </thead>
                                <tbody id="permissionTable">
                                </tbody>
                            </table>
                            </div>
                            <div class="col-md-12" id="btnGroup">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
</div>
    <#include "./../common/footer.ftl"/>
<script>
    function getPermissionList(id,name) {
        $.post("/permission/getPermissionListById",{id:id},function (data) {
            $("#menuLable").html("("+name+")");
            var html = "";
            for(var i=0;i<data.length;i++){
                html +="<tr><td>"+(i+1)+"</td><td>"+data[i].name+"</td><td>"+data[i].permission+"</td></tr>";
            }
            $("#permissionTable").html(html);
        })
    }
</script>
</body>
</html>