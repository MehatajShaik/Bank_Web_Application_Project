
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

@WebServlet("/CusForgotPinValidation")
public class CusForgotPinValidation extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accNum = req.getParameter("accNum");
        
        Connection con = null;
        PreparedStatement ps = null;

        String query = "UPDATE CUSTOMER SET PIN=? WHERE AccNo=?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, req.getParameter("confirmPin"));
            
            ps.setString(2, accNum);
            
  
            if (req.getParameter("newPin").equals(req.getParameter("confirmPin"))) {
            	ps.executeUpdate();
            	req.setAttribute("success","PIN updated successfully!");
                RequestDispatcher reqDis = req.getRequestDispatcher("CustomerLogin.jsp");
                reqDis.forward(req, resp);
                
            } else {
            	req.setAttribute("error","New pin and confirm pin do not match! Please try again");
				RequestDispatcher reqDis = req.getRequestDispatcher("CustomerForgotPin.jsp");
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
