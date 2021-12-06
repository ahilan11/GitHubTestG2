package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseAuthorizedPage extends BasePage {


    public BaseAuthorizedPage(WebDriver driver, String title) {
        super(driver, title);
    }
//Search field
    //fixme
    private final By searchField = By.xpath("//input[@data-scoped-placeholder = 'Search or jump to…']");
    private final By searchResults = By.xpath("//li[contains(@class, 'jump-to-suggestion')]");
    //User dropdown
    private final By userProfileButton = By.xpath("//summary[@aria-label = 'View profile and more']");
    private final By signOutButton = By.xpath("//button[contains(text(), 'Sign out')]");

    public ProjectPage searchProject (String projectName) {
        driver.findElement(searchField).click();
        driver.findElement(searchField).sendKeys(projectName);
        try {
            Thread.sleep(500); //ждем пока элементы подтянутся в списке
        } catch (InterruptedException e) {
            log.error(e);
        }
        driver.findElements(searchResults)
                .get(1)
                .click();
        return new ProjectPage(driver);
    }

    public HomePage logOut() {
        driver.findElement(userProfileButton).click();
        driver.findElement(signOutButton).click();
        return new HomePage(driver);
    }


}
