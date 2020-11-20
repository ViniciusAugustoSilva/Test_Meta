package util;


import org.json.JSONArray;
import org.json.JSONObject;


import io.restassured.response.Response;

public class GenericMethods {
	
	public String getValueFromBody(Response response, String parameter)  {
		
		String responseBody = response.getBody().asString();
		responseBody = responseBody.replace("{", "[{");
		responseBody = responseBody.replace("}", "}]");
		
		String value = null;
		JSONArray array = new JSONArray(responseBody);
		for(int i=0; i<array.length(); i++) {
			
			JSONObject obj = array.getJSONObject(i);
			value = (String) obj.get(parameter);
			
			
		}
		return value;
		
	}
	

}
