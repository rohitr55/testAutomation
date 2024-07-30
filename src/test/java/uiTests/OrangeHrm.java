package uiTests;

import dataProviders.DataProviders;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHrm {
    public WebDriver driver;

    @BeforeTest()
    public void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'orangehrm-login-layout-blob')]"));
//        ele.isDisplayed();
    }

    @Test(dataProvider = "loginCredentials", dataProviderClass = DataProviders.class)
    public void verifyTheLoginPage(String validation, String username, String password) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
        switch (validation) {
            case "invalidUserName":
            case "invalidPassword":
                Assert.assertEquals((driver.findElement(By.xpath("//p[contains(@class,'alert-content')]")).getText()), "Invalid credentials");
                break;
            case "emptyInputs":
                Assert.assertEquals((driver.findElement(By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")).getText()), "Required");
                break;
            case "validCredentials":
                WebElement ele1 = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
                ele1.isDisplayed();
                break;
            default:
                System.out.println("the given input is not present");
        }
    }
    @AfterTest()
    public void tearDown(){
        driver.quit();
    }
}
