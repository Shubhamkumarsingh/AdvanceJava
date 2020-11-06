package com;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int a=Integer.parseInt(request.getParameter("a"));
		int b= Integer.parseInt(request.getParameter("b"));
		int c;
		String serv="Served for Shubham ";
		if(request.getParameter("ops").contains("add"))
		{
			c=a+b;
			response.getWriter().append(serv+"And sum is: "+c);
		}else if(request.getParameter("ops").contains("sub")) {
			c=a-b;
			response.getWriter().append(serv+"And substraction is: "+c);
		}else if(request.getParameter("ops").contains("mult")) {
			c=a*b;
			response.getWriter().append(serv+"And multiplication is: "+c);
		}else if(request.getParameter("ops").contains("divide"))
		{
			c=a/b;
			response.getWriter().append(serv+"And divison is: "+c);
		}
	//	response.getWriter().append("Served for shubham ").append("And sum is: "+c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
