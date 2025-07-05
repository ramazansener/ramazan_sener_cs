package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By companyMenu = By.xpath("//a[contains(text(),'Company')]");
    private By careersMenu = By.xpath("//a[contains(text(),'Careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("https://useinsider.com/");
        acceptCookies();
    }

    public void clickCompanyMenu() {
        driver.findElement(companyMenu).click();
    }

    public void clickCareersMenu() {
        driver.findElement(careersMenu).click();
    }
} 