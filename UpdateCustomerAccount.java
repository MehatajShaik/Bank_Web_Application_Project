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

@WebServlet("/UpdateCustomerAccount")
public class UpdateCustomerAccount extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int accNum= Integer.parseInt(req.getParameter("accNum"));
        String cusName = req.getParameter("cusName");
        long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
        String email = req.getParameter("email");
       
        Connection con = null;
        PreparedStatement ps = null;

        String query = "UPDATE CUSTOMER SET Name=?, Phone=?, Email=? WHERE AccNo=?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, cusName);
            ps.setLong(2, phoneNo);
            ps.setString(3, email);
            ps.setInt(4, accNum);

            int status = ps.executeUpdate();
            if (status > 0) {
            	req.setAttribute("success","Account updated successfully!");
                RequestDispatcher reqDis = req.getRequestDispatcher("UpdateAccount.jsp");
                reqDis.forward(req, resp);
                
            } else {
            	req.setAttribute("error","Account updation failed! Please try again");
				RequestDispatcher reqDis = req.getRequestDispatcher("UpdateAccount.jsp");
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
