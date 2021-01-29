package restApiTestes;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_Or_Read_A_Product {

	@Test

	public void read_A_Product() {

		// RestAssured.baseURI = ("https://techfios.com");
		Response response = 
				given()
					.log().all()
					.baseUri("https://techfios.com")
					.queryParam("id", "912")
					.header("Contant-Type", "application/json")
				.when()
					.log().all()
					.get("/api-prod/api/product/read_one.php")
				.then()
					.extract().response();

		// Validating Respose Status
		// int responseStatuse = response.getStatusCode();
		// System.out.println("Response Status:" + responseStatuse);
		// Assert.assertEquals(responseStatuse, 200);

		
		//Validating Respose header
		//String responsHeader = response.getHeader("Content-Type");
		//System.out.println(responsHeader);
		//Assert.assertEquals(responsHeader, "application/json");
		
		 String responsebody = response.getBody().asString();
		 JsonPath js = new JsonPath(responsebody);
		 String productName = js.get("name");
		 String productDescription = js.get("description");
	
		 
		 Assert.assertEquals(productName, "HP Laptop Elite Pro 2.0");
		 Assert.assertEquals(productDescription, "Latest Super fast laptop");
		
		 //System.out.println(productName + "\n" +productDescription + "\n");
	}

}
