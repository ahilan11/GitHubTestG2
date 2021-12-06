package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;
import pages.issues.IssueInfoPage;
import pages.issues.IssuesPage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.FileHelper.readDataFromFile;

@RunWith(Parameterized.class)
public class IssueCreationTest extends BaseTest {

    private IssuesPage page;

    private String title;
    private String body;
    private List<String> labels;

    public IssueCreationTest(String title, String body, List<String> labels) {
        this.title = title;
        this.body = body;
        this.labels = labels;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return readDataFromFile("D:\\Projects\\GitHubTestProject\\src\\test\\resources\\Data\\issues.txt");
    }

    @Before
    public void signIn() {
        page = new LoginPage(driver)
                .login(System.getProperty("login"),System.getProperty("password"))
                .openOurProject()   //   или .searchProject("GitHubTestG2"), возвр тип ProjectPage
                .openProjectIssues();
    }

    @Test
    public void checkIssueCreation(){

       page.pressToCreateNewIssue()
               .createNewIssue(this.title, this.body, this.labels)
                .validateCreatedIssue(this.title, this.body, this.labels);
    }

    @After
    public void tearDown() {
        page.logOut()
                .validateLogOut();
    }
}
