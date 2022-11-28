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

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void fileUploadTest(){
        WebElement upLoad = driver.findElement(By.id("file-upload"));
        upLoad.sendKeys("/home/wkarpowicz/Downloads/testfile.txt");
        sleep();

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String upFile = uploadedFiles.getText();
        assertEquals(uploadedFiles.getText(),"testfile.txt");

        System.out.println(upFile);


//        assertEquals(upLoad.getText(),"testfile.txt");



    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
