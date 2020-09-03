package cs550project_part2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class projectassign
 */
//@WebServlet("/projectassign")
public class projectassign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectassign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String myCheck1=request.getParameter("myCheck1");
		String myCheck2=request.getParameter("myCheck2");
		String myCheck3=request.getParameter("myCheck3");
		String myCheck4=request.getParameter("myCheck4");
		String myCheck5=request.getParameter("myCheck5");
		String myCheck6=request.getParameter("myCheck6");
		String text1=request.getParameter("text1");
		String text2=request.getParameter("text2");
		String text3=request.getParameter("text3");
		String text4=request.getParameter("text4");
		String text5=request.getParameter("text5");
		String text6=request.getParameter("text6");
		String emssn=request.getParameter("ssnid");
		
		//String ems=request.getAttribute("ssnid").toString();
		List<String> al=new ArrayList<String>(); 
		List<String> tl=new ArrayList<String>(); 
		if(myCheck1 != null && !myCheck1.isEmpty()) {		if(myCheck1.equalsIgnoreCase("on")) {
			al.add( "ProductX");
			tl.add( text1);
		}}
		if(myCheck2 != null && !myCheck2.isEmpty()) {
		if(myCheck2.equalsIgnoreCase("on")) {
			al.add( "ProductY");
			tl.add( text2);
		}}
		if(myCheck3 != null && !myCheck3.isEmpty()) {
		if(myCheck3.equalsIgnoreCase("on")) {
			al.add( "ProductZ");
			tl.add( text3);
		}}
		if(myCheck4 != null && !myCheck4.isEmpty()) {
		if(myCheck4.equalsIgnoreCase("on")) {
			al.add( "Computerization");
			tl.add( text4);
		}}
		if(myCheck5 != null && !myCheck5.isEmpty()) {
		if(myCheck5.equalsIgnoreCase("on")) {
			al.add( "Reorganization");
			tl.add( text5);
		}}
		if(myCheck6 != null && !myCheck6.isEmpty()) {
		if(myCheck6.equalsIgnoreCase("on")) {
			al.add( "Newbenefits");
			tl.add( text6);
		}}
		ssncheck sn= new ssncheck();
		String res=sn.Projname(al,tl,emssn);
		if(res.equalsIgnoreCase("True"))
		{ if(request.getParameter("dependents").equalsIgnoreCase("Yes")) {
			response.getWriter().append(res);
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/dependents.jsp");
			request.setAttribute("ssnid", emssn);
			
			
            requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/empreport.jsp");
			request.setAttribute("ssnid", emssn);
			List<String> ar=sn.report_employee(emssn);
			request.setAttribute("fnames", ar.get(1).toString());
			request.setAttribute("lnames",  ar.get(2).toString());
			request.setAttribute("ssns",  ar.get(3).toString());
			request.setAttribute("bdays",  ar.get(4).toString());
			request.setAttribute("address",  ar.get(5).toString());
			request.setAttribute("sex",  ar.get(6).toString());
			request.setAttribute("salaries",  ar.get(7).toString());
			request.setAttribute("superssns",  ar.get(8).toString());
			request.setAttribute("emails",  ar.get(9).toString());
			
            requestDispatcher.forward(request, response);
			
		}
		}
		else if(res.equalsIgnoreCase("False")) {
			
			response.getWriter().append("Not able to add a project.Please check the details of project.");
		}
		else {
			response.getWriter().append(res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
