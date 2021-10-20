<%@page import="com.qt.sad.model.Tblsystemparameter"%>
<%@page import="com.qt.sad.service.System_Parameter_service"%>
<%@page import="java.io.File"%>
<%@page import="com.qt.sad.enums.ResponseMessages"%>
<%@page import="com.qt.sad.model.Tblproject"%>
<%@page import="com.qt.sad.service.Project_service"%>
<%@page import="com.qt.sad.service.Db_service"%>
<%@page import="com.qt.sad.model.Tbldb"%>
<%@page import="com.qt.sad.service.Subdomain_service"%>
<%@page import="com.qt.sad.model.Tblsubdomain"%>
<%@page import="com.qt.sad.utility.Utils"%>
<%@page import="com.qt.sad.service.User_service"%>
<%@page import="com.qt.sad.model.Tbluser"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Dashboard</title>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="Assets/mycss/style4.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    </head>
    <body>

        <%
            User_service user_service = new User_service();
            Tbluser user = user_service.select_user(String.valueOf(session.getAttribute("user_id")));
            Subdomain_service subdomain_service = new Subdomain_service();
            Db_service db_service = new Db_service();
            Project_service project_service = new Project_service();
            System_Parameter_service system_Parameter_service = new System_Parameter_service();
        %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div id="dynamicContent">
                    <h4 class=" text-success"><i class="fas fa-home"></i>&nbsp;Home</h4>
                    <hr>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card bg-light mb-3" style="max-width: 100%;">
                                <div class="card-header"> <h5><i class="fas fa-laptop text-success"></i> &nbsp;&nbsp;Overview</h5></div>
                                <div class="card-body">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td> <span>Name: </span></td>
                                                <td> <span><%= user.getName()%></span></td>
                                            </tr>
                                            <tr>
                                                <td> <span>Mobile: </span></td>
                                                <td> <span><%= user.getMobile()%></span></td>
                                            </tr>
                                            <tr>
                                                <td> <span>Email: </span></td>
                                                <td> <span><%= user.getEmail()%></span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card bg-light mb-3" style="max-width: 100%;">
                                <div class="card-header"> <h5><i class="fas fa-credit-card text-success"></i> &nbsp;&nbsp;My Subscription</h5></div>
                                <div class="card-body">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td><span> Plan:</span></td>
                                                <td><span>Java-Web-Hosting (<i class="fas fa-lock"></i> Locked)</span></td>
                                            </tr>
                                            <tr>
                                                <td> <span> Validity:</span></td>
                                                <td> <span><%= "30 days left"%></span></td>
                                            </tr>
                                            <tr>
                                                <td><span> Purchased:</span></td>
                                                <td><span><%= "4-10-2021"%></span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>       
                            </div> 
                        </div>
                    </div>
                    <div class="row" >
                        <div class="col-md-4">
                            <div class="card bg-light mb-3" style="max-width: 100%;">
                                <div class="card-header">
                                    <%
                                        Tblsubdomain subdomain = subdomain_service.selectByUserId(String.valueOf(session.getAttribute("user_id")));
                                    %>
                                    <h5>
                                        <i class="fas fa-check-circle text-success"></i> &nbsp;&nbsp;My Subdomain &nbsp;&nbsp;&nbsp;
                                        <a <%= !subdomain_service.checkSubdomainByUserId(String.valueOf(session.getAttribute("user_id"))) ? "" : "hidden"%> href="user_subdomain.jsp" ><i class="fa fa-edit text-success"></i></a>
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <%
                                        if (!subdomain_service.checkSubdomainByUserId(String.valueOf(session.getAttribute("user_id")))) {
                                    %>
                                    <h5>Setup Subdomain &nbsp;</h5>
                                    <%
                                    } else {
                                    %>
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td> <span>Subdomain: </span></td>
                                                <td>
                                                    <a href="<%= "http://www." + subdomain.getSubdomain() + ".qaswatechnlogies.com"%>" target="_">
                                                        <span class="text-success"><%= subdomain.getSubdomain()%><span class="text-dark">.qaswatechnologies.com</span></span>
                                                        &nbsp; <i class="text-success bi bi-arrow-up-right-square"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td> <span>Created: </span></td>
                                                <td>
                                                    <span><%= Utils.isEmpty(subdomain.getCreated_at().substring(0, 10)) ? "Please setup your domain" : subdomain.getCreated_at().substring(0, 10)%></span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card bg-light mb-3" style="max-width: 100%;">
                                <div class="card-header">
                                    <%
                                        Tbldb db = db_service.selectByUserId(String.valueOf(session.getAttribute("user_id")));
                                    %>
                                    <h5>
                                        <i class="fas fa-database text-success"></i> &nbsp;&nbsp;My Database &nbsp;&nbsp;&nbsp;
                                        <a <%= !db_service.checkDbByUserId(String.valueOf(session.getAttribute("user_id"))) ? "" : "hidden"%> href="user_database.jsp" ><i class="fa fa-edit text-success"></i></a>
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <%
                                        if (!db_service.checkDbByUserId(String.valueOf(session.getAttribute("user_id")))) {
                                    %>
                                    <h5>
                                        Setup Database &nbsp;
                                    </h5>
                                    <%
                                    } else {
                                    %>
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td> <span>Database: </span></td>
                                                <%
                                                    String dbName = db.getDb().replace(user.getUser_id(), "");
                                                %>
                                                <td> <span class="text-success"><%= db_service.checkDbByUserId(String.valueOf(session.getAttribute("user_id"))) ? dbName : "Please setup your Database"%></span></td>
                                            </tr>
                                            <tr>
                                                <td><span> Name: </span></td>
                                                <td><span><%= db_service.checkDbByUserId(String.valueOf(session.getAttribute("user_id"))) ? db.getDbname() : "Please setup your Database"%></span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="card bg-light mb-3" style="max-width: 100%;">
                                <div class="card-header">
                                    <h5>
                                        <i class="fas fa-cog text-success"></i> &nbsp;&nbsp;My Project &nbsp;&nbsp;&nbsp;
                                        <a <%= !project_service.checkProjectByUserId(String.valueOf(session.getAttribute("user_id"))) ? "" : "hidden"%> href="user_project.jsp" ><i class="fa fa-edit text-success"></i></a>
                                    </h5>
                                </div>
                                <div class="card-body">
                                    <%
                                        if (!project_service.checkProjectByUserId(String.valueOf(session.getAttribute("user_id")))) {
                                    %>
                                    <h5>
                                        Setup Project &nbsp;
                                    </h5>
                                    <%
                                    } else {
                                        Tblproject project = project_service.selectByUserId(String.valueOf(session.getAttribute("user_id")));
                                    %>
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td> <span>Project:</span></td>
                                                <%
                                                    String projectName = project.getProject().replace(user.getUser_id(), "");
                                                %>
                                                <td> <span class="text-success"><%= project_service.checkProjectByUserId(String.valueOf(session.getAttribute("user_id"))) ? projectName : "Please upload your project"%></span></td>
                                            </tr>
                                            <tr>
                                                <td><span> Uploaded:</span></td>
                                                <td><span><%= project_service.checkProjectByUserId(String.valueOf(session.getAttribute("user_id"))) ? project.getCreated_at() : "Please upload your project"%></span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <%
                                        }
                                    %>
                                </div>
                            </div>
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
    </body>

</html>