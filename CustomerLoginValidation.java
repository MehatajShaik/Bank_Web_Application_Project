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
@WebServlet("/CustomerLoginValidation")
public class CustomerLoginValidation extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accNum = req.getParameter("accNum");
        String pinNum = req.getParameter("pinNum");

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);
            int accNumber = Integer.parseInt(accNum);
            ps.setInt(1, accNumber);
            int pinNumber = Integer.parseInt(pinNum);
            ps.setInt(2, pinNumber);

            rs = ps.executeQuery();

            if (rs.next()) {
            	String cusName = rs.getString(2);
                req.setAttribute("accNum", accNumber);
                req.setAttribute("cusName", cusName);
                RequestDispatcher reqDis = req.getRequestDispatcher("CustomerHome.jsp");
                reqDis.forward(req, resp);
            } else {
                req.setAttribute("error", "Invalid account number or pin! Please try again");
                RequestDispatcher reqDis = req.getRequestDispatcher("CustomerLogin.jsp");
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

