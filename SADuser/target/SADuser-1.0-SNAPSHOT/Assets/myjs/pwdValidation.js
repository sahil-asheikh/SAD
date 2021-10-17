/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function pwdValidation() {
    
    
     var mobPattern = /^[789]{1}[0-9]{9}$/;
    
     if (frm.validPassword.value === "") {
        swal("Password !", "Enter Password", "error");
        frm.validPassword.focus();
        return false;
    }
    if ((frm.validPassword.value).length < 2 || (frm.validPassword.value).length < 4) {
        swal("Password", " minimum 4 characters", "error");
        frm.validPassword.focus();
        return false;
    }   
//      if (isNaN(frm.validPassword.value)) {
//
//        swal("Password !", " Enter Password ", "error");
//        frm.validPassword.focus();
//        return false;
//      }
//      
      
    if (frm.newPassword.value === "") {
        swal(" New Password !", "Enter Password", "error");
        frm.newPassword.focus();
        return false;
    }
    if ((frm.newPassword.value).length < 2 || (frm.newPassword.value).length < 4) {
        swal(" New Password", " minimum 4 characters", "error");
        frm.newPassword.focus();
        return false;
    }   
   
//    if (isNaN(frm.newPassword.value)) {
//
//        swal("Password !", "Enter new password", "error");
//        frm.newPassword.focus();
//        return false;
//    }
     if (frm.confirmPassword.value === "") {
        swal(" Valid Password !", "Enter new Password", "error");
        frm.confirmPassword.focus();
        return false;
    }
    if ((frm.confirmPassword.value).length < 2 || (frm.confirmPassword.value).length < 4) {
        swal("  valid Password", " minimum 4 characters", "error");
        frm.confirmPassword.focus();
        return false;
    }  
//     if (isNaN(frm.confirmPassword.value)) {
//
//        swal("Password !", " ReEnter the password", "error");
//        frm.confirmPassword.focus();
//        return false;
//    }
   return true; 
}

    

