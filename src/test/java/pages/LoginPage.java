package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    public By usernameInput = By.xpath("//input[contains(@aria-label,'Text field for the login email')]");
    public By passwordInput = By.xpath("//input[contains(@aria-label,'Text field for the login password')]");
    public By loginButton = By.xpath("//button[@type='submit' and @id='loginButton']");

}

