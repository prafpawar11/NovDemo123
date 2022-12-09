package Tutorial3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ComvertToJsonFormat {

	public static void main(String[] args)  {
		
		AddNewEmployee newuser =new AddNewEmployee("amit","abc","patil","123");
		
		ObjectMapper obj=new ObjectMapper();
		
		String a;
		try {
			a = obj.writerWithDefaultPrettyPrinter().writeValueAsString(newuser);
			System.out.println(a);
		} catch (JsonProcessingException e) {
			
			System.out.println("issue");
		}
		
	
		
		
		
		
		
	}
}
