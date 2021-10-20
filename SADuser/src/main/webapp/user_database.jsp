<%-- 
    Document   : user_database
    Created on : 27 Sep, 2021, 4:39:33 PM
    Author     : LENOVO
--%>

<%@page import="java.io.File"%>
<%@page import="com.qt.sad.enums.ResponseMessages"%>
<%@page import="com.qt.sad.service.Db_service"%>
<%@page import="com.qt.sad.model.Tbldb"%>
<%@page import="com.qt.sad.model.Tblsubdomain"%>
<%@page import="com.qt.sad.service.Subdomain_service"%>
<%@page import="com.qt.sad.model.Tbluser"%>
<%@page import="com.qt.sad.service.User_service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Database</title>

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
            Subdomain_service subdomain_service = new Subdomain_service();
            Tblsubdomain subdomain = subdomain_service.selectByUserId(session.getAttribute("user_id").toString());

            Db_service db_service = new Db_service();
        %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>

                <div class="container">
                    <div class="form-row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <p>Import Database for this Sub Domain</p>
                                <span class="input-group-text" id="inputGroupPrepend2">
                                    <%= subdomain_service.checkSubdomainByUserId(session.getAttribute("user_id").toString()) ? "www." + subdomain.getSubdomain() + ".qaswatechnologies.com" : "Please setup your domain first"%>
                                </span>
                            </div>
                        </div>
                    </div>
                    <%
                        if (db_service.checkDbByUserId(session.getAttribute("user_id").toString())) {
                            Tbldb db = db_service.selectByUserId(session.getAttribute("user_id").toString());
                    %>
                    <br>
                    <h4 class=" text-success"> <i class="fas fa-database"></i>&nbsp;Stored Database</h4>
                    <br>
                    <form method="post" action="Db_controller" name="frm" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="update_database">
                        <input type="hidden" name="user_id" value="<%= session.getAttribute("user_id")%>">
                        <div class="form-row">
                            <div class="form-group col-md-5">
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <td class="text-success">
                                                Database Name: 
                                            </td>
                                            <td>
                                                <%= Utils.isEmpty(db.getDbname()) ? "Database name not available" : db.getDbname()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="text-success">
                                                Database:
                                            </td>
                                            <td>
                                                <%= Utils.isEmpty(db.getDb_username()) ? "Database username not available" : db.getDb_username()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="text-success">
                                                Database:
                                            </td>
                                            <td>
                                                <%= Utils.isEmpty(db.getDb_password()) ? "Database password not available" : db.getDb_password()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="text-success">
                                                Database File: 
                                            </td>
                                            <td>
                                                <%
                                                    String dbName = db.getDb().replace(String.valueOf(session.getAttribute("user_id")), "");
                                                %>
                                                <%= Utils.isEmpty(db.getDb()) ? "Database file not available" : dbName%>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </form>
                    <%
                    } else {
                    %>
                    <br>
                    <h4 class=" text-success"> <i class="fas fa-database"></i>&nbsp;Import Database</h4>
                    <br>
                    <p>
                        File may be compressed (gzip, zip) or uncompressed.
                        A compressed file's name must end in .[format].[compression]. Example:&nbsp; <span class="text-success"> ( .sql &nbsp;or &nbsp; .zip )</span>
                    </p>
                    <br>
                    <form method="post" action="Db_controller" name="frm" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="insert_database">
                        <input type="hidden" name="user_id" value="<%= session.getAttribute("user_id")%>">
                        <div class="form-row">
                            <div class="form-group col-md-5">
                                <label for="">Database Name</label>
                                <input type="text" name="db_name" class="form-control-file" required="">

                                <label class="mt-2" for="">Database Username</label>
                                <input type="text" name="db_username" class="form-control-file" required="">

                                <label class="mt-2" for="">Database Password</label>
                                <input type="text" name="db_password" class="form-control-file" required="">
                            </div>
                            <div class="form-group col-md-2"></div>
                            <div class="form-group col-md-5">
                                <label for="">Database File</label>
                                <input type="file"  name="database_file" class="form-control-file" id="exampleFormControlFile1" required="" accept=".sql, .zip"> <br>
                                <button type="submit" class="btn btn-outline-success" name="action" value="insert_database" onclick="return val();">Import</button>   
                            </div>
                        </div>
                    </form>
                    <%
                        }
                    %>
                    <!--======================================================-->
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
