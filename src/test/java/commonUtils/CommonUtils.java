package commonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigurationProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojoClasses.Credentials;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class CommonUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Method to enter text in an element
    public void enterText(By locator, String textToEnter) {
        driver.findElement(locator).sendKeys(textToEnter);
    }

    //Method to click an element
    public void click(By locator) {
        driver.findElement(locator).click();
    }


    // Method to wait for the visibility of an element
    public void waitForVisibility(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //
    public Boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void selectOption(By locator, String option) {
        Select selectOption = new Select(driver.findElement(locator));
        selectOption.selectByValue(option);
    }

    public static Credentials readCredentials(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), Credentials.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void isElementEnabled(By locator) {
        driver.findElement(locator).isEnabled();
    }

    public void waitForElementToBeClickable(By locator, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static long randomNumberGenerator(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (ConfigurationProperties.INTEGER.length() * Math.random());
            sb.append(ConfigurationProperties.INTEGER.charAt(index));
        }
        return Long.parseLong(sb.toString());
    }

    public void hoverOnTheElement(By locator) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(locator)).build().perform();
    }
}

