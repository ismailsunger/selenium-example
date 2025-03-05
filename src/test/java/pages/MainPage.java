package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulity.BasePage;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ant-avatar-icon")
    protected WebElement accountIcon;

    public Boolean isMyAccountIconDisplayed() {
        return isElementDisplayed(accountIcon);
    }
}
