<!-- Main Sidebar Container -->
  <aside class="main-sidebar elevation-4 sidebar-light-success">
      <!-- Brand Logo -->
      <a href="/" class="brand-link bg-primary">
          <img src="${base}/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
               style="opacity: .8">
          <span class="brand-text font-weight-light">欢迎使用</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar scll-container">
          <!-- Sidebar user panel (optional) -->
          <div class="user-panel mt-3 pb-3 mb-3 d-flex">
              <div class="image">
                  <img src="${base}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
              </div>
              <div class="info">
                  <a href="#" class="d-block">牛犇</a>
              </div>
          </div>

          <!-- Sidebar Menu -->
          <nav class="mt-2">
              <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                  <!-- Add icons to the links using the .nav-icon class
                       with font-awesome or any other icon font library -->
                  <#list Session["authBeanList"] as auth>
                  <li class="nav-item <#if auth.hasMenu=true>has-treeview</#if>">
                      <a href="<#if auth.hasMenu=true><#else>${auth.url}</#if>" class="nav-link nav-link-first">
                          <i class="nav-icon ${auth.icon}"></i>
                          <p>${auth.name}
                            <#if auth.hasMenu=true><i class="right fa fa-angle-left"></i></#if>
                          </p>
                      </a>
                      <#if auth.hasMenu=true>
                      <ul class="nav nav-treeview">
                          <#list auth.menuList as menu>
                              <li class="nav-item">
                                  <a href="${menu.url}" class="nav-link nav-link-second"  target="content">
                                      <i class="${menu.icon} nav-icon"></i>
                                      <p>${menu.name}</p>
                                  </a>
                              </li>
                          </#list>
                      </ul>
                      </#if>
                  </li>
                  </#list>
              </ul>
          </nav>
          <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
  </aside>
