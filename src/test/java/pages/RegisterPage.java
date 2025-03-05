package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulity.BasePage;

import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.SplittableRandom;
import java.util.logging.XMLFormatter;
import java.util.stream.Stream;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@id='firstName']")
    protected WebElement sendNameLocator;

    @FindBy(xpath = "//input[@id='lastName']")
    protected WebElement sendLastNameLocator;

    @FindBy(id = "phoneNumber")
    protected WebElement phoneNumberLocator;

    @FindBy(xpath = "//input[@id='companyName']")
    protected WebElement companyNameLocator;

    @FindBy(xpath = "//input[@type='email']")
    protected  WebElement sendMailLocator;

    @FindBy(xpath = "//input[@autocomplete='new-password']")
    protected WebElement sendPasswordLocator;

    @FindBy(xpath = "//input[@placeholder='Confirm password']")
    protected WebElement sendConfirmPasswordLocator;

    @FindBy(xpath = "//span[@class='checkbox-box']")
    protected WebElement checkBoxLocator;

    @FindBy(xpath = "//button//span[contains(text(), 'Accept')]")
    protected  WebElement acceptButtonLocator;

    @FindBy(className = "ant-select-selection-search-input")
    protected List<WebElement> inputFields;

    @FindBy(className = "ant-select-item-option-content")
    protected WebElement option;

    @FindBy(xpath = "//span[contains(text(), ' Sign-Up')]")
    protected WebElement signupButton;

    @FindBy(css = "input.otp-input")
    protected List<WebElement> otpInputs;

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    protected WebElement loginButton;






    public RegisterPage sendName(String name){
        sendTextToElement(sendNameLocator,name);
        return this;
    }

    public RegisterPage sendLastName(String lastName){
        sendTextToElement(sendLastNameLocator,lastName);
        return this;
    }

    public RegisterPage sendPhoneNumber(){
        sendTextToElement(phoneNumberLocator ,generatePhoneNumber());
        return this;
    }

    public RegisterPage sendCompanyName(String companyName){
        sendTextToElement(companyNameLocator,companyName);
        return this;
    }


    public String sendMailAndReturnMailAddress() {
        String email = generateRandomMail();
        sendTextToElement(sendMailLocator,email );
        return email;
    }


    public RegisterPage sendPassword(String password){
        sendTextToElement(sendPasswordLocator,password);
        return this;
     }

     public RegisterPage sendConfirmPassword(String password){
        sendTextToElement(sendConfirmPasswordLocator,password);
        return this;
     }

    public RegisterPage approveTermsAndConditions() {
        Stream.of(checkBoxLocator, acceptButtonLocator).forEach(element -> {
            clickByElement(element);
            wait(2);
        });
        return this;
    }

    public RegisterPage selectCountry(String text) {
        sendTextToElement(inputFields.get(0), text);
        clickByElement(option);
        return this;
    }

    public RegisterPage selectTitle() {
        Stream.of(inputFields.get(1), option).forEach(element -> {
            wait(2);
            clickByElement(element);

        });

        return this;
    }

    public RegisterPage clickSignupButton() {
        clickByElement(signupButton);
        return this;
    }

    public RegisterPage sendOtp(String otp) {
        for (int i = 0; i < otpInputs.size(); i++) {
            otpInputs.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
        return this;
    }

    public LoginPage clickLoginButton() {
        clickByElement(loginButton );
        return new LoginPage(driver);
    }





}
