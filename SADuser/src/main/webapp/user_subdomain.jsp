<%-- 
    Document   : subdomain
    Created on : 27 Sep, 2021, 4:30:16 PM
    Author     : LENOVO
--%>

<%@page import="com.qt.sad.service.Subdomain_service"%>
<%@page import="com.qt.sad.model.Tblsubdomain"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Subdomain</title>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="Assets/mycss/style4.css">

        <!-- Font Awesome JS -->
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

        <script>
            function changeSubDomain() {
                var x = document.getElementById("subdomain").value;
                document.getElementById("subdomain_show").innerHTML = "www." + x + ".qaswatechnologies.com";
            }
        </script>

    </head>
    <body>
        <%
            Subdomain_service subdomain_service = new Subdomain_service();
            Tblsubdomain subdomain = subdomain_service.selectByUserId(session.getAttribute("user_id").toString());
        %>
        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>
                <div class="container">
                    <h4 class="text-success"><i class="fas fa-copy"></i>&nbsp;Add Subdomain </h4>
                    <br>
                    <p>
                        Subdomains are Internet addresses for different sections of your website. They use your main domain name and a prefix.
                        For example, if your domain is qaswatech.com, a subdomain might be student.qaswatech.com.
                        Visitors will be see your website regardless of the subdomain name they enter in a browser. </p>
                    <br>

                    <%                                        if (subdomain_service.checkSubdomainByUserId(session.getAttribute("user_id").toString())) {
                    %>
                    <div class="form-row">
                        <div class="col-md-2" >
                            <div class="input-group">
                                <span class="input-group-text bg-light border border-white" for="">Subdomain</span>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <div class="input-group">
                                <p class="input-group-text bg-light"><%= "www." + subdomain.getSubdomain() + ".qaswatechnologies.com"%></p>
                                &nbsp;&nbsp;
                                <button type="submit" class="btn btn-outline-success d-none d-md-block" data-toggle="modal" data-target="#edit-subdomain">Edit</button>
                            </div>
                            <div class="input-group">
                                <button type="submit" class="btn btn-outline-success btn-block mt-2 d-block d-md-none d-lg-none" data-toggle="modal" data-target="#edit-subdomain">Edit</button>
                            </div>
                        </div>
                    </div>

                    <!-- Modal -->
                    <div class="modal fade bd-example-modal-lg" id="edit-subdomain" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Edit Subdomain</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form method="post" action="Subdomain_controller" name="frm">
                                    <input type="hidden" name="action" value="update_subdomain">
                                    <div class="modal-body">
                                        <input type="hidden" name="txtUserid" value="<%= session.getAttribute("user_id")%>">
                                        <input type="hidden" name="txtSubdomainid" value="<%= subdomain.getSubdomain_id()%>">
                                        <div class="input-group">
                                            <span class="input-group-text bg-light border border-white" for="">Enter Subdomain</span>
                                        </div>
                                        <div class="input-group">
                                            <input type="text" class="form-control" name="txtSubdomain" value="<%= subdomain.getSubdomain()%>" required id="subdomain" onkeyup="changeSubDomain()" />
                                        </div>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-text bg-light border border-white" for="">Your Subdomain</span>
                                        </div>
                                        <div class="input-group">
                                            <span class="form-control border-dark bg-light" id="subdomain_show">www.<%= subdomain.getSubdomain()%>.qaswatechnologies.com</span>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-success btn-sm" name="action" value="update_subdomain">Save subdomain</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- /Modal -->
                    <%
                    } else {
                    %>
                    <form method="post" action="Subdomain_controller" name="frm" >
                        <div class="form-row">
                            <div class="col-md-2" >
                                <div class="input-group">
                                    <span class="input-group-text bg-light border border-white" for="">Subdomain</span>
                                </div>
                            </div>
                            <div class="col-md-10">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupPrepend2">www.</span>
                                    </div>
                                    <input type="hidden" name="txtUserid" value="<%= session.getAttribute("user_id")%>">
                                    <input type="hidden" name="action" value="insert_subdomain">
                                    <input type="text" class="form-control" name="txtSubdomain" placeholder="your_subdomain" required id="subdomain" onkeyup="changeSubDomain()" />
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroupPrepend2">.qaswatechnologies.com</span> 
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br><br>
                        <div class="form-row">
                            <div class="col-md-2" >
                                <div class="input-group">
                                    <span class="input-group-text bg-light border border-white" for="">Subdomain will be</span>
                                </div>
                            </div>
                            <div class="col-md-10">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="form-control border-dark bg-light float-start" id="subdomain_show">www.your_subdomain.qaswatechnologies.com</span>
                                        <button type="submit" class="btn btn-outline-success" onclick="return val();">create</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <%
                        }
                    %>
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
