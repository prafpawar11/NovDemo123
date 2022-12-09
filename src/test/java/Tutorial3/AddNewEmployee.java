package Tutorial3;

public class AddNewEmployee {

	private String fname;
	private String mname;
	private String lname;
	private String empid;

	public AddNewEmployee(String fname, String mname, String lname, String empid) {
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.empid = empid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	

}
