package Tutorial5;

import org.json.simple.JSONObject;

public class UtilsClass {

	public static String jsonData(String fname, String lname, String job, String add) {
		JSONObject json = new JSONObject();
		json.put("FirstName", fname);
		json.put("LastName", lname);
		json.put("Job", job);
		json.put("Address", add);

		return json.toString();
	}

	
	
	
	
}
