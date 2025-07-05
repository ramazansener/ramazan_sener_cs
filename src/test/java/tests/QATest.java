package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.CareersPage;
import pages.QaJobsPage;
import utils.Driver;
import java.util.List;

public class QATest {
    WebDriver driver;
    HomePage homePage;
    CareersPage careersPage;
    QaJobsPage qaJobsPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        qaJobsPage = new QaJobsPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test(description = "Verify that the home page opens successfully and the title information is correct.")
    public void shouldOpenHomePageAndCheckTitle() {
        homePage.goTo();
        Assert.assertEquals(driver.getTitle(), "#1 Leader in Individualized, Cross-Channel CX — Insider");
    }

    @Test(description = "Verify that by selecting Careers from the Company menu, the Careers page and its sub-blocks (Locations, Teams, Life at Company) are opened.")
    public void shouldNavigateToCareersAndCheckBlocksVisibility() {
        homePage.goTo();
        homePage.clickCompanyMenu();
        homePage.clickCareersMenu();
        Assert.assertTrue(careersPage.isTeamClosed(), "Team section should be closed, .loadmore not found!");
        Assert.assertTrue(careersPage.isLocationsVisible(), "Locations block is not visible!");
        Assert.assertTrue(careersPage.isLifeAtCompanyVisible(), "Life at Company block is not visible!");
    }

    @Test(description = "Verify that on the QA job listings page, the job listing is retrieved by filtering with Istanbul, Turkey and Quality Assurance.")
    public void shouldFilterQAJobsByLocationAndDepartment() throws InterruptedException {
        qaJobsPage.goTo();
        qaJobsPage.clickSeeAllQAJobs();

        Assert.assertEquals(qaJobsPage.departmentFilterContainsQA(), "Quality Assurance","Quality Assurance is not found in the department.");
        Assert.assertEquals(qaJobsPage.locationFilterContainsIstanbul(), "Istanbul, Turkiye","Istanbul, Turkey is not found in the location");
    }

    @Test(description = "Verify that the position, department and location information of the filtered job listings are correct.")
    public void shouldCheckAllFilteredJobsContainQAAndLocation() throws InterruptedException {
        qaJobsPage.goTo();
        qaJobsPage.clickSeeAllQAJobs();

        qaJobsPage.selectDepartmentQA();
        qaJobsPage.selectLocationIstanbul();

        List<WebElement> filteredJobs = qaJobsPage.getFilteredJobs();

        for (WebElement job : filteredJobs) {
            String department = qaJobsPage.getJobDepartment(job);
            String location = qaJobsPage.getJobLocation(job);
            
            Assert.assertEquals(department, "Quality Assurance");
            Assert.assertEquals(location, "Istanbul, Turkiye");
        }
    }

    @Test(description = "Verify that when the View Role button is clicked, it redirects to the Lever Application form page.")
    public void shouldRedirectToLeverApplicationFormWhenViewRoleClicked() throws InterruptedException {
        qaJobsPage.goTo();
        qaJobsPage.clickSeeAllQAJobs();
        
        qaJobsPage.selectDepartmentQA();
        qaJobsPage.selectLocationIstanbul();
        
        List<WebElement> filteredJobs = qaJobsPage.getFilteredJobs();
        Assert.assertTrue(filteredJobs.size() > 0);
        
        qaJobsPage.clickViewRoleButton(filteredJobs.get(0));
        
        qaJobsPage.switchToNewTab();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("jobs.lever.co"));
    }
} 