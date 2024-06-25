package apiTests;

import config.ConfigurationProperties;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojoClasses.CardDetails;
import pojoClasses.LoginApiRequest;


import java.util.HashMap;
import java.util.Map;

import static commonUtils.CommonUtils.randomNumberGenerator;
import static io.restassured.RestAssured.given;

public class cardDetailsTest {
    @BeforeTest
    public void testLogin() {
        // Create login request payload
        LoginApiRequest loginRequest = LoginApiRequest.builder().email(ConfigurationProperties.USER_EMAIL).password(ConfigurationProperties.USER_PASSWORD).build();

        // Make a POST request to the login API
        Response response = given()
                .header("Content-Type", "application/json")
                .body(loginRequest)
                .when().log().all()
                .post(ConfigurationProperties.BASE_URL + ConfigurationProperties.LOGIN_ENDPOINT)
                .then().log().all()
                .extract().response();

        //Set accessToken
        ConfigurationProperties.AUTHENTICATION_TOKEN = response.jsonPath().getString("authentication.token");

        // Validate the response
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("authentication.umail"), ConfigurationProperties.USER_EMAIL);
    }

    @Test(priority = 1)
    public void testCardDetails() {
        //Create testCardRequest payload

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer " + ConfigurationProperties.AUTHENTICATION_TOKEN);

        //Create Card details request payload
        CardDetails cardDetails = CardDetails.builder().fullName(ConfigurationProperties.CARD_NAME).cardNum(randomNumberGenerator(16)).expMonth(ConfigurationProperties.EXP_MONTH).expYear(ConfigurationProperties.EXP_YEAR).build();

        // Make a POST request to the cards api
        Response response = given()
                .headers(headers)
                .body(cardDetails)
                .when().log().all()
                .post(ConfigurationProperties.BASE_URL + ConfigurationProperties.CREATE_CARDS)
                .then().log().all()
                .extract().response();

        // Validate the response
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("status"), "success");
    }

}
