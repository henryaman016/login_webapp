package com.regapp.controller;



import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;




@WebServlet("/update")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	
	request.setAttribute("email", email);
	request.setAttribute("phone", phone);
	
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
	rd.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.updateRegistration(email,phone);
		
		ResultSet result = service.readRegistration();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search_result.jsp");
		rd.forward(request, response);
		
		
	}

}
