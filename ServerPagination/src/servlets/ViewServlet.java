package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Emp;
import dao.EmpDAO;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		int pageId=Integer.parseInt(request.getParameter("page"));
		int total=5;
		int spageId=pageId;
		if(pageId==1) {}
		else {
			pageId=pageId-1;
			pageId=pageId*total+1;
		}
		List<Emp> list=EmpDAO.getData(pageId,total);
		out.print("<h1>Page No. "+spageId+"</h1>");
		out.print("<table border='1 solid black' border-collapse='collaspe' cellpading='4' width='60%'>");
		out.print("<tr><th>ID</th><th>Name</th><th>Salary</th></tr>");
		for (Emp emp : list) {
			out.print("<tr><td>"+emp.getId()+"</td><td>"+emp.getName()+"</td><td>"+emp.getSalary()+"</td></tr>");
		}
		out.print("</table>");
		out.print("<div style='font-weight:900;' color= 'black'><a href='ViewServlet?page=1'>1</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewServlet?page=2'>2</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewServlet?page=3'>3</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewServlet?page=4'>4</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewServlet?page=5'>5</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.print("<a href='ViewServlet?page=6'>6</a></div>");
		out.close();
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
