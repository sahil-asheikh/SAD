<%-- 
    Document   : admin_subscriptions
    Created on : 6 Oct, 2021, 12:44:55 PM
    Author     : LENOVO
--%>

<%@page import="com.qt.sad.service.Subdomain_service"%>
<%@page import="com.qt.sad.service.Project_service"%>
<%@page import="com.qt.sad.service.Db_service"%>
<%@page import="java.util.List"%>
<%@page import="com.qt.sad.service.User_service"%>
<%@page import="com.qt.sad.service.Admin_service"%>
<%@page import="com.qt.sad.model.Tbluser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qt.sad.database.Saddu"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Admin</title>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="Assets/mycss/style4.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

    </head>

    <body>
        <%
            Admin_service admin_service = new Admin_service();
            Db_service db_service = new Db_service();
            Project_service project_service = new Project_service();
            Subdomain_service subdomain_service = new Subdomain_service();
            User_service user_service = new User_service();
        %>
        <div class="wrapper">
            <%@include file="sideBar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div id="DynamicTable">
                    <h3>Subscriptions</h3>
                    <hr>
                    <table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">SUBSCRIBER</th>
                                <th scope="col">SUBDOMAIN</th>
                                <th scope="col">PROJECT</th>
                                <th scope="col">DB-FILE</th>
                                <th scope="col">STATUS</th>
                                <th scope="col">ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                List<Tbluser> users = user_service.select_users();
                                for (Tbluser user : users) {
                            %>
                            <tr>
                                <td><%= Utils.isEmpty(user.getName()) ? "No Name Available" : user.getName()%></td>
                                <td><%= Utils.isEmpty(subdomain_service.selectSubDomainName(user.getUser_id())) ? "No Subdomain Available" : subdomain_service.selectSubDomainName(user.getUser_id())%></td>
                                <td>
                                    <a class="btn btn-success btn-sm" href="Project_controller?action=download_project&user_id=<%= user.getUser_id()%>" title="Download Project" >
                                        <i class="fas fa-globe"></i>
                                    </a>
                                </td>
                                <td>
                                    <%= Utils.isEmpty(db_service.selectDbName(user.getUser_id())) ? "No Database Available" : db_service.selectDbName(user.getUser_id())%> = 
                                    <a class="btn btn-success btn-sm" href="Db_controller?action=downoad_database&user_id=<%= user.getUser_id()%>" title="Download database" >
                                        <i class="fas fa-database"></i>
                                    </a>
                                </td>
                                <%
                                    if (user.getProject_status() == -1) {
                                %>
                                <td><span class="btn btn-sm btn-danger text-light" style="pointer-events: none;">REJECTED</span></td>
                                <td>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=1" class="btn btn-success btn-sm">
                                        Approved
                                    </a>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=-1" class="btn btn-danger btn-sm btn-disabled" style="pointer-events: none;">
                                        Rejected
                                    </a>
                                </td>
                                <%
                                } else if (user.getProject_status() == 0) {
                                %>
                                <td><span class=" btn btn-sm btn-warning text-light" style="pointer-events: none;">PENDING</span></td>
                                <td>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=1" class="btn btn-success btn-sm">
                                        Approved
                                    </a>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=-1" class="btn btn-danger btn-sm">
                                        Rejected
                                    </a>
                                </td>
                                <%
                                } else if (user.getProject_status() == 1) {
                                %>
                                <td><span class="btn btn-sm btn-success text-light" style="pointer-events: none;">APPROVED</span></td>
                                <td>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=1" class="btn btn-success btn-sm btn-disabled" style="pointer-events: none;">
                                        Approved
                                    </a>
                                    <a href="User_controller?action=change_status&user_id=<%= user.getUser_id()%>&project_status=-1" class="btn btn-danger btn-sm">
                                        Rejected
                                    </a>
                                </td>
                                <%
                                    }
                                %>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#sidebarCollapse').on('click', function () {
                    $('#sidebar').toggleClass('active');
                });
            });
        </script>
        <!-- Datatable script -->
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });

        </script>
    </body>
</html>
