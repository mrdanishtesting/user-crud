package user_crud.model;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_crud.Exception.UserNotFoundException;
import user_crud.payload.User;

public class DaoServicesImpl implements DaoServices {

	Connection con;

	@Override
	public boolean checkPassword(String password, String confirmpassword) {
		return (password.equals(confirmpassword)) ? true : false;
	}

	public void connectToDb() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "usercrud", "usercrud");
		} catch (Exception e) {
			throw new UserNotFoundException("connection failed to database due to internal error");
		}
	}

	@Override
	public boolean verifyCredentials(User user) {
		try {
			connectToDb();

			PreparedStatement psmt = con.prepareStatement("select * from users where email = ? and password = ?");
			psmt.setString(1, user.getEmail());
			psmt.setString(2, user.getPassword());
			ResultSet resultSet = psmt.executeQuery();
			return (resultSet.next()) ? true:false;
				
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public String saveRegistration(User user) throws Exception {

		try {

			connectToDb();

			PreparedStatement pstmt = con
					.prepareStatement("insert into users(email,password,dateOfBirth,country) values(?,?,?,?)");
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			pstmt.setDate(3, user.getDateOfBirth());
			pstmt.setString(4, user.getCountry());
			pstmt.executeUpdate();
			return "save";
		}

		finally {

			if (con != null)
				try {
					con.close();

				} catch (SQLException e) {
					throw new UserNotFoundException("error in creating save registration");
				}

		}

	}

	@Override
	public void deleteReg(User user) throws SQLException {
		try {

			connectToDb();
			PreparedStatement psmt = con.prepareStatement("delete from users where email=?");
			psmt.setString(1, user.getEmail());
			psmt.executeUpdate();

		} finally {
			con.close();
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					throw new UserNotFoundException("error in deleting the registration");
//				}

//		}
		}

	}

	@Override
	public boolean updateReg(User user) throws Exception {
		try {
			connectToDb();
			PreparedStatement psmt = con
					.prepareStatement("update users SET email=?, password=?,dateofBirth=?,country=? where id=?");
			psmt.setInt(5, user.getId());
			psmt.setString(1, user.getEmail());
			psmt.setString(2, user.getPassword());
			psmt.setDate(3, user.getDateOfBirth());
			psmt.setString(4, user.getCountry());
			return psmt.executeUpdate() > 0;
			
		}

		finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new UserNotFoundException("error in updating the registration");
				}
			}

		}

	}

	@Override
	public List<User> getListAll(int limit, int offset) throws SQLException {
		
		List<User> listUser = new ArrayList<>();
		try {
			connectToDb();

			Statement stmt = con.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from users limit '" + limit + "' offset'" + offset + "'");

			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				user.setCountry(resultSet.getString("country"));
				listUser.add(user);
			}
			return listUser;

		}

		finally {

			if (con != null)
				try {
					con.close();

				} catch (SQLException e) {

					throw new UserNotFoundException("error in reading registration");
				}

		}

	}

	@Override
	public int noOfRecords() {
		try {
			connectToDb();
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select count(*) from users");
			while (result.next()) {
				int totalrecords = result.getInt(1);
				System.out.println(totalrecords);
				return totalrecords;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new UserNotFoundException("records not found");

			}
		}

		return 0;

	}

	@Override
	public List<User> getListAll() throws Exception {
		List<User> userslist = new ArrayList<>();
		connectToDb();
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select * from users");

		while (result.next()) {

			User user = new User();
			user.setId(result.getInt("id"));
			user.setPassword(result.getString("password"));
			user.setDateOfBirth(result.getDate("dateOfBirth"));
			user.setCountry(result.getString("country"));
			userslist.add(user);
		}

		return userslist;
	}

	public void checkSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
	
		if (session!=null&&session.getAttribute("email")!=null) {
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
			
			
		
	}

	@Override
	public Date dateStringToDate(String dobString) throws ParseException {
		Date dobDate = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateformated = dateFormat.parse(dobString);
		dobDate = new Date(dateformated.getTime());
		return dobDate;

	}

	@Override
	public boolean checkExistEmail(User user) throws SQLException {
		connectToDb();
		PreparedStatement psmt = con.prepareStatement("select * from users where email=?");
		psmt.setString(1, user.getEmail());
		ResultSet result = psmt.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;

	}

	@Override
	public User getUserById(int id) {
		connectToDb();
		try {
			PreparedStatement psmt = con.prepareStatement("select * from users where id=?");
			psmt.setInt(1, id);
			ResultSet resultset = psmt.executeQuery();
			if (resultset.next()) {
				User user = new User();
				user.setId(resultset.getInt("id"));
				user.setEmail(resultset.getString("email"));
				user.setPassword(resultset.getString("password"));
				user.setDateOfBirth(resultset.getDate("dateOfBirth"));
				user.setCountry(resultset.getString("country"));
				return user;
			}

		} catch (SQLException e) {
			throw new UserNotFoundException("error in getting the id !!!!!wait for some time");

		}
		return null;
	}

	@Override
	public User getUserByEmail(String email) {

		try {
			connectToDb();
			PreparedStatement psmt = con.prepareStatement("select * from users where email=?");
			psmt.setString(1, email);
			ResultSet resultset = psmt.executeQuery();
			if (resultset.next()) {
				User user2 = new User();
				user2.setId(resultset.getInt("id"));
				user2.setEmail(resultset.getString("email"));
				user2.setPassword(resultset.getString("password"));
				user2.setDateOfBirth(resultset.getDate("dateOfBirth"));
				user2.setCountry(resultset.getString("country"));

				return user2;
			}

		} catch (SQLException e) {

			throw new UserNotFoundException("error in getting the email !!!!!wait for sometime ");

		}
		return null;
	}

	@Override
	public boolean checkAllParameters(String email, String password, String confirmpassword, String dobString,
			String country) {
		if (!email.equals("") && !password.equals("") && !confirmpassword.equals("") && !dobString.equals("")
				&& !country.equals("")) {
			return true;

		} else {

			return false;

		}

	}
}
