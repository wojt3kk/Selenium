import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests {

    private WebDriver driver;

    //
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }


    @Test
    public void hoverTest() {
        WebElement firstAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        WebElement secondAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        WebElement thirdAvatar = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));

        Actions action = new Actions(driver);
        action.moveToElement(firstAvatar).click().build().perform();
        WebElement userOneName = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement userTwoName = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement userThreeName = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(userOneName.getText(),"name: user1");
        assertEquals(userTwoName.getText(),"");
        assertEquals(userThreeName.getText(),"");

        action.moveToElement(secondAvatar).perform();
        assertEquals(userOneName.getText(),"");
        assertEquals(userTwoName.getText(),"name: user2");
        assertEquals(userThreeName.getText(),"");

        action.moveToElement(thirdAvatar).perform();
        assertEquals(userOneName.getText(),"");
        assertEquals(userTwoName.getText(),"");
        assertEquals(userThreeName.getText(),"name: user3");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
