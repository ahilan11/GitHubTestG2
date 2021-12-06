package pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static helpers.ColorPrinter.printColorMessage;
import static helpers.ColorPrinter.printMessageInYellow;
import static helpers.Level.INFO;
//import static jdk.internal.org.jline.utils.InfoCmp.Capability.byName;

public class LoginPage extends BasePage {

    private final static String TITLE = "Страница авторизации";

    private By loginField = By.id("login_field");
    private By passwordField = By.id("password");
    private By signInButton = By.name("commit");
    private final By errorMessage = By.xpath("//div[@id = 'login']/p");
    private final By message = By.xpath("//div[contains(@class, 'container-lg px-')]");


    private SelenideElement login = $(byId("login_field"));
    private SelenideElement password = $(byId("password"));
    private SelenideElement loginIn = $(byName("commit"));

    public LoginPage(WebDriver driver) {
        super(driver, TITLE);

    }

    public MainPage login(String login, String password){
        printColorMessage("Проводится авторизация в приложение", log, INFO);
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        printColorMessage("авторизация успешна", log, INFO);
        return new MainPage(driver);
    }

    public LoginPage loginNegative(String login, String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);

    }

    public LoginPage validateErrorMessage(String message, boolean isAdmin){
        Assert.assertEquals(message, driver.findElement(errorMessage).getText());
        return this;
    }

    public LoginPage validateErrorMessage(String message){
        Assert.assertEquals(message, driver.findElement(this.message).getText());
        return this;
    }

    public LoginPage returnToLoginPage(){
        driver.navigate().back();
        return new LoginPage(driver);
    }
    public LoginPage checkAuthFields() {
        printColorMessage("Валидируются поля для авторизыции", log, INFO);
        Assert.assertTrue("поле логин видно", driver.findElement(loginField).isDisplayed());
      Assert.assertTrue("поле пароль видно", driver.findElement(passwordField).isDisplayed());
      Assert.assertTrue("кнопка войти видна", driver.findElement(signInButton).isDisplayed());
        printColorMessage("Поля валидны!", log, INFO);
        return this;
      //  login.shouldBe(Condition.hidden).sendKeys("login");
    }


}
