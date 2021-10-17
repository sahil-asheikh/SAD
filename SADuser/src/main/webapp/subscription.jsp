
<table id="example" class="table table-striped table-sm table-hover table-bordered text-center" style="width:100%">
    <%
    %>

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
        <tr>
            <td><%= "NAME"%></td>
            <td><%= "subdomain"%></td>
            <td><a title="download" class="btn btn-success btn-sm" href="uploads\oep-qaswa.docx" download><i class="fas fa-globe"></i></a></td>
            <td> <%= "dbname"%> = <a title="download" class="btn btn-success btn-sm" href="<%= "db"%>" download><i class="fas fa-database"></i></a></td>
            <td>
                <a href="" title="More" class="btn btn-info btn-sm" data-toggle="modal" data-target="#exampleModalCenter"><i class="fas fa-eye"></i></a>
                <a href="#" title=" Delete" class="btn btn-warning btn-sm"><i class="fas fa-trash-alt"></i></a>
                <a href="dealerUpdate.jsp?id=<%= "user_id"%>" title="Edit" class="btn btn-success btn-sm"><i class="fas fa-edit"></i></a>
            </td>
        </tr>
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

<!-- Datatable script -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });

</script>
