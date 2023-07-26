package user_crud.payload;

import java.io.Serializable;
import java.sql.Date;


public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private int id;
	private String password;
	private String confirmPassword;
	private Date dateOfBirth;
	private String country;

	public User() {
		
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String email, String password, Date dateOfBirth, String country) {
		super();
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}
	public User( int id,String password, Date dateOfBirth, String country) {
		super();
		this.id=id;
		
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}

	
	public User(String email, int id, String password, Date dateOfBirth, String country) {
		super();
		this.email = email;
		this.id = id;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
	}

	public User(String email, String password, Date dateOfBirth) {
		super();
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public User(int id2, String email2, Date dateOfBirth2, String password2, String country2) {
		this.id=id2;
		this.email=email2;
		this.password=password2;
		this.dateOfBirth=dateOfBirth2;
		this.country=country2;
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
