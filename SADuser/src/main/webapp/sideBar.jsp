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
        <li class="<%= pageName.equals("user_dashboard") ? "active" : ""%>">
            <a href="user_dashboard.jsp">
                <i class="fas fa-home"></i> Home
            </a>
        </li>
        <li class="<%= pageName.equals("user_profile") ? "active" : ""%>">
            <a href="user_profile.jsp">
                <i class="fas fa-user"></i> Profile
            </a>
        </li>
        <li class="<%= pageName.equals("user_subdomain") ? "active" : ""%>">
            <a href="user_subdomain.jsp">
                <i class="fas fa-copy"></i> SubDomain
            </a>
        </li>
        <li class="<%= pageName.equals("user_project") ? "active" : ""%>">
            <a href="user_project.jsp"">
                <i class="fas fa-globe"></i> Project
            </a>
        </li>
        <li class="<%= pageName.equals("user_database") ? "active" : ""%>">
            <a href="user_database.jsp">
                <i class="fas fa-database"></i> Database
            </a>
        </li>
        <li>
            <a href="User_controller?action=logout">
                <i class="fas fa-power-off"></i> Logout
            </a>
        </li>
    </ul>
</nav>
