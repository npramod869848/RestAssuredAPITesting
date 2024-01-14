package RestAPIDemo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {
@Test
	public void test04()
	{
	JSONObject jd=new JSONObject();
	jd.put("name","Pramod");
	jd.put("job","Teacher");
	
	RestAssured.baseURI="https://reqres.in/api/users/52";
	RestAssured.given().header("Content-type","application/json").
    contentType(ContentType.JSON).
    body(jd.toJSONString()).
    when().put().
    then().statusCode(200).log().all();   //response console madhe hava asel tr log method use karne.
	
	
	}
}
