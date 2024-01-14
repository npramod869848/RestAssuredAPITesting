package ValidateJsonResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//https://reqres.in/api/users?page=2
public class ValdJsonRespbody {
	@Test
	public void UserListResponseBody()
	{
		//get request specification reference
		RequestSpecification rs=RestAssured.given();
		
		//specify base URI & path
		rs.baseUri("https://reqres.in");
		rs.basePath("api/users/2");
		
		//create /perform get request
		Response rspn=rs.get();
		
		//read response
		ResponseBody rspnbdy=rspn.getBody();
		
		//print response body
		String rspnString=rspnbdy.asString();
		System.out.println("Response body:" + rspnString);
		
		//check for presence of George in response body 
		Assert.assertEquals(rspnString.contains("Janet"),true,"Check for presence of Janet ");
		
		//using json path finder on google
		JsonPath jsonpathview=rspnbdy.jsonPath();
		
		String firstName =jsonpathview.get("data.first_name");
		Assert.assertEquals(firstName,"Janet", "check for presence of first name Janet");
		
	}
}
