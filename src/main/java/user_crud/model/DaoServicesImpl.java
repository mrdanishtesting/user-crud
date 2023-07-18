package user_crud.model;

import java.io.IOException;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user_crud.Exception.UserNotFoundException;
import user_crud.payload.User;

public class DaoServicesImpl implements DaoServices{

	Connection con;
	
	@Override
	public boolean checkPassword(String password, String confirmpassword) {
		if (password.equals(confirmpassword)) {
			return true;
		}
		return false;
	}
	public void connectToDb() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user", "usercrud", "usercrud");
		} catch (Exception e) {
			throw new UserNotFoundException("connection failed to database");
		}
	}

	@Override
	public boolean verifyCredentials(User user) throws Exception {
		connectToDb();
		
		PreparedStatement psmt = con.prepareStatement("select * from users where email = ? and password = ?");
		psmt.setString(1, user.getEmail());
		psmt.setString(2, user.getPassword());
		ResultSet resultSet = psmt.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		
	}
		}

	@Override
	public String saveRegistration(User user) throws Exception {

		try {

			connectToDb();

			
			PreparedStatement pstmt = con.prepareStatement("insert into users(email,password,dateOfBirth,country) values(?,?,?,?)");
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new UserNotFoundException("error in deleting the registration");
				}

			}
		}
	}

	@Override
	public boolean updateReg(User user) throws Exception {
		try {
			connectToDb();
			PreparedStatement psmt = con.prepareStatement("update users SET password=?,dateofBirth=? where email=?");

			psmt.setString(1, user.getPassword());
			psmt.setDate(2, user.getDateOfBirth());
			psmt.setString(3, user.getEmail());
			psmt.executeUpdate();
			boolean updated = psmt.executeUpdate() > 0;
			return updated;
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
		connectToDb();
		try {
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
				throw new UserNotFoundException("");

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
		if (session != null && session.getAttribute("email") != null) {
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
	public boolean checkUniqueEmail(User user) throws SQLException {
		connectToDb();
		PreparedStatement psmt = con.prepareStatement("select * from users where email=?");
		psmt.setString(1, user.getEmail());
		ResultSet result = psmt.executeQuery();
		if (result.next()) {
			return true;
		}
		return false;

	}

}
