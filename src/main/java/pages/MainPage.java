package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printMessageInYellow;

public class MainPage extends BaseAuthorizedPage {

    private final static String TITLE = "Основная страница GitHub";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By successTitle = By.xpath("//h3[@class = 'text-normal']");

    public void validateLogin() {
        printMessageInYellow("Проверяем успешность авторизации", log);
        Assert.assertTrue("Не удалось авторизироваться в приложении",
                driver.findElement(successTitle).isDisplayed());
        Assert.assertNotEquals("Сообщение изменено, проверка не пройдена",
                "Learn Git and GitHub without any code!",
                        driver.findElement(successTitle));
        printMessageInYellow("Успешно!", log);
    }

    public ProjectPage openOurProject(){
        driver.get("https://github.com/Auroraa0/GitHubTestG2");
        return new ProjectPage(driver);
    }
}
