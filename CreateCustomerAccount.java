
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
@WebServlet("/CreateCustomerAccount")
public class CreateCustomerAccount extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//int accNum = Integer.parseInt(req.getParameter("AccNo"));
		String customerName = req.getParameter("cusName");
        long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
        String email = req.getParameter("email");
        double balance = Double.parseDouble(req.getParameter("balance"));
        //int pinNumber = Integer.parseInt(req.getParameter("pin"));

		
		Connection con=null;
		PreparedStatement ps=null;
		
		String query = "INSERT INTO CUSTOMER (Name, Phone, Email, Balance) VALUES (?, ?, ?, ?)";

		
		try {
			con = Connector.requestConnection();
			ps = con.prepareStatement(query);
			
			
			ps.setString(1, customerName);
            ps.setLong(2, phoneNo);
            ps.setString(3, email);
            ps.setDouble(4, balance);
           
			
			
			int status = ps.executeUpdate();
			 if (status > 0) {
				 req.setAttribute("success","Account created successfully!");
	                RequestDispatcher reqDis = req.getRequestDispatcher("CreateAccount.jsp");
	                reqDis.forward(req, resp);
	            } else {
	            	req.setAttribute("error","Account creation failed!");
	                RequestDispatcher reqDis = req.getRequestDispatcher("CreateAccount.jsp");
	                reqDis.forward(req, resp);
	            }
		} catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}

		finally
		{
			try
			{
				if(ps!=null)ps.close();
				if(con!=null)con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}	
}

