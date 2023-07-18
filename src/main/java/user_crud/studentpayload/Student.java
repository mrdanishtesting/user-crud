package user_crud.studentpayload;

public class Student {

	private int id;
	private String sname;
	private int marks;
	public Student(int id, String sname, int marks) {
		this.id=id;
		this.sname=sname;
		this.marks=marks;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}
