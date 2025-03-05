package utulity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.stream.IntStream;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickByElement(WebElement element){
        element.click();
    }

    public void sendTextToElement(WebElement element,String text){
        element.click();
        element.sendKeys(text);
    }

    public String generatePhoneNumber(){
        Random random = new Random();

        int areaCode = 5 + random.nextInt(10);
        int secondDigit = 100000000 + random.nextInt(900000000);

        return String.format("0%d %03d %02d %02d", areaCode, secondDigit / 1000000, (secondDigit / 10000) % 100, secondDigit % 10000);
    }

    public String generateRandomMail(){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder username = new StringBuilder();

        Random random = new Random();
        IntStream.range(0, 10).forEach(index -> {
            index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        });

        return username + "@" + "gmail.com";
    }

    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void wait(int second)
    {
        try {
            Thread.sleep(second*1000);
        }
        catch (Exception e)
        {
            System.out.println("Error occured while sleeping "+ e);
        }

    }


}
