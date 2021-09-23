<%-- 
    Document   : testDownload
    Created on : Dec 15, 2019, 4:37:58 PM
    Author     : Azher
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="/images/myw3schoolsimage.jpg" download> 1111

        </a>
        <a href="uploads\CIN.xlsx" download> link-download</a>
        <br>    <a href="database\Dump20190930.sql" download> link download</a>
    </body>
</html>

<%
                 
try  
{         
     String uploadFolder = getServletContext().getRealPath("");
     System.out.println(uploadFolder);

//File f= new File("C:/Users/Azher/Documents/NetBeansProjects/SAD/target/SAD-1.0-SNAPSHOT/uploads/t1.txt");
//File f= new File(uploadFolder+"/uploads/oep-qaswatech.pdf");
File f= new File(uploadFolder+"/database/Dump20190930.sql");

//file to be delete  
if(f.delete())                      //returns Boolean value  
{  
System.out.println(f.getName() + " deleted");   //getting and printing the file name  
}  
else  
{  
System.out.println("failed11111");  
}  
}  
catch(Exception e)  
{  
System.err.println(e);  
}  
%>

