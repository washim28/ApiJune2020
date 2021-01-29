package restApiTestes;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import database.DatabasePage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Or_Read_A_Local_Product {
	@Test

	public void read_A_Product() throws ClassNotFoundException, SQLException {

		// RestAssured.baseURI = ("https://techfios.com");
		Response response = 
				given()
					.log().all()
					.baseUri("https://localhost:80")
					.queryParam("id", "809")
					.header("Contant-Type", "application/json")
				.when()
					.log().all()
					.get("/api-prod/api/product/read_one.php")
				.then()
					.statusCode(200)
					.extract().response();

		// Validating Respose Status
		 int responseStatuse = response.getStatusCode();
		 System.out.println("Response Status:" + responseStatuse);
		 Assert.assertEquals(responseStatuse, 200);

		
		//Validating Respose header
		String responsHeader = response.getHeader("Content-Type");
		System.out.println(responsHeader);
		Assert.assertEquals(responsHeader, "application/json");
		
		 String responsebody = response.getBody().asString();
		 JsonPath js = new JsonPath(responsebody);
		 String productName = js.get("name");
		 String productDescription = js.get("description");
	
		 
		 Assert.assertEquals(productName, DatabasePage.getProduct("name", 809).get(0));
		 Assert.assertEquals(productDescription, DatabasePage.getProduct("description", 809).get(0));
		
		System.out.println(productName + "\n" +productDescription + "\n");
	}

}
