package tutorial_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTests {

private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkboxesTest(){
        WebElement firstCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        sleep();
        WebElement secondCheckbox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", firstCheckbox);

        assertFalse(firstCheckbox.isSelected());
        sleep();
        assertTrue(secondCheckbox.isSelected());
        sleep();

        firstCheckbox.click();
        sleep();
        secondCheckbox.click();
        sleep();

        assertTrue(firstCheckbox.isSelected());
        assertFalse(secondCheckbox.isSelected());
        sleep();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
