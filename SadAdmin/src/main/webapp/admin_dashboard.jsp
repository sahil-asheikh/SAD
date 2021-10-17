<%-- 
    Document   : adminDash
    Created on : Dec 16, 2019, 6:26:30 PM
    Author     : Azher
--%>
<%@page import="com.qt.sad.service.Project_service"%>
<%@page import="com.qt.sad.service.Db_service"%>
<%@page import="com.qt.sad.service.Subdomain_service"%>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="Assets/mycss/style4.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

    </head>

    <body>
        <%
            User_service user_service = new User_service();
            Subdomain_service subdomain_service = new Subdomain_service();
            Project_service project_service = new Project_service();
            Db_service db_service = new Db_service();
        %>
        <div class="wrapper">
            <%@include file="sideBar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div id="DynamicTable">
                    <h3>DASHBOARD</h3>
                    <hr>
                    <div class="row">
                        <div class="col-md-6 mt-2">
                            <div class="card">
                                <div class="card-body">
                                    <p>Total Users</p>
                                    <div class="row">
                                        <div class="col-10">
                                            <h4>
                                                <%= user_service.countUsers()%>
                                            </h4>
                                        </div>
                                        <div class="col-2">
                                            <h4><i class="bi bi-people-fill"></i></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 mt-2">
                            <div class="card">
                                <div class="card-body">
                                    <p>Total Projects</p>
                                    <div class="row">
                                        <div class="col-10">
                                            <h4>
                                                <%= project_service.countProjects()%>
                                            </h4>
                                        </div>
                                        <div class="col-2">
                                            <h4><i class="bi bi-kanban"></i></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4 mt-2">
                            <div class="card">
                                <div class="card-body">
                                    <p>Rejected Projects</p>
                                    <div class="row">
                                        <div class="col-10">
                                            <h4>
                                                <%= user_service.countRejectedProjects()%>
                                            </h4>
                                        </div>
                                        <div class="col-2">
                                            <h4><i class="bi bi-journal-x"></i></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 mt-2">
                            <div class="card">
                                <div class="card-body">
                                    <p>Approved Projects</p>
                                    <div class="row">
                                        <div class="col-10">
                                            <h4>
                                                <%= user_service.countApprovedProjects()%>
                                            </h4>
                                        </div>
                                        <div class="col-2">
                                            <h4><i class="bi bi-check-square"></i></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 mt-2">
                            <div class="card">
                                <div class="card-body">
                                    <p>Pending Projects</p>
                                    <div class="row">
                                        <div class="col-10">
                                            <h4>
                                                <%= user_service.countPendingProjects()%>
                                            </h4>
                                        </div>
                                        <div class="col-2">
                                            <h4><i class="bi bi-hourglass-split"></i></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-2">
                        <div class="card-body">
                            <table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
                                <thead>
                                    <tr>
                                        <th scope="col">SUBSCRIBER</th>
                                        <th scope="col">STATUS</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                List<Tbluser> users = user_service.select_users();
                                        for (Tbluser user : users) {
                                    %>
                                    <tr>
                                        <td><%= Utils.isEmpty(user.getName()) ? "No Name Available" : user.getName()%></td>
                                        <%
                                            if (user.getProject_status() == -1) {
                                        %>
                                        <td><span class="btn btn-sm btn-danger text-light" style="pointer-events: none;">REJECTED</span></td>
                                        <%
                                        } else if (user.getProject_status() == 0) {
                                        %>
                                        <td><span class=" btn btn-sm btn-warning text-light" style="pointer-events: none;">PENDING</span></td>
                                        <%
                                        } else if (user.getProject_status() == 1) {
                                        %>
                                        <td><span class="btn btn-sm btn-success text-light" style="pointer-events: none;">APPROVED</span></td>
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