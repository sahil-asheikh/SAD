<%-- 
    Document   : admin_students
    Created on : 6 Oct, 2021, 12:47:41 PM
    Author     : LENOVO
--%>

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

        <!--AJAX script to view student-->
        <script>
            function viewUser(user_id) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("dynamicUser").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "view_user.jsp?user_id=" + user_id, true);
                xhttp.send();

            }
        </script>
        <!--//AJAX script to view student-->

    </head>

    <body>
        <%
            User_service user_service = new User_service();
        %>
        <div class="wrapper">
            <%@include file="sideBar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div id="DynamicTable">
                    <h3>Students</h3>
                    <hr>
                    <table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">NAME</th>
                                <th scope="col">MOB</th>
                                <th scope="col">EMAIL</th>
                                <th scope="col">EDUCATION</th>
                                <th scope="col">COLLEGE</th>
                                <th scope="col">CITY</th>
                                <th scope="col" title="DateOfSubscription">DOS</th>
                                <th scope="col">ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                List<Tbluser> users = user_service.select_users();
                                for (Tbluser user : users) {
                            %>
                            <tr>
                                <td><%= user.getName()%></td>
                                <td><%= user.getMobile()%></td>
                                <td><%= user.getEmail()%></td>
                                <td><%= user.getEducation()%></td>
                                <td><%= user.getCollege()%></td>
                                <td><%= user.getCity()%></td>
                                <td title="<%= user.getCreated_at()%>"><%= user.getCreated_at().substring(0, 10)%></td>
                                <td>
                                    <a href="#" title="View Student" class="btn btn-info btn-sm" data-toggle="modal" data-target="#view_userModal" onclick="viewUser('<%= user.getUser_id()%>');">
                                        <i class="fas fa-eye"></i>
                                    </a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <!--MODAL TO VIEW USER-->
                <div class="modal fade bd-example-modal-lg" id="view_userModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Student Details</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div id="dynamicUser">

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary btn-info" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--//MODAL TO VIEW USER-->
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
