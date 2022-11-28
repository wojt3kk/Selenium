package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;


import static navigation.ApplicationsURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests extends TestBase {
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
//            driver = new ChromeDriver();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
//    } ---Przeniesione do TestBase

    @Test
        public void asUserTryToLogInWithIncorrectLoginAndPassword(){
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage= new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();

        //kliknięcie w link "enter the store" ---- przeniesione do klasy page.objects.LandingPage
        //WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        //enterStoreLink.click();

        //kliknięcie w link "Sign in" ---- przeniesione do klasy page.objects.TopMenuPage
//        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));signOnLink.click();

//        TopMenuPage topMenuPage = new TopMenuPage();
//        topMenuPage.clickOnSignInLink();

//        //Wpisanie w polu password wartości "NotProperPassword" ---- Przeniesione do klasy page.objects.LoginPage
//        WebElement passwordField = driver.findElement(By.name("password"));
//        passwordField.sendKeys("NotProperPassword");
//
//        //Wpisanie w polu Username wartości "NotProperUsername" ---- Przeniesione do klasy page.objects.LoginPage
//        WebElement usenameField = driver.findElement(By.name("username"));
//        usenameField.sendKeys("NotProperUsername");
//
//        // Kliknięcie w przycisk Login ---- Przeniesione do klasy page.objects.LoginPage
//        WebElement signOnButton = driver.findElement(By.name("signon"));
//        signOnButton.click();
//
//        //Sprawdzenie czy na stronie pojawił się komunikat "Invalid username or password. Signon failed"
//        //przez sprawdzenie jaki tekst wyświetli się w elemencie ---- Przeniesione do klasy page.objects.LoginPage
//        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));

//        LoginPage loginPage = new LoginPage();
//        loginPage.typeIntoUserNameField("NotExistingLogin");
//        loginPage.typeIntoPasswordField("NotProperPassword");
//        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
//    @AfterMethod
//    public void afterTest(){
//        driver.close();
//        driver.quit();
//    } ---Przeniesione do TestBase
}
