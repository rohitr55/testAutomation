package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    public By accountButton = By.xpath("//span[contains(text(),'Account')]");
    public By loginPageButton = By.xpath("//button//span[contains(text(),'Login')]");
    public By loginPageSpan = By.xpath("//span[contains(text(),'OWASP Juice Shop')]");
    public By alterPopUp = By.xpath("//mat-dialog-container[contains(@class,'mat-dialog-container')]");
    public By dismissButton = By.xpath("//button//span[contains(text(),'Dismiss')]");
    public By yourBasketButton = By.xpath("//span[contains(text(),' Your Basket')]");
    public By orderAndPaymentButton = By.xpath(" //button//span[contains(text(),'Orders & Payment')]");
    public By myPaymentsButton = By.xpath("//span[contains(text(),'My Payment Options')]");
}

