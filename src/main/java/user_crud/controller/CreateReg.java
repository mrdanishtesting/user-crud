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

		request.setAttribute("status", "success");
		request.setAttribute("msg", "welcome to the registration form");
		RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// DaoServices service = new DaoServicesImpl();
//		service.checkSession(request, response);

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmPassword");
		String dobString = request.getParameter("dateOfBirth");
		String country = request.getParameter("country");

		boolean allParameters = service.checkAllParameters(email, password, confirmpassword, dobString, country);
		if (allParameters ==true) {

			Date dateOfBirth = null;
			try {
				System.out.println("dateOfBirth");
				dateOfBirth = service.dateStringToDate(dobString);
			} catch (ParseException e1) {
				request.setAttribute("status", "failure");
				request.setAttribute("msg", "date should be yyyy-mm-dd format ");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
			}

			boolean passwordchecked = false;
			try {
				passwordchecked = service.checkPassword(password, confirmpassword);
			} catch (Exception e) {
				request.setAttribute("msg", "some internal error happens in password &confirmpassword");
				request.setAttribute("status", "failure");
				RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
				rd.forward(request, response);
			}
			if (passwordchecked) {
				User user = new User();
				user.setEmail(email);

				boolean emailExist =true;
				try {
					emailExist = service.checkExistEmail(user);
				} catch (Exception e) {

					e.printStackTrace();
					request.setAttribute("msg", "some internal error happens while checking your email exist or not");
					request.setAttribute("status", "failure");
					RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
					rd.forward(request, response);
				}

				if (emailExist==false) {

					User users = new User(email, password, dateOfBirth, country);
					try {
						String save = service.saveRegistration(users);
					} catch (Exception e) {

						e.printStackTrace();
						request.setAttribute("msg", "some internal error happens while saving your form");
						request.setAttribute("status", "failure");
						RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
						rd.forward(request, response);
					}
					User byEmail = service.getUserByEmail(email);
					request.setAttribute("byemail", byEmail);
					request.setAttribute("msg", "record is saved");
					request.setAttribute("status", "success");
					RequestDispatcher rd = request.getRequestDispatcher("/registered.jsp");
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

		}else {
			request.setAttribute("status", "failure");
			request.setAttribute("msg", "all users details are mandatory!!!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);
		}
	}
}
