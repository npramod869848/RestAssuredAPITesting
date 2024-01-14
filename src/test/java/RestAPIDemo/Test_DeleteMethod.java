package RestAPIDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
@Test
public class Test_DeleteMethod {
	public void test06()
	{
		RestAssured.baseURI="https://reqres.in/api/users/52";
		RestAssured.given().
		when().
		   delete().
		   then().
		   log().all().
		   statusCode(204);
}
}
