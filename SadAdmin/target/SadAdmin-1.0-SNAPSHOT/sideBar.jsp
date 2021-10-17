<%
    String uri = null, pageName = null;
    try {
        uri = request.getRequestURI();
        pageName = uri.substring(uri.lastIndexOf("/") + 1).replace(".jsp", "");
    } catch (Exception e) {
        System.out.println("Page URI : " + e.getMessage());
    }
%>

<nav id="sidebar">
    <div class="sidebar-header">
        <h3>DASHBOARD</h3>
        <strong>SAD</strong>
    </div>

    <ul class="list-unstyled components">
        <li class="<%= pageName.equals("admin_dashboard") ? "active" : ""%>">
            <a href="admin_dashboard.jsp">
                <i class="fas fa-home"></i> Home
            </a>
        </li>
        <li class="<%= pageName.equals("admin_subscriptions") ? "active" : ""%>">
            <a href="admin_subscriptions.jsp">
                <i class="fas fa-user"></i> Subscriptions
            </a>
        </li>
        <li class="<%= pageName.equals("admin_students") ? "active" : ""%>">
            <a href="admin_students.jsp">
                <i class="fas fa-copy"></i> Students
            </a>
        </li>
        <li class="<%= pageName.equals("admin_show_sp") ? "active" : ""%>">
            <a href="admin_show_sp.jsp">
                <i class="fas fa-assistive-listening-systems"></i> Show System Parameters
            </a>
        </li>
        <li class="<%= pageName.equals("admin_system_parameters") ? "active" : ""%>">
            <a href="admin_system_parameters.jsp">
                <i class="fas fa-assistive-listening-systems"></i> Save System Parameters
            </a>
        </li>
        <li>
            <a href="Admin_controller?action=logout">
                <i class="fas fa-power-off"></i> Logout
            </a>
        </li>
    </ul>
</nav>
