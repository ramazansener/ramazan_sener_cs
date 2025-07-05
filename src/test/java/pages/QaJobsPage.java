package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;

public class QaJobsPage extends BasePage {
    private By seeAllQAJobs = By.linkText("See all QA jobs");
    private By jobsListContainer = By.id("career-position-list");
    private By locationComboBox = By.id("select2-filter-by-location-container");
    private By locationSelected = By.xpath("//span[@id='select2-filter-by-location-container' and @role='textbox']");
    private By departmentSelected = By.xpath("//span[@id='select2-filter-by-department-container' and @role='textbox']");
    private By istanbulOptionLi = By.cssSelector("li[id^='select2-filter-by-location-result'][id$='Istanbul, Turkiye']");
    private By qaOptionLi = By.cssSelector("li[id^='select2-filter-by-department-result'][id$='Quality Assurance']");
    private By positionListItems = By.cssSelector(".position-list-item.qualityassurance.istanbul-turkiye");
    private By jobDepartment = By.cssSelector(".position-department");
    private By jobLocation = By.cssSelector(".position-location");
    private By positionListItemsWrapper = By.cssSelector(".position-list-item-wrapper");
    private By viewRoleBtn = By.linkText("View Role");

    public QaJobsPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        acceptCookies();
    }

    public void clickSeeAllQAJobs() {
        driver.findElement(seeAllQAJobs).click();
        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(jobsListContainer));
    }

    public void selectLocationIstanbul() throws InterruptedException {
        WebDriverWait wait = getWait(10);
        WebElement comboBox = wait.until(ExpectedConditions.elementToBeClickable(locationSelected));

        // Scroll to the bottom of the page
        scrollToBottom();
        Thread.sleep(2000);

        // Scroll to the top of the page
        scrollToTop();
        Thread.sleep(2000);

        comboBox.click();

        WebElement istanbulLi = wait.until(ExpectedConditions.visibilityOfElementLocated(istanbulOptionLi));
        istanbulLi.click();
    }

    public void selectDepartmentQA() throws InterruptedException {
        WebDriverWait wait = getWait(10);
        WebElement comboBox = wait.until(ExpectedConditions.elementToBeClickable(departmentSelected));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(departmentSelected, "Quality Assurance"));
        comboBox.click();
        WebElement qaLi = wait.until(ExpectedConditions.visibilityOfElementLocated(qaOptionLi));
        qaLi.click();
    }

    public String locationFilterContainsIstanbul() throws InterruptedException {
        WebDriverWait wait = getWait(10);
        WebElement comboBox = wait.until(ExpectedConditions.elementToBeClickable(locationSelected));
        scrollToBottom();
        Thread.sleep(2000);
        scrollToTop();
        Thread.sleep(2000);
        comboBox.click();
        WebElement istanbulLi = wait.until(ExpectedConditions.visibilityOfElementLocated(istanbulOptionLi));
        String text = istanbulLi.getText();
        istanbulLi.click();
        return text;
    }

    public String departmentFilterContainsQA()  {
        WebDriverWait wait = getWait(10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(departmentSelected, "Quality Assurance"));
        WebElement comboBox = wait.until(ExpectedConditions.elementToBeClickable(departmentSelected));
        comboBox.click();
        WebElement qaLi = wait.until(ExpectedConditions.visibilityOfElementLocated(qaOptionLi));
        return qaLi.getText();
    }
    
    public List<WebElement> getFilteredJobs() {
        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(positionListItems));
        return driver.findElements(positionListItems);
    }
    
    public String getJobDepartment(WebElement jobElement) {
        return jobElement.findElement(jobDepartment).getText();
    }
    
    public String getJobLocation(WebElement jobElement) {
        return jobElement.findElement(jobLocation).getText();
    }
    
    public void clickViewRoleButton(WebElement jobElement) {
        WebDriverWait wait = getWait(10);
        WebElement wrapper = jobElement.findElement(By.cssSelector(".position-list-item-wrapper"));
        Actions actions = new Actions(driver);
        actions.moveToElement(wrapper).perform();
        WebElement viewRoleBtn = wrapper.findElement(By.cssSelector("a.btn.btn-navy.rounded.pt-2.pr-5.pb-2.pl-5"));
        wait.until(ExpectedConditions.elementToBeClickable(viewRoleBtn));
        viewRoleBtn.click();
    }

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
} 