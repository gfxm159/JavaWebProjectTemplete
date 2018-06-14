<!DOCTYPE html>
<html>
<head>
    <#include "./../common/header.ftl"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper" >
<#include "./../common/topnavbar.ftl"/>
<#include "./../common/sidebar.ftl"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
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
                        <div class="col-md-4">
                            <div class="col-md-12">
                                <h4>菜单列表</h4>
                            </div>
                            <nav class="mt-2">
                                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                                    <!-- Add icons to the links using the .nav-icon class
                                         with font-awesome or any other icon font library -->
                                    <li class="nav-item has-treeview">
                                        <a href="#" class="nav-link active">
                                            <i class="nav-icon fa fa-dashboard"></i>
                                            <p>
                                                系统管理
                                                <i class="right fa fa-angle-left"></i>
                                            </p>
                                        </a>
                                        <ul class="nav nav-treeview">
                                            <li class="nav-item">
                                                <a href="/permission/permissionList" class="nav-link">
                                                    <i class="fa fa-heart nav-icon"></i>
                                                    <p>权限管理</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="./index2.html" class="nav-link">
                                                    <i class="fa fa-user-md nav-icon"></i>
                                                    <p>用户管理</p>
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="./index3.html" class="nav-link">
                                                    <i class="fa fa-heartbeat nav-icon"></i>
                                                    <p>角色管理</p>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="nav-icon fa fa-table"></i>
                                            <p>
                                                试题管理

                                            </p>
                                        </a>
                                    </li>


                                </ul>
                            </nav>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-7">
                            <div class="col-md-12">
                                <h4>权限列表</h4>
                            </div>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>权限名称</th>
                                    <th>权限标识</th>
                                    <th>Username</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
<#include "./../common/footerCopyright.ftl"/>
</div>
    <#include "./../common/footer.ftl"/>
</body>
</html>