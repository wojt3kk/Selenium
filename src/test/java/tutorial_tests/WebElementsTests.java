package tutorial_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/home/wkarpowicz/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
//        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
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
//
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

//    @Test
//    public void dropDownListingTest() {
//        WebElement countryWebElement = driver.findElement(By.id("country"));
//        Select countryDropDown = new Select(countryWebElement);
//
//        List<WebElement> options = countryDropDown.getOptions();
//        List<String> namesOfOptions = new ArrayList<>();
//
//        for (WebElement option : options) {
//            namesOfOptions.add(option.getText());
//            System.out.println(option.getText());
//        }
//    List<String> expectedNamesOfOptions = new ArrayList<>();
//        expectedNamesOfOptions.add("Germany");
//        expectedNamesOfOptions.add("Poland");
//        expectedNamesOfOptions.add("UK");
//
//        sleep();
//
//        assertEquals(namesOfOptions,expectedNamesOfOptions);
//
//
//     }

//    @Test
//    public void selectingOptionsFromDropDownTest(){
//
//        WebElement countryWebElement = driver.findElement(By.id("country"));
//        Select countryDropDown = new Select(countryWebElement);
//        sleep();
//
//        countryDropDown.selectByIndex(1);
//        sleep();
//
//        assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Poland");
//
//        countryDropDown.selectByValue("de_DE");
//
//        sleep();
//
//        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");
//
//        sleep();
//
//        countryDropDown.selectByVisibleText("UK");
//        sleep();
//        assertEquals(countryDropDown.getFirstSelectedOption().getText(),"UK");
//
//    }

//    @Test
//    public void checkIfElementsOnPageTest(){
//        WebElement usernameField = driver.findElement(By.id("username"));
//        WebElement passwordField = driver.findElement(By.id("password"));
//        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block'"));
//
//        System.out.println("Is usernameField displayed:" + usernameField.isDisplayed());
//        System.out.println("Is usernameField enabled:" + usernameField.isEnabled());
//
//        System.out.println("Is passwordFiels displayed:" + passwordField.isDisplayed());
//        System.out.println("Is passwordField enabled:" + passwordField.isEnabled());
//
//        System.out.println("Is emailLabel displayed:" + emailLabel.isDisplayed());
//        System.out.println("Is emailLabel enabled:" + emailLabel.isEnabled());
//
//        assertTrue(usernameField.isDisplayed());
//        assertTrue(passwordField.isDisplayed());
//        assertTrue(emailLabel.isDisplayed());
//
//        assertTrue(usernameField.isEnabled());
//        assertFalse(passwordField.isEnabled());
//
//    }

    @Test
    public void hoverOverAndClickAndHoldTest() {
        WebElement smileyicon = driver.findElement(By.id("smiley"));
//        WebElement smileyicon2 = driver.findElement(By.id("smiley2"));

        Actions action = new Actions(driver);
        action.moveToElement(smileyicon).click().build().perform();
        sleep();

        Actions secondAction = new Actions(driver);
        WebElement smileyicon2 = driver.findElement(By.id("smiley2"));
        secondAction.moveToElement(smileyicon2).build().perform();

        sleep();

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
