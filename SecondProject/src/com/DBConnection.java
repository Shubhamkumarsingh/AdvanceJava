package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Servlet implementation class DBConnection
 */
@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dbName="demo";
		String dbUsername="root";
		String dbPassword="singh";
		String dbDriver="com.mysql.jdbc.Driver";
		String dbURL="jdbc:mysql://localhost:3306/";
		Connection con=null;
		PreparedStatement p=null;
		try
		{
			Class.forName(dbDriver);
			con=DriverManager.getConnection(dbURL+dbName, dbUsername, dbPassword);
			p=con.prepareStatement("insert into Employee values(?,?)");
			p.setInt(1, Integer.parseInt(request.getParameter("id")));
			p.setString(2, request.getParameter("name"));
			p.executeUpdate();
			p.close();
			con.close();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><b>Data inserted successfully.</b></body></html>");
		}catch(ClassNotFoundException | SQLException s)
		{
			s.printStackTrace();
		PrintWriter pw=response.getWriter();
		pw.println("<html><body>Error!!!</body></html>");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
