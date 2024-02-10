
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

@WebServlet("/DeleteCustomerAccount")
public class DeleteCustomerAccount extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int accNum = Integer.parseInt(req.getParameter("accNum"));
        
       
        Connection con = null;
        PreparedStatement ps = null;

        String query = "DELETE FROM CUSTOMER WHERE AccNo=?";

        try {
            con = Connector.requestConnection();
            ps = con.prepareStatement(query);

            ps.setInt(1, accNum);

            int status = ps.executeUpdate();
            if (status > 0) {
            	req.setAttribute("success","Account deleted successfully!");
                RequestDispatcher reqDis = req.getRequestDispatcher("DeleteAccount.jsp");
                reqDis.forward(req, resp);
            } else {
            	req.setAttribute("error","Account deletion failed! Please try again");
                RequestDispatcher reqDis = req.getRequestDispatcher("DeleteAccount.jsp");
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
