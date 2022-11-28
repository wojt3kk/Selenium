package driver;

import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {
        private static WebDriver driver;
        private DriverManager(){

        }

        public static WebDriver getWebDriver(){

            if (driver == null){
                driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
            }
            return driver;
        }

        public static void disposeDriver(){
            driver.close();
            if (!getBrowserToRun().equals(BrowserType.FIREFOX)){
                driver.quit();
            }
            driver = null;
        }
}