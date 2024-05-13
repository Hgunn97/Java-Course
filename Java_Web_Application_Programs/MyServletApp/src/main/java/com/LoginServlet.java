package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		//pw.println("Your emailid is "+emailid);
		RequestDispatcher rd1 = request.getRequestDispatcher("Home");
		RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
		response.setContentType("text/html");   // output consider as html rather than plain text 
		if(emailid.equals("abc@gmail.com") && password.equals("123")) {
			pw.print("successfully login  with get method");
			rd1.forward(request, response);			// we can see the output for target page 
		}else {
			pw.println("failure try once again with get method");
			rd2.include(request, response);      // both failure message + login.html page included 
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		//pw.println("Your emailid is "+emailid);
		RequestDispatcher rd1 = request.getRequestDispatcher("Home");
		RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
		response.setContentType("text/html");   // output consider as html rather than plain text 
		if(emailid.equals("abc@gmail.com") && password.equals("123")) {
			pw.print("successfully login with post method");
			rd1.forward(request, response);
		}else {
			pw.println("failure try once again with post method");
			rd2.include(request, response);
		}

	}

}
