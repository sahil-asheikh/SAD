
<%@page import="com.qt.sad.utility.Utils"%>
<%
    if (Utils.isEmpty(session.getAttribute("user_id").toString())) {
        response.sendRedirect("login.jsp?msg=Login Frist");
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
<!--        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-align-justify"></i>
        </button>-->

        <!--<div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <span class="float-end" ><%= session.getAttribute("user_name").toString()%></span>
                                </li>
                <li class="nav-item active">
                    <a class="btn bg-light nav-link" href="User_controller?action=logout">
                        <i class="fas fa-power-off"></i> &nbsp; Logout
                    </a>
                </li>
            </ul>
        </div>-->
    </div>
</nav>