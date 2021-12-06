package pages.issues;

import helpers.Level;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;

import static helpers.ColorPrinter.printColorMessage;


public class IssueInfoPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница информации о задаче";

    public IssueInfoPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private final By title1 = By.xpath("//span[@class='js-issue-title markdown-title']");
    private final By statusImage = By.xpath("//div[contains(@class, 'flex-md-self-center')]/span");
    private final By description = By.xpath("//td[contains(@class, 'js-comment-body')]");
    private final By labels = By.xpath("//*[@class = 'IssueLabel hx_IssueLabel d-inline-block v-align-middle']");

    public IssueInfoPage validateCreatedIssue(String titleText, String body, List<String> testLabels){
        printColorMessage("Проверяем создание ишью", log, Level.INFO);
        try {
            log.debug("Проверяем заголовок задачи");
            Assert.assertEquals(titleText, driver.findElement(title1).getText());
            Assert.assertTrue(driver.findElement(statusImage).isDisplayed());
            Assert.assertEquals(body, driver.findElement(description).getText());
            log.debug("Проверяем боди задачи");
            driver.findElements(labels).forEach(label -> {
                log.debug("Проверяем метку: " + label.getText());
                Assert.assertTrue(testLabels.contains(label.getText()));
                testLabels.remove(label.getText());
            });

            //Assert.assertTrue(testLabels.isEmpty());
        } catch (NoSuchElementException n){
            Assert.fail("Задача создана не корректно: " + n.getMessage());
        }
        printColorMessage("Данные проверены. Задача успешно создана", log, Level.INFO);
        return this;

    }
}
