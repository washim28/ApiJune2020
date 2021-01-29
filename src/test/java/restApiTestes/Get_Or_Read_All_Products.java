package restApiTestes;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Get_Or_Read_All_Products {

	@Test

	public void read_A_Product() {

		//RestAssured.baseURI = ("https://techfios.com");
		Response response= 
		given()
			.log().all()
			.baseUri("https://techfios.com")
			.header("Contant-Type", "application/json")
		.when()
			.log().all()
			.get("/api-prod/api/product/read.php")
		.then()
			.log().all()
			.statusCode(200)
			//.header("Contant-Type", "application/json; charset=UTF-8" )
			.extract().response();
		
		String RespString = response.asString();
		JsonPath js = new JsonPath(RespString);
		
	}

}
