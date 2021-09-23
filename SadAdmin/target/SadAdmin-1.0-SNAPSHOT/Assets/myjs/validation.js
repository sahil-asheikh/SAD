
function val() {
    // alert("mytesta");
    //  alert("mytesta111");

    //   swal("Here's a message!", "It's pretty, isn't it?")

    var mobPattern = /^[789]{1}[0-9]{9}$/;

    // name validation           
    if (frm.txtFirstName.value === "") {

        swal("Name !", "Please enter your name", "error")
        frm.txtFirstName.focus();
        return false;
    }
    if (!isNaN(frm.txtFirstName.value)) {

        swal("Name !", "Should be Characters", "error")
        frm.txtFirstName.focus();
        return false;
    }
    if (frm.txtLastName.value === "") {
        // alert("Name Should Not Blank");
        swal("Last Name !", "Please enter your LastName", "error")
        frm.txtFirstName.focus();
        return false;
    }
    if (!isNaN(frm.txtFirstName.value)) {
        swal("Name!", "Should be Characters", "error")
        frm.txtFirstName.focus();
        return false;
    }
    if ((frm.txtFirstName.value < 2)) {
        swal("Name !", "Minimum 2 charecter", "error")
        frm.txtFirstName.focus();
        return false;
    }
     if ((frm.txtLastName.value).length < 2) {
        swal("Surname !", "Minimum 2 charecter", "error")
        frm.txtFirstName.focus();
        return false;
    }
    if ((frm.txtFirstName.value > 100)) {
        swal("Name !", "Max 100 characters ", "error")
        frm.txtFirstName.focus();
        return false;
    }
    // phone no. validation
    if (frm.txtContact.value == "") {
        swal("Mobile !", "Please enter mobile number", "error")
        frm.txtContact.focus();
        return false;
    }
    if (isNaN(frm.txtContact.value)) {
        swal("Mobile !", "Enter Correct Mobile Number", "error")
        frm.txtContact.focus();
        return false;
    }
    if ((frm.txtContact.value).length < 10 || (frm.txtContact.value).length > 10) {
        swal("Mobile !", "Enter Correct Mobile Number", "error")
        frm.txtContact.focus();
        return false;
    }
    if (!frm.txtContact.value.match(/^[789]{1}[0-9]{9}$/)) {
        swal("Mobile !", "Enter Correct Mobile Number", "error")
        frm.txtContact.focus();
        return false;
    }
    if (frm.txtContact.value == "") {
        swal("Mobile !", "Enter Correct Mobile Number", "error")
        frm.txtContact.focus();
        return false;
    }
    
    if (frm.txtEmail.value == "") {

        swal("Email !", "Please enter email id", "error")
        frm.txtEmail.focus();
        return false;
    }

    if (frm.txtPass.value == "" || frm.txtConfirmPass.value == "") {
        swal("Password !", "Enter your Password", "error")
        frm.txtPass.focus();
        return false;
    }
    if ((frm.txtPass.value).length < 2 || (frm.txtConfirmPass.value).length < 4) {
        swal("Password", " minimum 4 characters", "error");
        frm.txtPass.focus();
        return false;
    }
    if (frm.txtCollege.value == "") {
        swal("College Name !", "Enter Your College Name", "error")
        frm.txtCollege.focus();
        return false;
    }
    if (frm.txtCity.value == "") {
        // alert("Name Should Not Blank");
        swal("City !", "Enter Your City", "error")
        frm.txtCity.focus();
        return false;
    }


    return true;

}
//password ConfirmPassword
var check = function ()
{
    if (document.getElementById('password').value == document.getElementById('confirm_password').value)
    {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Password Matched'
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Not Mached'
    }
}

var checkNum = function ()
{
    if (!(frm.txtFirstName.value === "")) {
        if (!isNaN(frm.txtFirstName.value)) {
            swal("Name !", "Should be Characters", "error")
            frm.txtFirstName.focus();
            frm.txtFirstName.innerHTML = "eeee";

            return false;

        }
    }
}
var checkNum1 = function () {
    if (!(frm.txtLastName.value === "")) {
        if (!isNaN(frm.txtLastName.value)) {
            swal("Surname !", "Should be Characters", "error")

            frm.txtLastName.focus();
            return false;
        }
    }
}
