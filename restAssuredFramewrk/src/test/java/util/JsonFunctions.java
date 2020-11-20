package util;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFunctions {

public JSONObject readFromJsonFile(String jsonName) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\jsonFiles\\"+jsonName);
		Object obj = jsonParser.parse(reader);
		JSONObject JsonObj = (JSONObject) obj;

		return JsonObj;
		
	}
}
