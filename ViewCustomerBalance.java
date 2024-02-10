package com.AxisBank.Application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomerBalance")
public class ViewCustomerBalance extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        int accNum = Integer.parseInt(req.getParameter("accNum"));
        int pinNum = Integer.parseInt(req.getParameter("pinNum"));

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double balance = 0.0;
        String cusName; 
        long phone;
        String email;
        
        String query = "SELECT * FROM customer WHERE AccNo = ?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, accNum);

            rs = ps.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("Balance");
                cusName = rs.getString("Name");
                phone = rs.getLong("Phone");
                email = rs.getString("Email");
               
                req.setAttribute("accNum", accNum);
                req.setAttribute("pinNum", pinNum);
                req.setAttribute("balance", balance);
                req.setAttribute("cusName", cusName);
                req.setAttribute("phone", phone);  
                req.setAttribute("email", email);
                RequestDispatcher reqDis = req.getRequestDispatcher("ViewBalance.jsp");
                reqDis.forward(req, resp);
            } else {
                
                RequestDispatcher reqDis = req.getRequestDispatcher("ViewBalanceFailure.jsp");
                reqDis.forward(req, resp);
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
          
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
