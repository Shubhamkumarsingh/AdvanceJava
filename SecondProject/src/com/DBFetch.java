package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBFetch
 */
@WebServlet("/DBFetch")
public class DBFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/";
		String dbName="demo";
		final String dbUserName="root";
		final String dbPassword="singh";
		final String driver="com.mysql.jdbc.Driver";
		Connection con=null;
		String output="";
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url+dbName,dbUserName,dbPassword);
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				output="id: "+rs.getInt("id")+"   name: "+rs.getString("name")+"<br/>"+output;
			}
			ps.close();
			con.close();
			PrintWriter pw=response.getWriter();
			pw.println("<html><body>"+output+"</body></html>");
		}catch(ClassNotFoundException | SQLException s)
		{
			s.printStackTrace();
			response.getWriter().append("<html><body>Error Occured!</body></html>");
		}
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
