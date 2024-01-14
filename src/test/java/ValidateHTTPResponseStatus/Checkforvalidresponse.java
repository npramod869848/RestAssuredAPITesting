package ValidateHTTPResponseStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Checkforvalidresponse {
	//https://reqres.in/api/users/2
	@Test
	public void GetSingleUser()
	{
		//specify base url
		RestAssured.baseURI="https://reqres.in/api/users/2";

		//Every request in Rest-Assured library is represented by an interface called Request Specification.
		//Get request specification of the request.
		RequestSpecification requestSpec=RestAssured.given();

		//called get method
		Response response=requestSpec.get();

		//gets response code
		int statusCode=response.getStatusCode();

		//validate actual status code with expected.
		Assert.assertEquals(statusCode/*actual Status code*/,200/*expected status code*/);

		//status line validate (line,protocol.response milto)
		//string return karel

		String statusLine=response.getStatusLine();

		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Incorrect status line");

	}
}
