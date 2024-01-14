package ValidateResponseHeader;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class VRH {
	@Test
	public void Getsingleuser()
	{
		//Get Request specification
		RequestSpecification rs= RestAssured.given();

		//base url specification
		rs.baseUri("https://reqres.in");
		rs.basePath("/api/users/2");

		//create get request
		Response res=rs.get();

		// validate response header
			    String contentType=res.getHeader("Content-Type");
		//	    System.out.println("value of content-type:" + contentType);

		String connection=res.getHeader("Connection");
		System.out.println("value of connection:" + connection);

		//read all the header attributes/keys and print their values
		Headers hdrslist= res.getHeaders();
		
		//header chi key value print kraychi asel tr
		//iterate header list
		for (Header hdr:hdrslist)
		{
			System.out.println(hdr.getName() + ":" + hdr.getValue());
		}
		// validate header content-type,expected value:application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json; charset=utf-8","header content type mismatch");
	}
}
