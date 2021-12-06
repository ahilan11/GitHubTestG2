package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collection;

import static helpers.ColorPrinter.printMessageInYellow;
import static helpers.FileHelper.readAuthDataFromFile;

@RunWith(Parameterized.class)
public class LoginNegativeTest extends BaseTest {

    private LoginPage page;
    private String errorMessage;
    private String invalidMessage = "Incorrect username or password.";

    private String login;
    private String password;

    public LoginNegativeTest(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection<String[]> data(){
        return readAuthDataFromFile("D:\\Projects\\GitHubTestProject\\src\\test\\resources\\Data\\authData.txt");
    }

    @Before
    public void setPage() {
        printMessageInYellow("===Тест Начат====");
        this.page = new LoginPage(driver);
        this.errorMessage = "There have been several failed attempts " +
                "to sign in from this account or IP address." +
                " Please wait a while and try again later.";
    }

    @Test
    public void negativeAuthTest() {

            page.checkAuthFields()
                    //todo Уведомить разработчиков. Кейс нестандартого поведения системы
                    //     .loginNegative("admin", "admin")
                    //     .validateErrorMessage(errorMessage, true)
                    //   .returnToLoginPage()
                    .loginNegative(this.login, this.password)
                    .validateErrorMessage(invalidMessage);
            driver.findElement(By.id("login"));
        }

        

    @Test
    public void showSystemVars() {
    System.out.println(System.getProperty("login"));
    System.out.println(System.getProperty("password"));
    }

    @After
    public void tearDown() {
        printMessageInYellow("===Тест Закончен====");
    }

}
