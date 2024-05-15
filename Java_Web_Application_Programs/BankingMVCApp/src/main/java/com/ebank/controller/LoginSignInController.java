package com.ebank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebank.bean.Login;

/**
 * Servlet implementation class LoginSignInController
 */
@WebServlet("/LoginSignInController")
public class LoginSignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSignInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		String typeofuser = request.getParameter("typeofuser");
		
		Login ll = new Login();
		ll.setEmailid(emailid);
		ll.setPassword(password);
		ll.setTypeofuser(typeofuser);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		String result = "";
		if(result.equalsIgnoreCase("successfully login by customer")) {
			response.sendRedirect("customerhome.jsp");		// output wise equal to forward 
		}else if(result.equalsIgnoreCase("successfully login by manager")) {
			response.sendRedirect("managerhome.jsp");
		}else {
			pw.println("Invalid emailid or password");
			rd.include(request, response);
		}
		
	}

}