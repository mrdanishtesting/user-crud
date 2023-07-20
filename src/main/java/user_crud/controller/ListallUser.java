package user_crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_crud.model.DaoServices;
import user_crud.model.DaoServicesImpl;
import user_crud.payload.User;

public class ListallUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public ListallUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println(100);
		DaoServices service = new DaoServicesImpl();
	service.checkSession(request, response);
		try {
			int limit = 2;
			String page = request.getParameter("currentPage");
		
			if (page == null) {
				page = "1";
			}
			int pagep = Integer.parseInt(page);

			int offset = (pagep - 1) * limit;

			List<User> listUser = service.getListAll(limit, offset);

			int noOfRecords = service.noOfRecords();

			int numOfPage = (int) Math.ceil(noOfRecords * 1.0 / limit);

			request.setAttribute("currentPage", pagep);
			request.setAttribute("listUser", listUser);
			request.setAttribute("noOfRecords", noOfRecords);
			request.setAttribute("numOfPage", numOfPage);
			request.setAttribute("title", "listall");
			RequestDispatcher rd = request.getRequestDispatcher("/listall.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status","success");
			request.setAttribute("msg", "Record cannot be seen due to some internal server error-------Trt-After--SomeTime");
			RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
