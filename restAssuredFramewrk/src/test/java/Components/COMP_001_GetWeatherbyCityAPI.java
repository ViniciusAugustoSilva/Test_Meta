package Components;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.GenericMethods;

public class COMP_001_GetWeatherbyCityAPI {
	
	private GenericMethods genericMethods = new GenericMethods();
	
	@Test
	public void GetWeatherbyCity(String url, String license, String city, String state) {
		RestAssured.baseURI = url;

		Response response = RestAssured.given()
				.params("license", license, "city", city, "state", state).when().get();

		System.out.println(response.getBody().asString());
		
		String cityValue = genericMethods.getValueFromBody(response, "City");
		String stateValue = genericMethods.getValueFromBody(response, "State");
		String weatherValue = genericMethods.getValueFromBody(response, "Weather");
		String codeValue = genericMethods.getValueFromBody(response, "Code");

		System.out.println("City: " + cityValue);
		System.out.println("State: " + stateValue);
		System.out.println("Weather: " + weatherValue);
		System.out.println("Code: " + codeValue);

		Assert.assertEquals(cityValue, "Boston");
		Assert.assertEquals(stateValue, "MA");
		Assert.assertEquals(codeValue, "Success");
	}

}
