package restApiTestes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Create_A_Local_Product {
	
	@SuppressWarnings("unchecked")
	@Test

	public void create_A_Product() {
		
		@SuppressWarnings("rawtypes")
		HashMap payloadBody =  new HashMap();
		payloadBody.put("name", "iPhone 12 Pro");
		payloadBody.put("description", "Super fast phone");
		payloadBody.put("price", "1799");
		payloadBody.put("category_id", "2");

		// RestAssured.baseURI = ("https://techfios.com");
		Response response = 
				given()
					.log().all()
					.baseUri("https://localhost:80")
					.body(payloadBody)
					.header("Contant-Type", "application/json")
				.when()
					.log().all()
					.get("/api-prod/api/product/create.php")
				.then()
					.statusCode(201)
					.extract().response();

		// Validating Respose Status
		// int responseStatuse = response.getStatusCode();
		// System.out.println("Response Status:" + responseStatuse);
		// Assert.assertEquals(responseStatuse, 201);

		
		//Validating Respose header
		String responsHeader = response.getHeader("Content-Type");
		System.out.println(responsHeader);
		Assert.assertEquals(responsHeader, "application/json; charset=UTF-8");
		
		
		  String responsebody = response.getBody().asString(); 
		System.out.println(responsebody);
		// JsonPath js = new JsonPath(responsebody); 
		 // String productName = js.get("name"); String
		 // productDescription = js.get("description");
		 
		  // Assert.assertEquals(productName, "HP Laptop Elite Pro 2.0");
		 // Assert.assertEquals(productDescription, "Latest Super fast laptop");
		 //System.out.println(productName + "\n" +productDescription + "\n");
	}




}
