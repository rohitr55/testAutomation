package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentMethodsPage {
    public WebDriver driver;

    public PaymentMethodsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    public By addNewCardButton = By.xpath("//mat-panel-title[contains(text(),'Add new card')]");
    public By cardNameInput = By.xpath("//mat-label[contains(text(),'Name')]//..//..//..//input");
    public By cardNumberInput = By.xpath("//mat-label[contains(text(),'Card Number')]//..//..//..//input");
    public By expMonth = By.xpath("//mat-label[contains(text(),'Expiry Month')]/../../..//select");
    public By expYear = By.xpath("//mat-label[contains(text(),'Expiry Year')]//..//..//..//select");
    public By submitButton = By.xpath("//button[@type]");
    public By saveCardMessage = By.xpath("//snack-bar-container//span[contains(text(),'Your card ending with')]");
}

