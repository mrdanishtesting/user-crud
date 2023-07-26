package user_crud.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_crud.Exception.UserNotFoundException;
import user_crud.model.DaoServices;
import user_crud.model.DaoServicesImpl;
import user_crud.payload.User;

public class UpdateReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateReg() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		int id=Integer.parseInt(idString);
		
		
		
		DaoServices services=new DaoServicesImpl();
		 User userById = services.getUserById(id);
		
		request.setAttribute("userById", userById);
		request.setAttribute("title","update");
		RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
		rd.forward(request, response);
		
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);
		
        String idString=request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dobString = request.getParameter("dateOfBirth");
		String country = request.getParameter("country");
		int id=Integer.parseInt(idString);
		Date dateOfBirth = null;
		
			
			try {
				dateOfBirth = service.dateStringToDate(dobString);
				
				User user=new User();
				user.setId(id);
				user.setEmail(email);
				user.setPassword(password);
				user.setDateOfBirth(dateOfBirth);
				user.setCountry(country);
				service.updateReg(user);
				request.setAttribute("status", "success");
				request.setAttribute("msg", "record is updated");
				
				RequestDispatcher rd1 = request.getRequestDispatcher("/registration.jsp");
				rd1.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("status","failure");
				request.setAttribute("msg", "invalid date format it should be yyyy-mm-dd format");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
			
	}
}

		
	

