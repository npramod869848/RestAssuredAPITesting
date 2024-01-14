package Authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorizationdemo {
	@Test
	public void BasicAuth()
	{
		
		RequestSpecification rs=RestAssured.given();
		
		//specify url
		rs.baseUri("http://postman-echo.com");
		rs.basePath("/basic-auth");
		
		//perform get request
		
		//Response rspn=rs.get();
		//Response rspn=rs.auth().basic("postman", "password").get();  //basic auth
		Response rspn=rs.auth().preemptive().basic("postman", "password").get();  // preemptive means first attempt enter valid userid and password
		
		//print status line
		System.out.println("Response status:" + rspn.statusLine());
		System.out.println("Response body:" + rspn.body().asString());
		
	}
	public void DigestAuth()
	{
		//http://httpbin.org/digest-auth/undefined/prachi/prachi
		RequestSpecification rs=RestAssured.given();
		
		//specify url
		rs.baseUri("http://postman-echo.com");
		rs.basePath("/basic-auth");
		
		//perform get request
		
		//Response rspn=rs.get();
		//Response rspn=rs.auth().basic("postman", "password").get();  //basic auth
		Response rspn=rs.auth().preemptive().basic("postman", "password").get();  // preemptive means first attempt enter valid userid and password
		
		//print status line
		System.out.println("Response status:" + rspn.statusLine());
		System.out.println("Response body:" + rspn.body().asString());
		
	}
}
