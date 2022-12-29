package tutorial_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTestV2 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
//        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
    public void lookForALetter() {
//        FluentWait<WebDriver> fluentWait = new FluentWait(driver);
//        fluentWait.withTimeout(Duration.ofSeconds(5));
//        fluentWait.pollingEvery(Duration.ofMillis(250));
//        fluentWait.ignoring(NoSuchElementException.class);
//        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smiley2")));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smiley2")));
    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
