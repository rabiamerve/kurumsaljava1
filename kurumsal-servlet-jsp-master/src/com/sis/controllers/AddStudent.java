package com.sis.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sis.models.Gender;
import com.sis.models.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setAttribute("Errors", false);
		request.setAttribute("firstname-error", false);
		request.setAttribute("lastname-error", false);
		request.setAttribute("gender-error", false);
		
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/addStudents.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Student student=new Student();
		
		request.setAttribute("Errors", false);
		request.setAttribute("firstname-error", false);
		request.setAttribute("lastname-error", false);
		request.setAttribute("gender-error", false);
		
		String firstname=request.getParameter("first-name");
		System.out.println("First Name:"+firstname);

		if (firstname.length()==0){
			System.out.println("Empty first name error");
			request.setAttribute("Errors", true);
			request.setAttribute("firstname-error", true);
		}	
		
		String lastname=request.getParameter("last-name");
		System.out.println("Last Name:"+lastname);
		
		if (lastname.length()==0){
			System.out.println("Empty last name error");
			request.setAttribute("Errors", true);
			request.setAttribute("lastname-error", true);
		}	
		
		String gender=request.getParameter("gender");
		System.out.println("Gender:"+gender);
		
		if (gender.length()==0){
			System.out.println("Empty gender error");
			request.setAttribute("Errors", true);
			request.setAttribute("gender-error", true);
		}	
		
		if ((Boolean) request.getAttribute("Errors")){
			RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/addStudents.jsp");
			view.forward(request,response);
		}
		
		student.setFirstname(firstname);
		student.setLastname(lastname);
		System.out.println(gender);
		//System.out.println("Evet MALE");
		if (gender.equals("Male")){
			student.setGender(Gender.Male);
			System.out.println("Evet MALE");
		}else{
			student.setGender(Gender.Female);
			System.out.println("Hayýr  FEMALE");
		}
		
		
		System.out.println(student.toString());
	}

}
