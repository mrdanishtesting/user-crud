package user_crud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_crud.model.DaoServices;
import user_crud.model.DaoServicesImpl;
import user_crud.payload.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);
		request.setAttribute("status", "success");
		request.setAttribute("msg", "hello welcome");
	
		RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		
		
		boolean verified;
		try {
			System.out.println("emai  " + email);
			System.out.println("pass  " + password);
			DaoServices service = new DaoServicesImpl();

			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			System.out.println("emai in  " + user.getEmail());
			System.out.println("pass in do " + user.getPassword());
			verified = service.verifyCredentials(user);
			if (verified) {
				System.out.println("Email: " + user.getEmail() + " pass : " + user.getPassword());
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				request.setAttribute("msg", "successfully login");
				request.setAttribute("status", "success");
				request.setAttribute("title","registrationPage");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("msg", "INVALID USERNAME & PASSWORD KINDLY INPUT CORRECT USERNAME& PASSWORD");
				request.setAttribute("status", "failure");
				RequestDispatcher rd = request.getRequestDispatcher("/exception.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "internal error occured");
			RequestDispatcher rd = request.getRequestDispatcher("/exception.jsp");
			rd.forward(request, response);
		}

	}

}
