package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;


public class TopMenuPage extends BasePage{

//    private Logger logger = LogManager.getLogger(TopMenuPage.class); <--- przeniesione do BasePage (parent)
    @FindBy(xpath = "//*[@id=\"MenuContent\"]/a[2]")
    WebElement signOnLink;

    @FindBy(css = "#QuickLinks a[href*='FISH']")
    WebElement chooseCategoryFish;

    public TopMenuPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink(){
 //       WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on link");
        return new LoginPage();
    }

    public void clickOnCategoryFish(){
        chooseCategoryFish.click();
    }
}
