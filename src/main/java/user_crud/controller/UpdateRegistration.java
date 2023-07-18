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
import user_crud.payload.User;

public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateRegistration() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);
		request.setAttribute("status", "failure");
		request.setAttribute("msg", "session time out");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dobString = request.getParameter("dateOfBirth");
		Date dateOfBirth = null;
		try {
			dateOfBirth = service.dateStringToDate(dobString);
		} catch (ParseException e1) {
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "invalid date formate it should be yyyy-mm-dd format");
			request.getRequestDispatcher("/exception.jsp");
		}

		User user = new User(email, password, dateOfBirth);

		try {
			boolean updated = service.updateReg(user);
			if (updated)
				request.setAttribute("status", "success");
			request.setAttribute("msg", "record is updated");
			RequestDispatcher rd1 = request.getRequestDispatcher("/registration.jsp");
			rd1.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "due to some technical issue");
			RequestDispatcher rd2 = request.getRequestDispatcher("/registration.jsp");
			rd2.forward(request, response);
		}

	}
}
