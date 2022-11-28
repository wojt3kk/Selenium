package page.objects;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Catalog a[href*='FI-SW-01']")
    WebElement addAngelFish;

        public FishPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelFishPage addAngelFishToCart(){
        WaitForElement.waitUntilElementIsVisible(addAngelFish);
            addAngelFish.click();
            logger.info("Clicked on Angelfish Link");
            return new AngelFishPage();
        }
}
