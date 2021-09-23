/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qt.sad.Test;

import java.io.File;

/**
 *
 * @author Azher
 */
public class TestDeleteFIleFromRoot {
    
    public static void main(String[] args) {
            
try  
{         
File f= new File("uploads\\t1.txt");           //file to be delete  
if(f.delete())                      //returns Boolean value  
{  
System.out.println(f.getName() + " deleted");   //getting and printing the file name  
}  
else  
{  
System.out.println("failed");  
}  
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
    }
}
    

