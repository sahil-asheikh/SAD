<%-- 
    Document   : project
    Created on : 27 Sep, 2021, 4:36:27 PM
    Author     : LENOVO
--%>

<%@page import="com.qt.sad.enums.ResponseMessages"%>
<%@page import="java.io.File"%>
<%@page import="com.qt.sad.service.Project_service"%>
<%@page import="com.qt.sad.model.Tblproject"%>
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
        <title>Project</title>

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

            Project_service project_service = new Project_service();
        %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>

                <div class="container">
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <p for="">Project for this Sub Domain</p>
                            <span class="input-group-text" id="inputGroupPrepend2">
                                <%= subdomain_service.checkSubdomainByUserId(session.getAttribute("user_id").toString()) ? "www." + subdomain.getSubdomain() + ".qaswatechnologies.com" : "Please setup your domain first"%>
                            </span>
                        </div>
                    </div>
                    <%
                        if (project_service.checkProjectByUserId(session.getAttribute("user_id").toString())) {
                            Tblproject project = project_service.selectByUserId(session.getAttribute("user_id").toString());
                    %>
                    <br>
                    <h4 class=" text-success"><i class="fas fa-globe"></i> &nbsp; Hosted Application</h4>
                    <br>
                    <form  method="post" action="Project_controller" name="frm" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="update_project">
                        <div class="form-group">
                            <table class="table">
                                <tbody>
                                    <tr>
                                        <td class="text-success">
                                            Project:
                                        </td>
                                        <td>
                                            <%
                                                String projectName = project.getProject().replace(ResponseMessages.PROJECT_PATH.getResponseMessages() + String.valueOf(session.getAttribute("user_id")), "");
                                            %>
                                            <%= Utils.isEmpty(project.getProject()) ? "Project is not available" : projectName%>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </form>
                    <%
                    } else {
                    %>
                    <h4 class="mt-3 d-none d-md-block text-success"><i class="fas fa-globe"></i> &nbsp; Host new java application</h4>
                    <h5 class="mt-3 d-block d-md-none d-lg-none text-success"><i class="fas fa-globe"></i> &nbsp; Host new java application</h5>
                    <br>
                    <span>Upload .WAR file or .ZIP file</span>
                    <br><br>
                    <form  method="post" action="Project_controller" name="frm" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="insert_project">
                        <div class="form-group">
                            <input type="hidden" name="user_id" value="<%= session.getAttribute("user_id").toString()%>">
                            <input type="file" class="form-control-file"  name="project_file" size="50" required="" accept=".war, .zip">
                        </div>
                        <button type="submit" class="btn btn-outline-success" onclick="return val();" name="action" value="insert_project">Upload</button>
                    </form>
                    <%
                        }
                    %>

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
