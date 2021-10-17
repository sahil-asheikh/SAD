
<%@page import="com.qt.sad.utility.Utils"%>
<%
    if (Utils.isEmpty(String.valueOf(session.getAttribute("admin_id")))) {
        response.sendRedirect("index.jsp?msg=Login Frist");
    }
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <button type="button" id="sidebarCollapse" class="btn btn-success">
            <i class="fas fa-align-left"></i>
            <span></span>
        </button>
        &nbsp;&nbsp;
        <h5 class="text-success">${param.message}</h5>
    </div>
</nav>