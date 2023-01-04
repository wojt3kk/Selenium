package page.objects;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;


public class FooterPage extends BasePage {

//    private Logger logger = LogManager.getLogger(FooterPage.class);
    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

     public FooterPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed(){
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }
//    @Step("Getting is dog banner is displayed")
//    public boolean isBannerAfterLoginDisplayed() {
//        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
//        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
//        logger.info("Returning status of banner after login: {}", isDisplayed);
//        return isDisplayed;
//    }
}
