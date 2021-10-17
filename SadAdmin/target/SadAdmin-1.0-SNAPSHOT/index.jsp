<%-- 
    Document   : login
    Created on : Sep 11, 2019, 4:43:15 PM
    Author     : Azher
--%>


<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAD</title>

        <!-- Bootstrap CSS CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

        <!-- Datatable css -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">

        <!-- Our Custom CSS -->
        <link rel="stylesheet" href="Assets/mycss/style4.css">

        <!-- Font Awesome JS -->
        <!--Sweet Alert -->
        <script src="Assets/myjs/sweetalert.js"></script>
        <link rel="stylesheet" href="Assets/mycss/sweetalert.css">

        <!-- Validation -->

    </head>
    <body>
        <div class="wrapper">
            <!-- Sidebar  -->
            <!-- Page Content  -->
            <div id="content">
                <div class="row">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-4">
                        <div class="shadow-lg p-3 mb-5 bg-success rounded">
                            <form method="post" action="Admin_controller">
                                <input type="hidden" class="form-control" name="action" value="login">
                                <h3 class="text-center text-light">Admin Login</h3>
                                <div class="text-light">
                                    <div class="form-group">
                                        <hr class="my-4 bg-light">
                                        <label >Mobile Number</label>
                                        <input type="number" class="form-control" placeholder="Enter Mobile Number" name="user" required="">
                                    </div>
                                    <div class="form-group">
                                        <label for="">Password</label>
                                        <input type="password" class="form-control" placeholder="Enter Your Password" name="pass" required="">
                                        <hr class="my-4 bg-light">
                                        <input type="submit" class="btn btn-outline-light btn-sm" style="margin-left: 35%"  value="Login" onclick="return val();">
                                        <a href="signup.jsp"> <input type="button" class="btn btn-outline-light btn-sm" value="Sign up"> </a>
                                        <span class="text-danger">${param.message}</span>
                                    </div>
                                </div>
                            </form>
                            <hr class="my-4 bg-light">
                        </div>
                    </div>
                    <div class="col-sm-4 bg-light"></div> 
                </div>
            </div>
            <!-- /content-->
        </div>
        <!--Main Div Close -->   



        <!-- jQuery CDN - Slim version (=without AJAX) -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!-- Popper.JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
        <!--My JAVASCRIPT -->
    </body>
</html>
