package user_crud.model;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user_crud.payload.User;

public abstract interface DaoServices  {
	
	
	public boolean verifyCredentials(User user)throws Exception;
	public boolean checkPassword(String password ,String confirmpassword);
	public boolean checkUniqueEmail(User user)throws Exception;
	public String saveRegistration(User user)throws Exception;
	public List<User> getListAll(int recordsPerPage,int offset) throws Exception;
	public List<User> getListAll() throws Exception;
	public void deleteReg(User user)throws SQLException;

	public boolean updateReg(User user)throws Exception;

	public int noOfRecords();
	
	public void checkSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public Date dateStringToDate(String dobString)throws ParseException;
	public User getUserById(int id1);
	public User getUserByEmail(String email);
	
	
}
