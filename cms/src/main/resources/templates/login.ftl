<!DOCTYPE html>
<html>
<head>
    <#include "common/header.ftl"/>
</head>
<body>
<img src="${base}/dist/img/login-bk.jpg" class="blur login-bk">
<div class="login-box">

    <div class="login-logo">
        <a href="../../index2.html"><b>欢迎使用</b>XXXX系统</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <form action="login" method="post">
                <div class="form-group has-feedback">
                    <span class="fa fa-user form-control-feedback"></span>&#12288;用户名：
                    <input type="text" class="form-control" name="username" placeholder="请输入用户名">
                </div>
                <div class="form-group has-feedback">
                    <span class="fa fa-lock form-control-feedback"></span>&#12288;密&#12288;码：
                    <input type="password" class="form-control" name="password" placeholder="请输入密码">
                </div>
                <div class="content">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登陆</button>

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