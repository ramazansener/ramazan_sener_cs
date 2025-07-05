package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {
    private WebDriver driver;
    private By teamLoadMore = By.cssSelector(".loadmore");
    private By locationsBlock = By.className("glide__track");
    private By lifeAtCompanyBlock = By.className("elementor-carousel-image");


    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTeamClosed() {
        return driver.findElements(teamLoadMore).size() > 0;
    }

    public boolean isLocationsVisible() {
        return driver.findElements(locationsBlock).size() > 0 &&
               driver.findElement(locationsBlock).isDisplayed();
    }

    public boolean isLifeAtCompanyVisible() {
        return driver.findElements(lifeAtCompanyBlock).size() > 0;
    }
} 