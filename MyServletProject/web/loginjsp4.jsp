<%-- 
    Document   : loginjsp4
    Created on : 16 Mar, 2022, 9:59:33 AM
    Author     : ujjawal kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP MVC based Login Page</title>
    </head>
    
    <body>
        <%@ page import = "bean.*" %>
        <%
        String p = "";
        String m = "";
        String s = request.getParameter("msg");
        if (s != null) 
        {
            out.println(s);
            Logbean lb = (Logbean)request.getAttribute("data");
            m = lb.getId();
            p = lb.getPass();
        }
        %>
        
        
        <form action="Searchlogger4" method="get">
            <table>
                <tr>
                    <td>Member Name</td>
                    <td><input type="text" name="name" value="<%= m %>" /></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="pass" value="<%= p %>" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
