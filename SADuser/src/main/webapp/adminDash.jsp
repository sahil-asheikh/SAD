<%-- 
    Document   : adminDash
    Created on : Dec 16, 2019, 6:26:30 PM
    Author     : Azher
--%>

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


        <script>
            function subscription() {

                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("DynamicTable").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "subscription.jsp", true);
                xhttp.send();

            }
            function MoreMyModal(id) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 1) {
                        document.getElementById("printFromAjax").innerHTML = "Please Wait.....";
                    } else if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("printFromAjax").innerHTML =
                                this.responseText;
                    }
                };
                xhttp.open("GET", "modalDetail.jsp?id=" + id, true);
                xhttp.send();
            }
        </script>
    </head>

    <body>
        <div class="wrapper">
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3>ADMIN-DASH</h3>
                    <strong>ADMIN</strong>
                </div>

                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="dashboard.jsp">
                            <i class="fas fa-home"></i>
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-user"></i>
                            Name
                        </a>
                        <a href="#" onclick="subscription()">
                            <i class="fas fa-copy"></i>
                            Subscriptions
                        </a>

                    </li>

                    <li>
                        <a href="#" onclick="uploadProject()">
                            <i class="fas fa-globe"></i>
                            Students
                        </a>
                    </li>


                    <li>
                        <a href="#">
                            <i class="fas fa-power-off"></i>
                            logout
                        </a>
                    </li>
                </ul>

                <ul class="list-unstyled CTAs">
                    <li>
                        <a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">Download source</a>
                    </li>
                    <li>
                        <a href="https://bootstrapious.com/p/bootstrap-sidebar" class="article">Back to article</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content  -->
            <div id="content">

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button type="button" id="sidebarCollapse" class="btn btn-success">
                            <i class="fas fa-align-left"></i>
                            <span></span>
                        </button>
                        <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="nav navbar-nav ml-auto">
                                <li class="nav-item active">
                                    <a class="nav-link" href="#"><i class="fas fa-power-off"></i> &nbsp; Logout</a>
                                </li>

                            </ul>
                        </div>
                    </div>
                </nav>

                <div id="DynamicTable">



                    <hr class="mt-2 mb-5">
                    <span class="text-success">${param.message}</span> 
                    <!-- table -->

                    <table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
                        <%

                        %>
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
                            <tr>
                                <td><%= "NAME"%></td>
                                <td><%= "MOBILE"%></td>
                                <td><%= "EMAIL"%></td>
                                <td><%= "EDUCATION"%></td>
                                <td><%= "COLLEGE"%></td>
                                <td><%= "CITY"%></td>
                                <td title="<%= "DATE"%><%= "DATE".substring(0, 10)%></td>
                                <td><a href="" title="More" class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModalCenter" onclick="MoreMyModal(<%= "USER_ID"%>)"><i class="fas fa-eye"></i></a>
                                    <a href="#" title=" Delete" class="btn btn-warning btn-sm"><i class="fas fa-trash-alt"></i></a>
                                    <a href="dealerUpdate.jsp?id=<%="USER_ID"%>" title="Edit" class="btn btn-success btn-sm"><i class="fas fa-edit"></i></a>
                                </td>
                            </tr>
                        </tbody>
                        <tfoot>
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
                        </tfoot>
                    </table>
                </div>
                <h5 class="text-success">${param.message}</h5>
            </div>

            <!-- Modal -->

            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">

                            <h5 class="modal-title" id="exampleModalCenterTitle">Project Details</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>

                        </div>
                        <!-- replaace using Ajax-->
                        <div class="modal-body" id="printFromAjax">

                        </div> 
                        <!-- /replaace using Ajax-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary hide-modal" data-dismiss="modal">Close</button>

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