<%-- 
    Document   : loginjsp3
    Created on : 24 Feb, 2022, 11:41:00 AM
    Author     : ujjawal kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%
        String s = request.getParameter("msg");
        if (s != null) 
        {
            out.println(s);
        }
        %>
        
        <form action="Searchlogger3" method="get">
            <table>
                <tr>
                    <td>Member Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="pass" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
