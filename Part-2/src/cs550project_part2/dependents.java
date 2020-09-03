package cs550project_part2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dependents
 */
//@WebServlet("/dependents")
public class dependents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dependents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String essn=request.getParameter("essn");
		String dependent_name=request.getParameter("dependent_name");
		String gender=request.getParameter("gender");
		String bdate=request.getParameter("bdate");
		String relationship=request.getParameter("relationship");
		ssncheck sn= new ssncheck();
		String res=sn.inser_depend(essn, dependent_name, gender, bdate, relationship);
		if(res.equalsIgnoreCase("Yes"))
		{
			response.getWriter().append(res);
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/report.jsp");
			List<String> ar=sn.report_employee(essn);
			request.setAttribute("fnames", ar.get(0).toString());
			request.setAttribute("lnames",  ar.get(1).toString());
			request.setAttribute("ssns",  ar.get(2).toString());
			request.setAttribute("bdays",  ar.get(3).toString());
			request.setAttribute("address",  ar.get(4).toString());
			request.setAttribute("sex",  ar.get(5).toString());
			request.setAttribute("salaries",  ar.get(6).toString());
			request.setAttribute("superssns",  ar.get(7).toString());
			request.setAttribute("emails",  ar.get(8).toString());
			requestDispatcher.forward(request, response);
			
			
			
		}
		else {
			response.getWriter().append("Already dependent exists");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
