package RestAPIDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestGetMethod {

	@Test
	public void test01()
	{
		//Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code:"+res.getStatusCode());
		System.out.println("Response body:"+res.getBody().asString());
		System.out.println("Response time:"+res.getTime());
		System.out.println("Response Header:"+res.getHeader("Content-Type"));

		//validate status code
		//expected status code=200

		int expectedStatusCode=200;
		int Actualstatuscode = res.getStatusCode();//get status ha status code madhe store karne
		Assert.assertEquals(expectedStatusCode,Actualstatuscode);
	}
	@Test
	public void test02()
	{ 
		//given,when,then

		//RestAssured.baseURI="https://reqres.in/api/users";
		//RestAssured.given().queryParam("page","2").when().get().then().statusCode(200);
		baseURI="https://reqres.in/api/users";
		given().queryParam("page","2").when().get().then().statusCode(200);

	}
}