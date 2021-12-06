package pages.issues;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseAuthorizedPage;
import pages.BasePage;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class IssueCreationPage extends BaseAuthorizedPage {

    private final static String TITLE = "Страница создания ишьюса";

    public IssueCreationPage(WebDriver driver) {
        super(driver, TITLE);
    }

    private By issueTitleField = By.id("issue_title");
    private By issueBodyField = By.id("issue_body");
    //  private WebElement issueCreationButton = driver.findElement
    // (By.xpath("//button[contains(@class, 'btn-primary btn btn-block d-md-none mt-4')]"));
    private By issueCreationButton = By.xpath("//button[contains(@class, 'btn-primary btn btn-block d-md-none mt-4')]");
    private By lablesShowButton = By.id("labels-select-menu");
    private By issueLabels = By.xpath("//span[@class = 'name']");

    Actions actions = new Actions(driver);

    public IssueInfoPage createNewIssue(String title, String body, List<String> testLabels) {
        log.info("Создаем новое ишью");
        Assert.assertTrue(driver.findElement(issueTitleField).isDisplayed());
        driver.findElement(issueTitleField).sendKeys(title);
        log.info("тайтл введен");
        Assert.assertTrue(driver.findElement(issueBodyField).isDisplayed());
        driver.findElement(issueBodyField).sendKeys(body);
        log.info("боди введено");
        Assert.assertTrue(driver.findElement(lablesShowButton).isDisplayed());
        driver.findElement(lablesShowButton).click();
        log.info("кнопка для раскрытия списка кликнута");

        driver.findElements(issueLabels)
                .stream()
                .filter(label -> testLabels.contains(label.getText()))
                .forEach(WebElement::click);
                log.info("лейбла кликнута");

        driver.findElement(lablesShowButton).click();
        log.info("кнопка для раскрытия списка кликнута");

        // actions.moveToElement(issueCreationButton).perform();
        //log.info("кнопка криейт проскролена");
        //System.out.println(driver.manage().window().getSize());
        //driver.manage().window().setSize(new Dimension(2000, 2000));
        /*try {
            driver.wait(10000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

         */
        // issueCreationButton.sendKeys(Keys.chord(Keys.CONTROL, "50"));
        // driver.execute_script("document.body.style.zoom='zoom %'");
        // Assert.assertTrue(driver.findElement(issueCreationButton).isEnabled());
        //actions.moveToElement(issueCreationButton).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(issueCreationButton));
        driver.findElement(issueCreationButton).click();
        log.info("крией ишью кнопка кликнута");
        log.info("Ишью создано");
        return new IssueInfoPage(driver);


    }


}

