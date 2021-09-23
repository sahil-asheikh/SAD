
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.qt.sad.commons.DatabaseConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<div class="container">
    <%
        Connection con = DatabaseConnect.connectDb();
        Statement stmt = null;
        //   int id, did;
        //  int dealerid = (Integer) session.getAttribute("userid"); 
        try {
            //sql query
            String sql = "SELECT * FROM tblsubdomain";
            //execute a query

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); %>
    <div class="form-row">
        <div class="form-group col-md-5">
            <label for="">Import Database for this Sub Domain</label>
            <%   while (rs.next()) {%>
            <span class="input-group-text" id="inputGroupPrepend2">www.<%= rs.getString("subdomain")%>.qaswatechnologies.com</span>
            <% }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            %>
        </div>
    </div>
    <h4 class=" text-success"> <i class="fas fa-database"></i>&nbsp;Import Database</h4>
    <br>
    <p>
        File may be compressed (gzip, zip) or uncompressed.
        A compressed file's name must end in .[format].[compression]. Example:&nbsp; <span class="text-success"> ( .sql &nbsp;or &nbsp; .zip )</span></p>
    <br>
    <form method="post" action="DbController" name="frm" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-5">
                <input type="hidden" name="txtStudid" value="11">
                <input type="hidden" name="txtSubdomainid" value="22">
                <input type="hidden" name="txtProjectid" value="33">
                <label for="">Database Name</label>
                <input type="text" name="txtDbName" class="form-control-file">
            </div>
            <div class="form-group col-md-2"></div>
            <div class="form-group col-md-5">
                <label for="">Database File</label>
                <input type="file"  name="file" class="form-control-file" id="exampleFormControlFile1"> <br>
                <button type="submit" class="btn btn-outline-success" onclick="return val();">Import</button>   
            </div>
        </div>
    </form>
</div>
