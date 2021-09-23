
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
            <label for="">upload project for this Sub Domain</label>
            <%   while (rs.next()) {%>
            <span class="input-group-text" id="inputGroupPrepend2">www.<%= rs.getString("subdomain")%>.qaswatechnologies.com</span>
            <% }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            %>
        </div>
    </div>

    <h4 class=" text-success"><i class="fas fa-globe"></i> &nbsp; Host new java application </h4>
    <br>
    <p>upload .WAR file</p>
    <p class="text-success">Or </p>
    <p> upload .ZIP file</p>
    <br>
    <form  method="post" action="ProjectController" name="frm" enctype="multipart/form-data">
        <div class="form-group">

            <input type="hidden" name="txtStudid" value="<%= session.getAttribute("sid")%>">
            <input type="hidden" name="txtSubdomainid" value="22">

            <input type="file" class="form-control-file"  name="file" size="50">
        </div>
        <button type="submit" class="btn btn-outline-success" onclick="return val();">Upload</button>                   
    </form>

    <hr class="bg-success">

    <h3><%= session.getAttribute("sid")%></h3>
</div>
