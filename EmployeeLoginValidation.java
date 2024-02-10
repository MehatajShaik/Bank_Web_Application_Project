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
@WebServlet("/EmployeeLoginValidation")
public class EmployeeLoginValidation extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		
		int empID = Integer.parseInt(req.getParameter("empID"));
		String empPass = req.getParameter("empPass");
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query = "SELECT * FROM EMPLOYEE WHERE EID=? AND PASSWORD=?";
		
		try {
			con = Connector.requestConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1,empID);
			ps.setString(2, empPass);
			rs = ps.executeQuery();
			if(rs.next())
			{
				String empName = rs.getString(2);
				req.setAttribute("empID",empID);
				req.setAttribute("empName",empName);
				RequestDispatcher reqDis = req.getRequestDispatcher("EmployeeHome.jsp");
				reqDis.forward(req, resp);
			}
			else
			{
				req.setAttribute("error","Invalid employee ID or password! Please try again");
				RequestDispatcher reqDis = req.getRequestDispatcher("EmployeeLogin.jsp");
				reqDis.forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException ne) {
			// TODO Auto-generated catch block
			req.setAttribute("error", "Please enter valid employee ID or password");
			RequestDispatcher reqDis = req.getRequestDispatcher("EmployeeLogin.jsp");
			reqDis.forward(req, resp);
			ne.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
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
