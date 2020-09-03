package cs550project_part2;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Employee_Data
 */
//@WebServlet("/Employee_Data")
public class Employee_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Employee_Data() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ssnstr=request.getParameter("SSN");
		//int ssn=Integer.parseInt(request.getParameter("SSN"));
		System.out.println(ssnstr);
		ssncheck sn= new ssncheck();
		String res=sn.manager_check(ssnstr);
		if(res.equalsIgnoreCase("Yes"))
		{
			response.getWriter().append(res);
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/addnewemployee.jsp");
            requestDispatcher.forward(request, response);
			
		}
		else {
			response.getWriter().append("Not a manager");
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
