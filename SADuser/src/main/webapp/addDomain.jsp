

<div class="container">

    <h4 class="text-success"><i class="fas fa-copy"></i>&nbsp;Add Subdomain </h4>
    <br>
    <p>
        Subdomains are Internet addresses for different sections of your website. They use your main domain name and a prefix.
        For example, if your domain is qaswatech.com, a subdomain might be student.qaswatech.com.
        Visitors will be see your website regardless of the subdomain name they enter in a browser. </p>
    <br>
    <form  method="post" action="SubDomainController" name="frm" >
        <div class="form-row">
            <label for="">Subdomain name</label> &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="col-md-6">

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend2">www.</span>
                    </div>
                    <input type="hidden" name="action" value="insert">
                    <input type="hidden" name="txtStudid" value="<%= session.getAttribute("sid")%>">
                    <input type="text" class="form-control" name="txtSubdomain" required>
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend2">.qaswatechnologies.com</span> 
                    </div>
                </div>
            </div>
        </div> 

        <br><br>

        <div class="form-row">

            <label for="">Subdomain will be</label> &nbsp;&nbsp;&nbsp;&nbsp;
            <div class="col-md-6">

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupPrepend2">www.test.qaswatechnologies.com</span>
                        <button type="submit" class="btn btn-outline-success" onclick="return val();">create</button>
                    </div>
                </div>
            </div>

        </div> 

    </form>
    <h3><%= session.getAttribute("sid")%></h3>
</div>
