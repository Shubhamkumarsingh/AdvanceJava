package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Emp;

public class EmpDAO {
	private static Connection con;
	public static void connect() throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/";
		String dbName="demo";
		String dbUser="root";
		String dbPassword="singh";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url+dbName, dbUser, dbPassword);
	}
	public static List<Emp> getData(int pageId,int total)
	{
		List<Emp> list=new ArrayList<Emp>();
		try
		{
			connect();
		PreparedStatement ps=con.prepareStatement("select * from Employee limit "+(pageId-1)+","+total);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Emp e=new Emp();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
			list.add(e);
		}
		}catch(ClassNotFoundException | SQLException s)
		{
			s.printStackTrace();
		}
		return list;
	}

}
