<%@page import="java.sql.ResultSet"%>
<%@page import="com.qt.sad.commons.DatabaseConnect"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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

        <script>
            function addDomain() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("dynamicContent").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "addDomain.jsp", true);
                xhttp.send();
            }
            function uploadProject() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("dynamicContent").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "uploadProject.jsp", true);
                xhttp.send();
            }
            function addDb() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("dynamicContent").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "addDB.jsp", true);
                xhttp.send();
            }
        </script>
    </head>

    <body>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div id="dynamicContent">  
                    <h4 class=" text-success"><i class="fas fa-home"></i>&nbsp;Home </h4>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="card bg-light mb-3" style="max-width: 30rem;">
                                <div class="card-header"> <h5><i class="fas fa-laptop text-success"></i> &nbsp;&nbsp;Overview</h5></div>
                                <div class="card-body">
                                    <table class="table">
                                        <tbody>
                                            <tr>
                                                <td> <span>Setup Date :</span></td>
                                                <td> <span>April 19, 2018</span></td>
                                            </tr>
                                            <tr>
                                                <td><span> Service Plan :</span></td>
                                                <td><span>Java-Web-Hosting (<i class="fas fa-lock"></i> Locked)</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card bg-light mb-3" style="max-width: 30rem;">
                                <div class="card-header"> <h5><i class="fas fa-check-circle text-success"></i> &nbsp;&nbsp;My Subscription</h5></div>
                                <div class="card-body">
                                    <table class="table">
                                        <tbody>
                                            <%
                                                Connection con = DatabaseConnect.connectDb();
                                                Statement stmt = null;
                                                int sid = (Integer) session.getAttribute("sid");
                                                System.out.println("yha se" + sid);
                                                try {
                                                    //sql query
                                                    String sql = "SELECT * FROM tblsubdomain where studid =" + sid;

                                                    //execute a query
                                                    stmt = con.createStatement();
                                                    ResultSet rs = stmt.executeQuery(sql);
                                            %>
                                            <tr>
                                                <td> <span>Domain :</span></td>
                                                <% while (rs.next()) {%>
                                                <td> <span><span class="text-success"><%= rs.getString("subdomain")%></span>.qaswatechnologies.com</span></td>
                                                <%}%>
                                            </tr>
                                            <tr>
                                                <td><span> Database name :</span></td>
                                                <td><span>mydatabse.sql</span></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <%    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                %>       
                            </div> 
                        </div>
                    </div>
                    <h5 class="text-success">${param.message}</h5>
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