package Authorization;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BearerToken {
@Test
	public void BearerToken() {
		// Set the base URI and path
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";

		// Create request specification
		RequestSpecification rs = RestAssured.given();

		// Create JSON object for the payload
		JSONObject payload = new JSONObject();
		payload.put("name", "Pramod Nawale Tung");
		payload.put("email", "pramodnawale94@gmail.com");
		payload.put("gender", "Male");
		payload.put("status", "Active");

		// Set the payload
		//rs.body(payload.toJSONString());

		// Send the request and get the response
		// You can use different HTTP methods like post(), get(), put(), etc. based on your requirement
		//rs.post().then().statusCode(200).extract().response();

		String AuthToken="Bearer 8f67b7fa8f780dac4cf84a1951d591bbb1016f533debc7e1800b3c14598bb254";

		//he token header la jail
		rs.headers("Authorization", AuthToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());

		//perform post request
		Response response=rs.post();
		Assert.assertEquals(response.statusCode()/*actual*/,201,"check for status code");

		//print status line
		System.out.println("Response status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());

	}
}
