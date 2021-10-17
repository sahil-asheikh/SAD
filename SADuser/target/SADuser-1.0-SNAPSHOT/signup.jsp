
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAD-Sign up</title>

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

    </head>
    <body>

        <div class="wrapper">
            <!-- Sidebar  -->
            <!-- Page Content  -->
            <div id="content">
                <div class="container">
                    <h3 class="text-center text-success">Sign up <span class="text-secondary" style="font-size: 15px">-for free web hosting</span></h3>
                    <br>
                    <form method="post" action="User_controller" name="frm" >
                        <input type="hidden" name="action" value="register_user">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="">First Name</label>
                                <input type="text" class="form-control" id="" placeholder="Enter first Name" name="txtFirstName" value="" onkeyup="checkNum();">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Last Name</label>
                                <input type="text" class="form-control" id="" placeholder="Enter Last Name" name="txtLastName" onkeyup="checkNum1();">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Mobile No.</label>
                                <input type="number" class="form-control" placeholder="Enter Mobile Number" name="txtContact">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Email Id</label>
                                <input type="email" class="form-control" placeholder="Enter Email Id" name="txtEmail">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Create Password</label>
                                <input type="password" class="form-control" placeholder="Password" name="txtPass" id="password" onkeyup="check();">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Re-Enter Password</label> &nbsp;&nbsp;&nbsp;&nbsp;<span id='message'></span>
                                <input type="password" class="form-control" placeholder="Re-Enter Password" name="txtConfirmPass" id="confirm_password" onkeyup="check();">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Education</label>
                                <select name="selectEdu" class="form-control">
                                    <option selected>Choose...</option>
                                    <option value="BE">BE</option>
                                    <option value="MCA">MCA</option>
                                    <option value="MCM">MCM</option>
                                    <option value="PGDCA">PGDCA</option>
                                    <option value="BCA">BCA</option>
                                    <option value="BCOM">BCOM</option>
                                    <option value="OTHER">OTHER</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">Semister</label>          
                                <select name="selectSem" class="form-control">
                                    <option selected>Choose...</option>
                                    <option value="I">I</option>
                                    <option value="II">II</option>
                                    <option value="III">III</option>
                                    <option value="IV">IV</option>
                                    <option value="V">V</option>
                                    <option value="VI">VI</option>
                                    <option value="VII">VII</option>
                                    <option value="VIII">VIII</option>
                                    <option value="OTHER">OTHER</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">College</label>
                                <input type="text" class="form-control" placeholder="Enter College Name" name="txtCollege">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="">City</label>
                                <input type="text" class="form-control" placeholder="Enter City Name" name="txtCity">
                            </div>
                            <button type="submit" class="btn btn-outline-success" onclick="return val();">Sign in</button>
                        </div>
                    </form>
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

        <!-- Datatable script -->
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>

        <!--My JAVASCRIPT -->    
        <script src="Assets/myjs/validation.js"></script>
    </body>
</html>
