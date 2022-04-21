/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import bean.*;


/**
 *
 * @author Ujjawal Kumar
 */
public class Searchlogger4 extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@laptop-ujjawal:1521:XE","M1", "M1");
            RequestDispatcher rd = null;
            PreparedStatement pst = con.prepareStatement("select * from Emp2 where name =? and pass= ?"); 
            
            pst.setString(1,request.getParameter("name"));
            pst.setString(2,request.getParameter("pass"));
            ResultSet rs = pst.executeQuery();
            
            if(rs.next())
            {
                rd = request.getRequestDispatcher("Welcome.html");
            }
            else
            {
                Logbean lb = new Logbean();
                // lb.setMemno(Integer.parseInt(request.getParameter("memno")));
                lb.setId(request.getParameter("name"));
                lb.setPass(request.getParameter("pass"));
                request.setAttribute("data",lb);

                rd = request.getRequestDispatcher("loginjsp4.jsp?msg=Invalid User Name or Password");
            }con.close();
            rd.forward(request, response);
                
        }
        catch(Exception e)
        {
            out.println(e.toString());
        }
    }   
  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}