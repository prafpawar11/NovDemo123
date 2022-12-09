package Tutorial7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Demo1 {

	public static void main(String[] args) throws JsonProcessingException {
		
		DeptName d =new DeptName();
		d.setDname("Testing");
		d.setProjectManager("PM:Praful");
		d.setTeamLeader("TL:Pawar");
		
		CreateEmployee e =new CreateEmployee();
		e.setFirstName("amit");
		e.setLastName("patil");
		e.setAddress("Pune");
		e.setJob("Test Engineer");
		
		e.setDeptName(d);
		
		ObjectMapper obj =new ObjectMapper();
		String b =obj.writerWithDefaultPrettyPrinter().writeValueAsString(e);
		System.out.println(b);
		
		
		
		
		
	}
}
