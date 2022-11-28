package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import page.objects.*;

import java.nio.charset.StandardCharsets;

import static org.testng.AssertJUnit.assertEquals;


public class BuyAndCheckoutTests extends TestBase{

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void asUserBuyAngelfish(){

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnCategoryFish();

        FishPage fishPage = new FishPage();
        fishPage.addAngelFishToCart();
        sleep();

        AngelFishPage angelFishPage = new AngelFishPage();
        angelFishPage.addAngelFishSmallToCart();
        sleep();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckoutButton();

        String warningMessage = shoppingCartPage.getWarningMessage();
        System.out.println(warningMessage);

        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");




    }
}
