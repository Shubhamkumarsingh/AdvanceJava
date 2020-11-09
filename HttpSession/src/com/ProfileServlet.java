package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	response.setContentType("text/html");
    	HttpSession session=request.getSession(false);
    	PrintWriter out=response.getWriter();
    	request.getRequestDispatcher("link.html").include(request, response);
    	if(session!=null)
    	{
    		String name= (String)session.getAttribute("userName");
    		out.print("Welcome "+name+" ,to your profile page.<br/><br/>");
    		out.close();
    	}else {
    		out.print("Please login first!<br/><br/>");
    		request.getRequestDispatcher("Login.html").include(request, response);
    		out.close();
    	}
    	
    	
    }

}
