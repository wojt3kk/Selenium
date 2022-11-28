import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class FirstAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();

    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("https://duckduckgo.com/");

        String elementId = "search_form_input_homepage";

        WebElement queryField = driver.findElement(By.id(elementId));
//        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
//        driver.findElement(By.id("search_form_input_homepage")).submit();

        queryField.sendKeys("JavaStart");
        queryField.submit();

        String pageTitle = driver.getTitle();
        //System.out.println(pageTitle);

        assertTrue(pageTitle.contains("JavaStart"));
//        driver.navigate().to("https://volt-pd-ci.ext.e-point.pl/");
//
//        driver.findElement(By.id("email")).sendKeys("wkarpowicz+3@e-point.pl");
//        driver.findElement(By.id("password")).sendKeys("Haslo123456");
//        driver.findElement(By.id("password")).submit();
//
//    WebElement loginOk = driver.findElement(By.className("MuiSnackbarContent-message"));
//
//        assertEquals(loginOk, "Logowanie poprawne");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
