package driver;

import driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;
import static driver.BrowserType.FIREFOX;

public class DriverManager {
        //private static WebDriver driver;

        //1. Utworzenie zmiennej webDriverThreadLocal
        //2. Dwie zmiennej instancj klasy ThreadLocal przechowujące kolejno instancję obiektu WebDriver oraz BrowserType dla danego wątku
        private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
        private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();
        private DriverManager(){
        }

        //Metoda służy od ustawiania typu przeglądarki dla danego wątku
        public static void setWebDriver(BrowserType browserType){
            //Obiekt typu WebDriver, który w kolejnych liniach zostanie zainicjalizowany wywołaniem metody getBrowser() z klasy BrowserFactory
            WebDriver browser = null;

            //Jeśli obiekt browserType będzie nullem, wtedy dla danego wątku zostanie wybrana przeglądarka zdefiniowana
            // w pliku configuration.properties
            if (browserType == null){

                //Utworzenie instancji WebDrivera dla opcji gdy browserType jest nullem
                //Zostanie wtedy wybrana przeglądarka zdefiniowana w pliku configuration.properties
                browserType = getBrowserToRun();
                browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
            } else {
                //Utworzenie instancji WebDrivera dla opcji gdy browserType nie jest nullem
                //To znaczy, że został on zdefiniowany w pliku TestNG XML i możemy go używać
                browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();

            }
            //Rejestracja obiektu WebDrivera
            browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);
            //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy BrowserType
            browserTypeThreadLocal.set(browserType);

            //Dodanie do puli instancji ThreadLocal za pomocą metody set() instancji klasy WebDriver
            webDriverThreadLocal.set(browser);


        }
        public static WebDriver getWebDriver(){

            //Sprawdzenie czy wartość zmiennej WebDrivera dla danego wątku jest nullem
            if (webDriverThreadLocal.get() == null){

                //Rzucenie wyjątku IllegalStateException w sytuacji gdy dla danego wątku instancja przeglądarki nie została
                // poprawnie zainicializowana metodą setWebDriver
                throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");

                //Wywołanie metody getBrowser() z klasy BrowserFactory zwraca instancję WebDrivera, który następnie jest
                // dodana do puli instancji klasy ThreadLocal za pomocą metody set()
                //webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(),getIsRemoteRun()).getBrowser());
            }

            //Zwrócenie instancji WebDrivera dla danego wątku
            return webDriverThreadLocal.get();
        }

        public static void disposeDriver(){

            //Wywołanie metody close() z klasy WebDriver dla danego wątku
            webDriverThreadLocal.get().close();

            //Sprawdzenie czy dla danego wątku przeglądarka to Firefox
            if (!browserTypeThreadLocal.get().equals(FIREFOX)){

                //Wywołanie metody quit() z klasy WebDriver dla danego wątku
                webDriverThreadLocal.get().quit();
            }
            //Usunięcie zmiennych typu BrowserType oraz WebDriver dla danego wątku

            //Wywołanie metody remove() z klasy ThreadLocal dla danego wątku w celu usunięcia WebDrivera dla aktualnego wątku
            webDriverThreadLocal.remove();
            browserTypeThreadLocal.remove();
        }
}