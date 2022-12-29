package tutorial_tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class GetFakeName {
    private WebDriver driver;

    @BeforeMethod
//    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
//        driver = new ChromeDriver();
//        driver.navigate().to("https://www.fakenamegenerator.com/advanced.php?t=country&n%5B%5D=pl&c%5B%5D=pl&gen=&age-min=&age-max=");
//    }
    public void beforeTest() throws MalformedURLException {
        ChromeOptions capability = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.navigate().to("https://www.fakenamegenerator.com/advanced.php?t=country&n%5B%5D=pl&c%5B%5D=pl&gen=&age-min=&age-max=");
    }

    @Test
    public void getName() {
        WebElement nameField = driver.findElement(By.xpath("//*[@id=\"details\"]/div[2]/div[2]/div/div[1]/h3"));
        nameField.getText();
        System.out.println(nameField.getText());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
