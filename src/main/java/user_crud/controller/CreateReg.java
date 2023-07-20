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

public class CreateReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoServices service = new DaoServicesImpl();

	public CreateReg() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   

		request.setAttribute("status" ,"success");
		request.setAttribute("msg", "welcome to the registration form");
		RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DaoServices service = new DaoServicesImpl();
		service.checkSession(request, response);
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmPassword");
		String dobString = request.getParameter("dateOfBirth");
		String country = request.getParameter("country");

		Date dateOfBirth = null;
		try {
			dateOfBirth = service.dateStringToDate(dobString);
			
			if (dateOfBirth == null) {
				request.setAttribute("status","failure");
				request.setAttribute("msg", "invalid date format it should be yyyy-mm-dd format");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
			}
			System.out.println("formated date:" +dateOfBirth);
			
		}catch (ParseException e1) {
			request.setAttribute("status","failure");
			request.setAttribute("msg", "invalid date format it should be yyyy-mm-dd format");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
		}
		
		try {
			boolean passwordchecked = service.checkPassword(password, confirmpassword);
			if (passwordchecked) {
				User user1 = new User();
				user1.setEmail(email);
				boolean checkUniqueEmail = service.checkUniqueEmail(user1);

				if (checkUniqueEmail == false) {

					User user = new User(email, password, dateOfBirth, country);
					String save = service.saveRegistration(user);
					System.out.println(save);
					request.setAttribute("msg", "record is saved");
					request.setAttribute("status", "success");
					RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
					rd.forward(request, response);
				} else {

					request.setAttribute("status", "failure");
					request.setAttribute("msg",
							"email is already exist in the registration form kindly enter new email");
					RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("status", "failure");
				request.setAttribute("msg", "password/confirmpassword are not same!!!!!");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "all fields are empty and to submit the form all fields are mandatory");
			request.setAttribute("status", "failure");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}

}
