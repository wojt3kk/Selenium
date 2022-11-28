package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.DriverManager;
import waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy(css = "#MainImageContent area[href*='FISH']")
    private WebElement btnFishLink;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String username){
//        WebElement usernameField = driver.findElement(By.name("username")); --- wyniesione do @FindBy
//        usernameField.clear();
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field: {}", username);
        return this;
    }

    public LoginPage  typeIntoPasswordField(String password){
//        WebElement passwordField = driver.findElement(By.name("password"));  --- wyniesione do @FindBy
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field: {}", password);
        return this;
    }

    public FooterPage clickOnLoginButton() {
//        WebElement signOnButton = driver.findElement(By.name("signon"));  --- wyniesione do @FindBy
        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }
    public String getWarningMessage(){
//        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));  --- wyniesione do @FindBy
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    public FishPage clickOnFishImageButton(){
        WaitForElement.waitUntilElementIsVisible(btnFishLink);
        btnFishLink.click();
        logger.info("Clicked on fish image");
        return new FishPage();
    }
}
