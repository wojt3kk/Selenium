package tutorial_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExplicitWaitTests2 {
    private WebDriver driver;

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForPresenceOfTheElement(){
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement removeOrAddButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText() ,"It's gone!");

        removeOrAddButton.click();

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());





    }
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
