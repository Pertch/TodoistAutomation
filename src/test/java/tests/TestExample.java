package tests;

import api.HttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import steps.LoginStep;

public class TestExample extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    TaskPage taskPage;
    LoginStep loginStep;
    SettingsPage settingsPage;

    @BeforeMethod
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        projectPage = new ProjectPage(driver);
        taskPage = new TaskPage(driver);
        loginStep = new LoginStep(driver);
        settingsPage = new SettingsPage(driver);
    }
    @Test
    public void test1() throws InterruptedException {
        HttpClient.createProjct();
        loginStep.login();
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        Assert.assertTrue(homePage.checkProject("Project1"),"Project isn't present");
    }

    @Test
    public void test2() throws InterruptedException {
        loginStep.login();
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        homePage.clickProject("Project1");
        projectPage.clickFabButton();
        projectPage.setTaskName("Task1");
        projectPage.clickSendButton();
        projectPage.clickBackButton();

        HttpClient.checkTask("Task1");
    }

    @Test
    public void test3() throws InterruptedException {
        loginStep.login();
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        homePage.clickProject("Project1");
        projectPage.clickTask("Task1");
        taskPage.clickCompleteButton();


        HttpClient.uncompleteTask();

        homePage.clickBurgerMenu();

        homePage.clickSettings();

        try {
            settingsPage.scroll();
            settingsPage.clickLogOutButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
        settingsPage.clickLogoutYesButton();

        loginStep.login();
        homePage.clickBurgerMenu();
        homePage.clickProjectsDownButton();
        homePage.clickProject("Project1");
        Assert.assertTrue(projectPage.checkTask("Task1"),"Task isn't present");

    }

}
