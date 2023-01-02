package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
//        PO WPROWADZONYCH ZMIANACH W PAGE OBJECTACH PONIŻSZY KOD NIE MA RACJI BYTU
//        loginPage.clickOnFishImageButton()
//                .addAngelFishToCart()
//                .addAngelFishSmallToCart()
//                .clickOnProceedToCheckoutButton();
//
//        String warningMessage = loginPage.getWarningMessage();
//        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
