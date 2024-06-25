package uiTests;

import config.ConfigurationProperties;
import org.testng.annotations.Test;

public class JuiceShopTestCases extends BaseTest {

    @Test(priority = 1)
    public void verifyUserIsAbleToAddCardDetails() throws InterruptedException {
        methods.click(homePage.accountButton);
        methods.click(homePage.orderAndPaymentButton);
        methods.waitForVisibility(homePage.myPaymentsButton, 10);
//        Thread.sleep(3000);
        methods.hoverOnTheElement(homePage.myPaymentsButton);
        methods.click(homePage.myPaymentsButton);
        methods.click(paymentMethodsPage.addNewCardButton);
        methods.enterText(paymentMethodsPage.cardNameInput, ConfigurationProperties.CARD_NAME);
        methods.enterText(paymentMethodsPage.cardNumberInput, ConfigurationProperties.CARD_NUMBER);
        methods.selectOption(paymentMethodsPage.expMonth, ConfigurationProperties.EXP_MONTH);
        methods.selectOption(paymentMethodsPage.expYear, ConfigurationProperties.EXP_YEAR);
        methods.isElementEnabled(paymentMethodsPage.submitButton);
        methods.waitForElementToBeClickable(paymentMethodsPage.submitButton,15);
        Thread.sleep(5000);
        methods.hoverOnTheElement(paymentMethodsPage.submitButton);
        methods.click(paymentMethodsPage.submitButton);
//        Thread.sleep(10000);
        methods.isElementDisplayed(paymentMethodsPage.saveCardMessage);
    }
}
