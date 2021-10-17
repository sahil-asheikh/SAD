<%@page import="java.util.List"%>
<%@page import="com.qt.sad.service.User_service"%>
<%@page import="com.qt.sad.model.Tbluser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String user_id = request.getParameter("user_id");
    User_service user_service = new User_service();
    Tbluser user = user_service.select_user(user_id);
%>

<div class="row text-dark">

    <div class="col-4">
        <strong>
            <p>Name</p>
            <p>Mobile</p>
            <p>Email</p>
            <p>Education</p>
            <p>College</p>
            <p>City</p>
            <p>Date of Subscription</p>
        </strong>
    </div>
    <div class="col-8">
        <p><%= user.getName()%></p>
        <p><%= user.getMobile()%></p>
        <p><%= user.getEmail()%></p>
        <p><%= user.getEducation()%></p>
        <p><%= user.getCollege()%></p>
        <p><%= user.getCity()%></p>
        <p title="<%= user.getCreated_at()%>"><%= user.getCreated_at().substring(0, 10)%></p>
    </div>
</div>
