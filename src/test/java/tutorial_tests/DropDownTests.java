package tutorial_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class DropDownTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void dropDownTest(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select dropDownList = new Select(dropDown);

        assertEquals(dropDownList.getFirstSelectedOption().getText(),"Please select an option");
        sleep();

        dropDownList.selectByVisibleText("Option 1");
        assertEquals(dropDownList.getFirstSelectedOption().getText(),"Option 1");
        sleep();

        dropDownList.selectByValue("2");
        assertEquals(dropDownList.getFirstSelectedOption().getText(),"Option 2");
        sleep();



    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
