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

@WebServlet("/DepositAmount")
public class DepositAmount extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	int accNum = Integer.parseInt(req.getParameter("accNum"));
        int pinNum = Integer.parseInt(req.getParameter("pinNum"));
        double balance = Double.parseDouble(req.getParameter("balance"));
       
        boolean depositSuccessful = performDeposit(accNum, pinNum, balance);

        if (depositSuccessful) {
        	req.setAttribute("success", "Amount deposited successfully");
            RequestDispatcher reqDis = req.getRequestDispatcher("DepositDetails.jsp");
            reqDis.forward(req, resp);
        } else {
        	req.setAttribute("error", "Amount deposition failed! Please try again");
            RequestDispatcher reqDis = req.getRequestDispatcher("DepositDeails.jsp");
            reqDis.forward(req, resp);
        }
    }

    private boolean performDeposit(int accNum, int pinNum, double balance) {
        Connection con = null;
        PreparedStatement ps = null;
        
        String query = "UPDATE customer SET Balance = balance + ? WHERE AccNo = ? and pin = ?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);
            
            ps.setDouble(1, balance);
            ps.setInt(2, accNum);
            ps.setInt(3, pinNum);
            

            int status = ps.executeUpdate();

            return status > 0;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false; 
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
