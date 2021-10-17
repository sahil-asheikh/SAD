<%-- 
    Document   : user_profile
    Created on : 27 Sep, 2021, 4:39:04 PM
    Author     : LENOVO
--%>

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
        <title>Profile</title>

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
            User_service user_service = new User_service();
            Tbluser user = user_service.select_user(session.getAttribute("user_id").toString());
        %>

        <div class="wrapper">
            <!-- Sidebar  -->
            <%@include  file="sideBar.jsp" %>

            <!-- Page Content  -->
            <div id="content">
                <%@include file="topBar.jsp" %>

                <!--PROFILE_CODE-->
                <div class="card card-border card-contrast">
                    <div class="card-body">
                        <blockquote class="blockquote">
                            <table  class="table">
                                <tbody>
                                    <tr>
                                        <td class="text-success">Name: </td>
                                        <td> <%= Utils.isEmpty(user.getName()) ? "No name available" : user.getName()%></td>
                                    </tr>
                                    <tr>
                                        <td class="text-success">Mobile: </td>
                                        <td> <%= Utils.isEmpty(user.getMobile()) ? "No mobile available" : user.getMobile()%></td>
                                    </tr>
                                    <tr>
                                        <td class="text-success">Email: </td>
                                        <td> <%= Utils.isEmpty(user.getEmail()) ? "No email available" : user.getEmail()%></td>
                                    </tr>
                                    <tr>
                                        <td class="text-success">Education: </td>
                                        <td> <%= Utils.isEmpty(user.getEducation()) ? "No education available" : user.getEducation()%></td>
                                    </tr>
                                    <tr>
                                        <td class="text-success">College: </td>
                                        <td> <%= Utils.isEmpty(user.getCollege()) ? "No college available" : user.getCollege()%></td>
                                    </tr>
                                    <tr>
                                        <td class="text-success">City: </td>
                                        <td> <%= Utils.isEmpty(user.getCity()) ? "No city available" : user.getCity()%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </blockquote>
                    </div>
                    <div class="card-footer bg-light">
                        <button class="btn btn-success" data-toggle="modal" data-target="#edit-password">Change password</button>
                        <button class="btn btn-success" data-toggle="modal" data-target="#edit-user">Edit profile</button>

                        <!-- User Modal -->
                        <div class="modal fade bd-example-modal-lg" id="edit-user" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form method="post" action="User_controller" name="frm">
                                        <input type="hidden" name="action" value="update_user">
                                        <input type="hidden" name="user_id" value="<%= session.getAttribute("user_id")%>">
                                        <div class="modal-body">
                                            <input type="hidden" name="txtUserid" value="<%= session.getAttribute("user_id")%>">
                                            <blockquote class="blockquote">
                                                <table  class="table">
                                                    <tbody>
                                                        <tr>
                                                            <td class="text-success">Name: </td>
                                                            <td> <input type="text" class="form-control" id="" placeholder="Enter first Name" name="txtUserName" value="<%= Utils.isEmpty(user.getName()) ? "" : user.getName()%>" onkeyup="checkNum();"> </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-success">Mobile: </td>
                                                            <td> <input type="number" class="form-control" placeholder="Enter Mobile Number" name="txtContact" value="<%= Utils.isEmpty(user.getMobile()) ? "" : user.getMobile()%>"> </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-success">Email: </td>
                                                            <td> <input type="email" class="form-control" placeholder="Enter Email" name="txtEmail" value="<%= Utils.isEmpty(user.getEmail()) ? "" : user.getEmail()%>"> </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-success">Education: </td>
                                                            <td>
                                                                <input class="form-control mb-3 bg-light" placeholder="Select Education" name="txtEducation" value="<%= Utils.isEmpty(user.getEducation()) ? "" : user.getEducation()%>" readonly>
                                                                <div class="row">
                                                                    <div class="col-6">
                                                                        <select name="selectEdu" class="form-control">
                                                                            <option selected value="" >Education</option>
                                                                            <option value="BE">BE</option>
                                                                            <option value="MCA">MCA</option>
                                                                            <option value="MCM">MCM</option>
                                                                            <option value="PGDCA">PGDCA</option>
                                                                            <option value="BCA">BCA</option>
                                                                            <option value="BCOM">BCOM</option>
                                                                            <option value="OTHER">OTHER</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="col-6">
                                                                        <select name="selectSem" class="form-control">
                                                                            <option selected value="" >Semester</option>
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
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-success">College: </td>
                                                            <td>
                                                                <input type="text" class="form-control" placeholder="Enter College Name" name="txtCollege" value="<%= Utils.isEmpty(user.getCollege()) ? "" : user.getCollege()%>">
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td class="text-success">City: </td>
                                                            <td>
                                                                <input type="text" class="form-control" placeholder="Enter City Name" name="txtCity" value="<%= Utils.isEmpty(user.getCity()) ? "" : user.getCity()%>">
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </blockquote>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-success btn-sm" name="action" value="update_user">Save</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /User Modal -->

                        <!-- Password Modal -->
                        <div class="modal fade bd-example-modal-lg" id="edit-password" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Change Password</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <form method="post" action="User_controller" name="frm">
                                        <input type="hidden" name="action" value="update_password">
                                        <input type="hidden" name="user_id" value="<%= session.getAttribute("user_id")%>">
                                        <div class="modal-body">
                                            <input class="form-control" name="old_password"  type="text" required=""  placeholder="Enter the password you remember">
                                            <br>
                                            <input class="form-control" name="new_password" id="newPwd" required="" type="password"  onkeyup="checkPassword();" placeholder="Enter new password">
                                            <br>
                                            <input class="form-control" name="confirmPassword" id="confirmPwd" required="" type="password"  onkeyup="checkPassword();" placeholder="ReEnter password">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-success btn-sm" name="action" value="update_password">Save</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /Password Modal -->

                    </div>
                </div>
                <!--//PROFILE_CODE-->

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
