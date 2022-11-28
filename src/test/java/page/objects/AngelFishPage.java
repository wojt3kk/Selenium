package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishPage {

    private Logger logger = LogManager.getRootLogger();
    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement addAngelFishSmall;


    public AngelFishPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public ShoppingCartPage addAngelFishSmallToCart(){
        WaitForElement.waitUntilElementIsVisible(addAngelFishSmall);
        addAngelFishSmall.click();
        logger.info("Clicked on Small Angelfish Add to cart button");
        return new ShoppingCartPage();
    }
}
