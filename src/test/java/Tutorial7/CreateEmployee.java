package Tutorial7;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"FirstName","LastName","Address","Job"})
public class CreateEmployee {

	@JsonProperty("FirstName")
	private String firstName;
	
	@JsonProperty("LastName")
	private String lastName;
	
	@JsonProperty("Address")
	private String address;
	
	@JsonProperty("Job")
	private String job;
	
	private DeptName deptName;

	public CreateEmployee() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public DeptName getDeptName() {
		return deptName;
	}

	public void setDeptName(DeptName deptName) {
		this.deptName = deptName;
	}



	

}
