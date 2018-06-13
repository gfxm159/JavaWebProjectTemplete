<!DOCTYPE html>
<html>
<head>
    <#include "common/header.ftl"/>
</head>
<body>
<div class="login-box">
    <div class="login-logo">
        <a href="../../index2.html"><b>欢迎使用</b>XXXX系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg">请登录</p>

            <form action="login" method="post">
                <div class="form-group has-feedback">
                    <span class="fa fa-envelope form-control-feedback"></span>
                    <input type="text" class="form-control" name="username" placeholder="用户名">
                </div>
                <div class="form-group has-feedback">
                    <span class="fa fa-lock form-control-feedback"></span>
                    <input type="password" class="form-control" name="password" placeholder="密码">
                </div>
                <div class="row">
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->
    <#include "common/footer.ftl"/>
</body>
</html>