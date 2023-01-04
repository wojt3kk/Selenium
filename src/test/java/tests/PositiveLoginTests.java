package tests;

import driver.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationsURLs.LOGIN_URL;

public class PositiveLoginTests extends TestBase {

    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
//        boolean isBannerAfterLoginDisplayed =
        loginPage
                .typeIntoUserNameField("j2eea")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerIsDisplayed();
//                .isBannerAfterLoginDisplayed();
//
//        assertTrue(isBannerAfterLoginDisplayed);
    }

}