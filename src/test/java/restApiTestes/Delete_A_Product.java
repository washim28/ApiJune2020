package restApiTestes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Delete_A_Product {
	@SuppressWarnings("unchecked")
	@Test

	public void  delete_A_Product() {
		
		@SuppressWarnings("rawtypes")
		HashMap payloadBody =  new HashMap();
		payloadBody.put("id", "988");
		
		// RestAssured.baseURI = ("https://techfios.com");
		Response response = 
				given()
					.log().all()
					.baseUri("https://techfios.com")
					.body(payloadBody)
					.header("Contant-Type", "application/json")
				.when()
					.log().all()
					.delete("/api-prod/api/product/delete.php")
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
