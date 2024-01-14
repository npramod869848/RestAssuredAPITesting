package QueryParameter;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class QueryParameterDemo {

	@Test
	public void filterData()
	{
		//Get request specification for the given statement.
		RequestSpecification rs=RestAssured.given();
		
		//specify base url
		rs.baseUri("https://reqres.in");
		rs.basePath("/api/users");
		rs.queryParam("page",2).queryParam("id", 10);// page 2 vrti 10 cha data milavla
		
		//perform get request
		Response rspnse=rs.get();
		String responseBodystring=rspnse.getBody().asString();
		
		//print response body
		System.out.println("Response body:" +responseBodystring);
		
		JsonPath jsonPathView=rspnse.jsonPath();
		
		//get first_name//jsonpath
		String firstname=jsonPathView.get("data.first_name");
		Assert.assertEquals(firstname,"Byron","verify first name");
		
		
		
	}
}
