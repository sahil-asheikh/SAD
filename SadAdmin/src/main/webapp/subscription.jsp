
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.qt.sad.commons.DatabaseConnect"%>
<%@page import="java.sql.Connection"%>


<!-- table --><h1>yahi se hai</h1>

<table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
<%
    Connection con = DatabaseConnect.connectDb();
    Statement stmt = null;
    //   int id, did;
    //  int dealerid = (Integer) session.getAttribute("userid"); 

    try {
        //sql query
        String sql = "SELECT tbluser.name, tblsubdomain.subdomain, tblproject.project, tbldb.dbname, tbldb.db FROM tbluser, tblsubdomain, tblproject, tbldb where tbluser.id=1 AND tbldb.studid=1 AND tblproject.studid=1 AND tblsubdomain.studid=1;";
        //execute a query

        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql); %>

    <thead>
        <tr>

            <th scope="col">SUBSCRIBER</th>
            <th scope="col">SUBDOMAIN</th>
            <th scope="col">PROJECT</th>
          
            <th scope="col">DB-FILE</th>
           <th scope="col">ACTION</th>

        </tr>
    </thead>
    <tbody>

        <%   while (rs.next()) {
                                    // id = rs.getInt("id");
%>
        <tr>

            <td><%= rs.getString("name")%></td>
            <td><%= rs.getString("subdomain")%></td>
            <td><a title="download" class="btn btn-success btn-sm" href="uploads\oep-qaswa.docx" download><i class="fas fa-globe"></i></a></td>
          
            <td> <%= rs.getString("dbname")%> = <a title="download" class="btn btn-success btn-sm" href="<%= rs.getString("db")%>" download><i class="fas fa-database"></i></a></td>
            <td><a href="" title="More" class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModalCenter"><i class="fas fa-eye"></i></a>
                <a href="#" title=" Delete" class="btn btn-warning btn-sm"><i class="fas fa-trash-alt"></i></a>
                <a href="dealerUpdate.jsp?id=<%=rs.getInt("id")%>" title="Edit" class="btn btn-success btn-sm"><i class="fas fa-edit"></i></a>
            </td>
        </tr>
        <%} %>
    </tbody>
    <tfoot>
        <tr>

            <th scope="col">SUBSCRIBER</th>
            <th scope="col">SUBDOMAIN</th>
            <th scope="col">PROJECT</th>
        
            <th scope="col">DB-FILE</th>
           <th scope="col">ACTION</th>

        </tr>
    </tfoot>
</table>
<%  } catch (Exception e) {
        System.out.println(e.getMessage());
    }
%>
  

 <!-- Datatable script -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    <script>
                                $(document).ready(function () {
                                    $('#example').DataTable();
                                });

    </script>
