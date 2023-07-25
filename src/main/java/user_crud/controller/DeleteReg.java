package user_crud.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_crud.model.DaoServices;
import user_crud.model.DaoServicesImpl;
import user_crud.payload.User;

public class DeleteReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	public DeleteReg() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);

		String email = request.getParameter("email");
		try {
		User userByEmail = service.getUserByEmail(email);
		request.setAttribute("userByEmail",userByEmail);
		RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
		rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status","failure");
			request.setAttribute("msg", "error in getting delete.jsp page");
			RequestDispatcher rd1 = request.getRequestDispatcher("/exception.jsp");
			rd1.forward(request, response);
		
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String idString = request.getParameter("id");
		String password = request.getParameter("password");
		String dateOfbirthString = request.getParameter("dateOfBirth");
		String country = request.getParameter("country");
		DaoServices service = new DaoServicesImpl();
		
       
		int id = Integer.parseInt(idString);
		Date dateOfBirth = null;
		try {
			dateOfBirth = service.dateStringToDate(dateOfbirthString);
		} catch (ParseException e1) {
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "invalid date formate it should be yyyy-mm-dd format");
			request.getRequestDispatcher("/exception.jsp");
		}

		try {
			User user = new User(id, email, dateOfBirth, password, country);
			service.deleteReg(user);
			request.setAttribute("status", "success");
			request.setAttribute("msg", "Record has been  deleted ");
			request.setAttribute("title","delete");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "Record cannot be deleted due to internal server error----Try after some time");
			request.setAttribute("title","exception");
			RequestDispatcher rd= request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
		}
		
	}

}
