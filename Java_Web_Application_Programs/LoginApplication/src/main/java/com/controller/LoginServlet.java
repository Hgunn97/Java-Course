package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Login;
import com.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    LoginService ls = new LoginService();
	// signIn 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// set html response 
		response.setContentType("text/html");
				
		// creating request dispatcher object to include the page 
		RequestDispatcher rd1 = request.getRequestDispatcher("login.html");
		RequestDispatcher rd2 = request.getRequestDispatcher("Home");
		
		// receive the value from form. 
		String emailid  = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		// then create bean class object and set the value. 
		Login ll = new Login();
		ll.setEmailid(emailid);
		ll.setPassword(password);
		
		// using service class object call business method 
		String result = ls.signIn(ll);
		if(result.equalsIgnoreCase("success")) {
			request.setAttribute("name", emailid);  // store emailid with key as name in request scope 
			rd2.forward(request, response);				// we re-direct to target page 
		}else {
			pw.println("Failure try once again");
			rd1.include(request, response);
		}
	}

	// signUp 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		// set html response 
		response.setContentType("text/html");
		
		// creating request dispatcher object to include the page 
		RequestDispatcher rd = request.getRequestDispatcher("signup.html");
		// receive the value from form. 
		String emailid  = request.getParameter("emailid");
		String password = request.getParameter("password");
		
		// then create bean class object and set the value. 
		Login ll = new Login();
		ll.setEmailid(emailid);
		ll.setPassword(password);
		
		// using service class object call business method 
		String result = ls.signUp(ll);
		pw.print(result);			// display result as account created or exists 
		rd.include(request, response);
		
	}


}