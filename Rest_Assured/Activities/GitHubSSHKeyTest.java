package Activities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubSSHKeyTest {

    // RequestSpecification object
    RequestSpecification requestSpec;

    // Variables
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHKHWARBi7gpDBLyA2Tvi1HyjqsvT3TY/TcUfHA4yxpN"; 
    int keyId;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "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")
                .build();

        RestAssured.requestSpecification = requestSpec;
    }

    @Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "  \"title\": \"TestAPIKey\",\n" +
                "  \"key\": \"" + sshKey + "\"\n" +
                "}";

        Response response =
                RestAssured
                        .given()
                        .body(requestBody)
                        .when()
                        .post("/user/keys");

        response.then().log().all();

        // Assertion: Status Code
        Assert.assertEquals(response.getStatusCode(), 201, "SSH key not created");

        // Extract key ID
        keyId = response.jsonPath().getInt("id");
        Assert.assertTrue(keyId > 0, "Invalid SSH key ID returned");

        Reporter.log("SSH Key created with ID: " + keyId, true);
    }

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}");

        response.then().log().all();

        // Assertion: Status Code
        Assert.assertEquals(response.getStatusCode(), 200, "Failed to retrieve SSH key");

        Reporter.log("Retrieved SSH Key Details: " + response.asPrettyString(), true);
    }

    @Test(priority = 3, dependsOnMethods = "addSSHKey")
    public void deleteSSHKey() {

        Response response =
                RestAssured
                        .given()
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}");

        // Assertion: Status Code
        Assert.assertEquals(response.getStatusCode(), 204, "Failed to delete SSH key");

        Reporter.log("SSH Key deleted successfully. ID: " + keyId, true);
    }
}
