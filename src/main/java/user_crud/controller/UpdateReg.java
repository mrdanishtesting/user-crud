package user_crud.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_crud.model.DaoServices;
import user_crud.model.DaoServicesImpl;

public class UpdateReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateReg() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);
		

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dobString = request.getParameter("dateOfBirth");

		Date dateOfBirth = null;
		try {
			dateOfBirth = service.dateStringToDate(dobString);
		} catch (ParseException e) {
			request.setAttribute("status","failure");
			request.setAttribute("msg", "invalid date format it should be yyyy-mm-dd format");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
		}
	
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("dateOfBirth", dateOfBirth);
		RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
		rd.forward(request, response);

	}

}
