package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulity.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement sendMailLocator;

    @FindBy(xpath = "//input[@placeholder='Password']")
    protected WebElement passwordInput;

    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    protected WebElement signInButton;

    public LoginPage sendEmail(String email) {
        sendTextToElement(sendMailLocator,email );
        return this;
    }

    public LoginPage sendPassword(String password) {
        sendTextToElement(passwordInput, password);
        return this;
    }

    public MainPage clickSignInButton() {
        clickByElement(signInButton);
        return new MainPage(driver);
    }
}
