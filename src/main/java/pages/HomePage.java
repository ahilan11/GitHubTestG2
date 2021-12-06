package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final static String TITLE = "Домашнаяя не авторизованная страница";


    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By titleMessage = By.xpath("//h1[@class = 'h1-mktg color-text-white mb-3 position-relative z-2']");

    public void validateLogOut() {
        Assert.assertTrue(driver.findElement(titleMessage).isDisplayed());
        Assert.assertEquals("Where the world builds software", driver.findElement(titleMessage).getText());
    }
}
