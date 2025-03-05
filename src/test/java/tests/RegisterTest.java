package tests;
import static constants.TestUtils.*;

import constants.TestUtils;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utulity.BaseTest;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;

        @Description("Register test for forceget than login with registered user.")
        @Test
        public void registerThanLoginTest() {
            registerPage = new RegisterPage(driver);

            registerPage.sendName(TestUtils.UserInfo.NAME)
                    .sendLastName(TestUtils.UserInfo.LAST_NAME)
                    .selectCountry(TestUtils.UserInfo.COUNTRY)
                    .sendPhoneNumber()
                    .sendCompanyName(TestUtils.UserInfo.COMPANY_NAME);
            String email = registerPage.sendMailAndReturnMailAddress();

            LoginPage loginPage = registerPage.selectTitle()
                    .sendPassword(TestUtils.UserInfo.PASSWORD)
                    .sendConfirmPassword(TestUtils.UserInfo.PASSWORD)
                    .approveTermsAndConditions()
                    .clickSignupButton()
                    .sendOtp(TestUtils.Otp.OTP)
                    .clickLoginButton();

            MainPage mainPage = loginPage.sendEmail(email)
                    .sendPassword(TestUtils.UserInfo.PASSWORD)
                    .clickSignInButton();

            Assert.assertTrue(mainPage.isMyAccountIconDisplayed());
        }
    }








