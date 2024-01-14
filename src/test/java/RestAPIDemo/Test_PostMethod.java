package RestAPIDemo;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {    
@Test
	public void test03()
	{
		JSONObject jd=new JSONObject();
		jd.put("name","Prachi");
		jd.put("job","QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-type","application/json").
        contentType(ContentType.JSON).
        body(jd.toJSONString()).
        when().post().
        then().statusCode(201).log().all();   //response console madhe hava asel tr log method use karne.
		
		
	}
}
