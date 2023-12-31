package com.regapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp.model.DAOService;
import com.regapp.model.DAOServiceImpl;

@WebServlet("/newReg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
HttpSession session = request.getSession(false);
		
//session.setMaxInactiveInterval(100);
if(session.getAttribute("email")!=null) {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		
		
		
		DAOService service=new DAOServiceImpl();
		service.connectDB();
		service.verifyCredential(name, email,phone,city);
		
		request.setAttribute("msg" , "record saved!");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/create_registration.jsp");
		rd.forward(request, response);

}else {
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}


}catch(Exception e) {
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
	}
}
