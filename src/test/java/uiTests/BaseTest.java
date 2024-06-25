package uiTests;

import commonUtils.CommonUtils;
import config.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentMethodsPage;
import pojoClasses.Credentials;
import pojoClasses.LoginApiRequest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Declaration of objects
    public WebDriver driver;
    public LoginPage loginPage;
    public CommonUtils methods;
    public HomePage homePage;
    public PaymentMethodsPage paymentMethodsPage;
    public Credentials credentials;


    @BeforeMethod()
    public void initialSetUpAndLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Initialization of Objects
        loginPage = new LoginPage(driver);
        methods = new CommonUtils(driver);
        homePage = new HomePage(driver);
        paymentMethodsPage = new PaymentMethodsPage(driver);

        //login method
        driver.get(ConfigurationProperties.WEBSITE_URL);

        Thread.sleep(5000);

        if (methods.isElementDisplayed(homePage.alterPopUp)) {
            methods.click(homePage.dismissButton);
        }
        methods.waitForVisibility(homePage.accountButton, 5);
        methods.isElementDisplayed(homePage.accountButton);
        methods.click(homePage.accountButton);
        methods.click(homePage.loginPageButton);

        credentials = CommonUtils.readCredentials("src/test/resources/new-user.json");

        methods.enterText(loginPage.usernameInput, credentials.getUsername());
        methods.enterText(loginPage.passwordInput, credentials.getPassword());
        methods.click(loginPage.loginButton);
        methods.isElementDisplayed(homePage.yourBasketButton);
        Thread.sleep(5000);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
