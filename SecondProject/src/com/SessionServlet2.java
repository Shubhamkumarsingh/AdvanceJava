package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
//@WebServlet("/SessionServlet2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		String name=(String)hs.getAttribute("userName");
		pw.print("<html><body><h1> Hello "+name+"</h1></body></html>");
		pw.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
