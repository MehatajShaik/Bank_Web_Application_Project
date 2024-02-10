
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/CustomerTransaction")
public class CustomerTransaction extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accNum = req.getParameter("accNum");
        String pinNum = req.getParameter("pinNum");
        String transAccNum = req.getParameter("transAccNum");
        double amount = Double.parseDouble(req.getParameter("amount"));

        Connection con = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {
            con = Connector.requestConnection();

            // Check if the source account has sufficient balance
            String checkBalanceQuery = "SELECT Balance FROM CUSTOMER WHERE AccNo = ? AND PIN=?";
            ps1 = con.prepareStatement(checkBalanceQuery);
            ps1.setString(1, accNum);
            ps1.setString(2, pinNum);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
            	double balance = rs.getDouble("Balance");
                if (balance >= amount) {
                    // Update source account balance
                    String updateSourceBalanceQuery = "UPDATE CUSTOMER SET Balance = Balance - ? WHERE AccNo = ? AND PIN=?";
                    ps1 = con.prepareStatement(updateSourceBalanceQuery);
                    ps1.setDouble(1, amount);
                    ps1.setString(2, accNum);
                    ps1.setString(3, pinNum);
                    ps1.executeUpdate();

                    // Update target account balance
                    String updateTargetBalanceQuery = "UPDATE CUSTOMER SET Balance = Balance + ? WHERE AccNo = ?";
                    ps2 = con.prepareStatement(updateTargetBalanceQuery);
                    ps2.setDouble(1, amount);
                    ps2.setString(2, transAccNum);
                    ps2.executeUpdate();
                    req.setAttribute("success","Transaction successful!");
                    RequestDispatcher reqDis = req.getRequestDispatcher("Transaction.jsp");
                    reqDis.forward(req, resp);
                    
                } else {
                    req.setAttribute("error", "Insufficient balance for the transaction!");
	                RequestDispatcher reqDis = req.getRequestDispatcher("Transaction.jsp");
	                reqDis.forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Invalid source account number!");
                RequestDispatcher reqDis = req.getRequestDispatcher("Transaction.jsp");
                reqDis.forward(req, resp);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps2 != null) ps2.close();
                if (ps1 != null) ps1.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
