package com.AxisBank.Application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmpForgotPassValidation")
public class EmpForgotPassValidation extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int empID = Integer.parseInt(req.getParameter("empID"));
        
        Connection con = null;
        PreparedStatement ps = null;

        String query = "UPDATE EMPLOYEE SET PASSWORD=? WHERE EID=?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, req.getParameter("confirmPass"));
            
            ps.setInt(2, empID);
            
 
            if (req.getParameter("newPass").equals(req.getParameter("confirmPass"))) {
            	ps.executeUpdate();
            	System.out.println("hii");
            	req.setAttribute("success","Password updated successfully!");
                RequestDispatcher reqDis = req.getRequestDispatcher("EmployeeLogin.jsp");
                reqDis.forward(req, resp);
                
            } else {
            	req.setAttribute("error","New password and confirm password do not match! Please try again");
				RequestDispatcher reqDis = req.getRequestDispatcher("EmployeeForgotPassword.jsp");
				reqDis.forward(req, resp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
