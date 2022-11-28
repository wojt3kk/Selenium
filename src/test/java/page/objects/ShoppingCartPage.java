package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCartPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Cart a[href*='EST-2']")
    private WebElement findAngelFishInTheCart;

    @FindBy(css = "#Cart a[href*='newOrderForm']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);

    }
    public CheckoutPage clickOnProceedToCheckoutButton(){
        WaitForElement.waitUntilElementIsVisible(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on Proceed to checkout Button");
        return new CheckoutPage();
    }

    public String getWarningMessage() {
//        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));  --- wyniesione do @FindBy
        String warningText = messageLabel.getText();
        return warningText;
    }

}
