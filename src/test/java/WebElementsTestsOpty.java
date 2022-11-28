import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class WebElementsTestsOpty {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

//    @Test
//    public void typingAndClearingValueInsideWebElementTest(){
//        WebElement userNameField = driver.findElement(By.id("username"));
//        sleep();
//        userNameField.sendKeys("Selenium Start");
//
//        String typeUserNameValue = userNameField.getAttribute("value");
//        sleep();
//
//        assertEquals(typeUserNameValue,"Selenium Start");
//
//        userNameField.clear();
//        sleep();
//
//        String emptyUserNameField = userNameField.getAttribute("value");
//        assertEquals(emptyUserNameField,"");
//
//    }

//    @Test
//    public void typingIntoWebElementTest(){
//        WebElement userNameField = driver.findElement(By.id("username"));
//        sleep();
//        userNameField.sendKeys("Selenium Start");
//
//        String typeUserNameValue = userNameField.getAttribute("value");
//        sleep();
//        assertEquals(typeUserNameValue,"Selenium Start");
//
//    }

//    @Test
//    public void filePickingTest(){
//        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
//        uploadFilePicker.sendKeys("/home/wkarpowicz/Downloads/Batman_50.jpg");
//        sleep();
//
//    }
//
    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void checkRadioButtonTest(){
//        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
//        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));
//
//        maleRadioButton.click();
//        sleep();
//        assertTrue(maleRadioButton.isSelected());
//        sleep();
//
//        femaleRadioButton.click();
//        sleep();
//        assertTrue(femaleRadioButton.isSelected());
//        sleep();
//        assertFalse(maleRadioButton.isSelected());
//        sleep();
//    }

//    @Test
//    public void checkboxButtonTest(){
//        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza'"));
//        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti'"));
//        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger"));
//
//        assertFalse(pizzaCheckbox.isSelected());
//        assertFalse(spaghettiCheckbox.isSelected());
//        assertFalse(hamburgerCheckbox.isSelected());
//        sleep();
//
//        pizzaCheckbox.click();
//        spaghettiCheckbox.click();
//        hamburgerCheckbox.click();
//        sleep();
//
//        assertTrue(pizzaCheckbox.isSelected());
//        assertTrue(spaghettiCheckbox.isSelected());
//        assertTrue(hamburgerCheckbox.isSelected());
//        sleep();
//
//        pizzaCheckbox.click();
//        spaghettiCheckbox.click();
//        hamburgerCheckbox.click();
//        sleep();
//
//        assertFalse(pizzaCheckbox.isSelected());
//        assertFalse(spaghettiCheckbox.isSelected());
//        assertFalse(hamburgerCheckbox.isSelected());
//        sleep();
//    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
