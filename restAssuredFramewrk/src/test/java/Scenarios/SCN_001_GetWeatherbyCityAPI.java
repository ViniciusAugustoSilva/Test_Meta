package Scenarios;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import org.junit.Test;

import Components.COMP_001_GetWeatherbyCityAPI;
import util.JsonFunctions;

public class SCN_001_GetWeatherbyCityAPI {
	
	private JsonFunctions jsonFunction = new JsonFunctions();
	private COMP_001_GetWeatherbyCityAPI COMP_001_GetWeather = new COMP_001_GetWeatherbyCityAPI();

	@Test
	public void getWeather() throws IOException, ParseException {
		
		// Read Json
		JSONObject JSONOBJ = jsonFunction.readFromJsonFile("SCN_001_GetWeatherByCity.json");
		
		// GET WEATHER BY CITY API
		COMP_001_GetWeather.GetWeatherbyCity((String) JSONOBJ.get("URL"), 
											 (String) JSONOBJ.get("LICENSE"), 
											 (String) JSONOBJ.get("CITY"), 
											 (String) JSONOBJ.get("STATE"));

	}

}
