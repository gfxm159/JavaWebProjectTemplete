<!DOCTYPE html>
<html>
<head>
    <#include "common/header.ftl"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper" >
<#include "common/topnavbar.ftl"/>
<#include "common/sidebar.ftl"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <iframe  name="content" frameborder=no  border=0  marginwidth=0  marginheight=0  scrolling=no>

        </iframe>

    </div>
<#include "common/footerCopyright.ftl"/>
</div>
    <#include "common/footer.ftl"/>
<script>

    $(".nav-link-first").on("click",function () {
        $('.nav-link-first').removeClass("active");
        $(this).addClass("active");
    });
    $(".nav-link-second").on("click",function () {
        $('.nav-link-second').removeClass("active");
        $(this).addClass("active");
    });
</script>
</body>
</html>