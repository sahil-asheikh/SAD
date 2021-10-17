<%-- 
    Document   : admin_show_sp
    Created on : 14 Oct, 2021, 1:21:52 PM
    Author     : LENOVO
--%>

<%@page import="java.util.List"%>
<%@page import="com.qt.sad.service.System_Parameter_service"%>
<%@page import="com.qt.sad.model.Tblsystemparameter"%>
<%@page import="com.qt.sad.service.Admin_service"%>
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
            System_Parameter_service system_Parameter_service = new System_Parameter_service();
        %>
        <div class="wrapper">
            <%@include file="sideBar.jsp" %>
            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>

                <h3>System Parameters</h3>
                <hr>
                <div id="DynamicTable">
                    <table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
                        <thead>
                            <tr>
                                <th scope="col">System Parameter Name</th>
                                <th scope="col">System Parameter Value</th>
                                <th scope="col">ACTION</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%                                List<Tblsystemparameter> parameters = system_Parameter_service.select_system_parameters();
                                for (Tblsystemparameter sp : parameters) {
                            %>
                            <tr>
                                <td>
                                    <%= Utils.isEmpty(sp.getSystem_parameter_name()) ? "Empty Parameter Name" : sp.getSystem_parameter_name()%>
                                </td>
                                <td>
                                    <%= Utils.isEmpty(sp.getSystem_parameter_value()) ? "Empty Parameter Value" : sp.getSystem_parameter_value()%>
                                </td>
                                <td>
                                    <a class="btn btn-sm btn-primary" href="update_System_Parameter.jsp?sp_name=<%= sp.getSystem_parameter_name()%>">
                                        Update
                                    </a>
                                    <a class="btn btn-sm btn-danger" href="System_Parameter_controller?action=delete&sp_name=<%= sp.getSystem_parameter_name()%>">
                                        Delete
                                    </a>

                                </td>
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
