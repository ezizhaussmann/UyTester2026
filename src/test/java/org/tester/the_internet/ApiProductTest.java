package org.tester.the_internet;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Test class for Automation Exercise API products endpoint
 * Includes both API testing and optional UI verification
 */
public class ApiProductTest {

    private static final String BASE_API_URL = "https://automationexercise.com/api";
    private static final String PRODUCTS_ENDPOINT = "/productsList";
    private static final String BASE_UI_URL = "https://automationexercise.com";
    private static final String PRODUCTS_PAGE = "/products";
    
    private WebDriver driver;
    private RequestSpecification requestSpec;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver for UI tests
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        
        // Configure RestAssured for API tests
        RestAssured.baseURI = BASE_API_URL;
        requestSpec = given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
        
        System.out.println("=== Test Setup Complete ===");
    }

    @Test(description = "Test API GET all products - Basic functionality")
    public void testGetAllProductsApi() {
        System.out.println("=== Testing GET all products API ===");
        
        try {
            // Send GET request
            Response response = requestSpec
                    .when()
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .extract()
                    .response();

            // Validate response
            validateApiResponse(response);
            
            // Log response details
            logResponseDetails(response);
            
            System.out.println("API test completed successfully");
            
        } catch (Exception e) {
            System.err.println("API test failed: " + e.getMessage());
            Assert.fail("API test failed with exception: " + e.getMessage());
        }
    }

    @Test(description = "Test API response structure and content")
    public void testApiResponseStructure() {
        System.out.println("=== Testing API response structure ===");
        
        try {
            Response response = requestSpec
                    .when()
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .extract()
                    .response();

            // Validate status code
            Assert.assertEquals(response.getStatusCode(), 200, 
                "Expected status code 200 but got: " + response.getStatusCode());

            // Validate response time (should be reasonable)
            Assert.assertTrue(response.getTime() < 5000, 
                "Response time too high: " + response.getTime() + "ms");

            // Validate content type
            String contentType = response.getHeader("Content-Type");
            Assert.assertTrue(contentType != null && contentType.contains("application/json"),
                "Expected JSON content type but got: " + contentType);

            // Validate response body is not empty
            String responseBody = response.getBody().asString();
            Assert.assertFalse(responseBody.isEmpty(), "Response body should not be empty");
            Assert.assertTrue(responseBody.startsWith("{"), "Response should be JSON object");

            // Try to parse as JSON (basic validation)
            try {
                response.jsonPath();
                System.out.println("Response is valid JSON");
            } catch (Exception e) {
                Assert.fail("Response is not valid JSON: " + e.getMessage());
            }

            System.out.println("API response structure validation passed");
            
        } catch (Exception e) {
            System.err.println("Response structure test failed: " + e.getMessage());
            Assert.fail("Response structure test failed: " + e.getMessage());
        }
    }

    @Test(description = "Test UI products page - Optional verification")
    public void testProductsPageUI() {
        System.out.println("=== Testing Products Page UI ===");
        
        try {
            // Navigate to products page
            driver.get(BASE_UI_URL + PRODUCTS_PAGE);
            
            // Wait for page to load
            Thread.sleep(2000);
            
            // Validate page title
            String pageTitle = driver.getTitle();
            Assert.assertNotNull(pageTitle, "Page title should not be null");
            Assert.assertFalse(pageTitle.isEmpty(), "Page title should not be empty");
            
            // Validate current URL
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("automationexercise.com"), 
                "Should be on automationexercise.com domain");
            Assert.assertTrue(currentUrl.contains("products"), 
                "Should be on products page");

            System.out.println("Page Title: " + pageTitle);
            System.out.println("Current URL: " + currentUrl);
            System.out.println("UI test completed successfully");
            
        } catch (Exception e) {
            System.err.println("UI test failed: " + e.getMessage());
            Assert.fail("UI test failed: " + e.getMessage());
        }
    }

    @Test(description = "Test API and UI integration")
    public void testApiUiIntegration() {
        System.out.println("=== Testing API-UI Integration ===");
        
        try {
            // First test API
            Response apiResponse = requestSpec
                    .when()
                    .get(PRODUCTS_ENDPOINT)
                    .then()
                    .extract()
                    .response();
            
            validateApiResponse(apiResponse);
            
            // Then test UI
            driver.get(BASE_UI_URL + PRODUCTS_PAGE);
            Thread.sleep(2000);
            
            String pageTitle = driver.getTitle();
            Assert.assertNotNull(pageTitle, "Page title should not be null");
            
            System.out.println("Integration test passed - API: " + apiResponse.getStatusCode() + 
                             ", UI Page: " + pageTitle);
            
        } catch (Exception e) {
            System.err.println("Integration test failed: " + e.getMessage());
            Assert.fail("Integration test failed: " + e.getMessage());
        }
    }

    /**
     * Validates basic API response
     */
    private void validateApiResponse(Response response) {
        // Validate status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, 
            "Expected status code 200 but got: " + statusCode);

        // Validate response body is not empty
        String responseBody = response.getBody().asString();
        Assert.assertFalse(responseBody.isEmpty(), "Response body should not be empty");
        
        // Validate response contains expected content
        Assert.assertTrue(responseBody.contains("products") || responseBody.contains("Products"), 
            "Response should contain products data");
    }

    /**
     * Logs detailed response information
     */
    private void logResponseDetails(Response response) {
        System.out.println("=== API Response Details ===");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Time: " + response.getTime() + "ms");
        System.out.println("Content Type: " + response.getHeader("Content-Type"));
        System.out.println("Content Length: " + response.getBody().asString().length() + " characters");
        
        // Log a preview of the response body (first 200 characters)
        String responseBody = response.getBody().asString();
        String preview = responseBody.length() > 200 ? 
            responseBody.substring(0, 200) + "..." : responseBody;
        System.out.println("Response Body Preview: " + preview);
        System.out.println("==========================");
    }

    @AfterMethod
    public void tearDown() {
        try {
            // Close WebDriver if initialized
            if (driver != null) {
                driver.quit();
                System.out.println("WebDriver closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Error closing WebDriver: " + e.getMessage());
        }
        
        // Reset RestAssured
        RestAssured.reset();
        System.out.println("=== Test Teardown Complete ===");
    }
}
