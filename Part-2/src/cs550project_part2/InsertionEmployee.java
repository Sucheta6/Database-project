package cs550project_part2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertionEmployee
 */
//@WebServlet("/InsertionEmployee")
public class InsertionEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertionEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String fnamestr=request.getParameter("fname");
		String minitstr=request.getParameter("minit");
		String lnamestr=request.getParameter("lname");
		String ssnstr=request.getParameter("SSN");
		String bdatestr=request.getParameter("bdate");
		String addressstr=request.getParameter("address");
		String genderstr=request.getParameter("gender");
		String salstr=request.getParameter("sal");
		String super_ssnstr=request.getParameter("super_ssn");
		String dnostr=request.getParameter("dno");
		String emailstr=request.getParameter("email");
		ssncheck sn= new ssncheck();
		String res=sn.insert_employee(fnamestr,minitstr,lnamestr,ssnstr,bdatestr,addressstr,genderstr,salstr,super_ssnstr,dnostr,emailstr );
		if(res.equalsIgnoreCase("Yes"))
		{
			response.getWriter().append(res);
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/project.jsp");
			request.setAttribute("ssnid", ssnstr);
            requestDispatcher.forward(request, response);
			
		}
		else {
			response.getWriter().append("Already employee exists");
		}
	}

}
