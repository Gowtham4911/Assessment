package com.traing.save;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.training.Employee3;
import com.line.Dbclass;

/**
 * Servlet implementation class RegisterEmployee
 */
@WebServlet("/RegisterEmployee")
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object Status;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployee(){
        super();
        // TODO Auto-generated constructor stub

	
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("txt/html");
		PrintWriter pw=response.getWriter();
		
	
	     Integer iD=Integer.parseInt(request.getParameter("id"));
		String Name =request.getParameter("name");
		String Age=request.getParameter("age");
		String Designation=request.getParameter("des");
		String phonenumber=request.getParameter("no");
		String salary=request.getParameter("salary");
		int status=0;
		 Employee3 e3=new Employee3();
		 
		 e3.setEmp_id(iD);
		 e3.setName(Name);
		 e3.setAge(Age);
		 e3.setDisignation(Designation);
		 e3.setPhonenumbe(phonenumber);
		  e3.setSalary(salary);	
		  
		 status =Dbclass.insert(e3);
		 if(status>0)
		 {
			 pw.print("data inserted :");
			 response.sendRedirect("index.html");
		 }
		 else
		 {
			 pw.print("error in inserted");
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
