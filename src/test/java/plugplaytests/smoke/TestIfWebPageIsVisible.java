package plugplaytests.smoke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static plugplaytests.domainobjects.WebPageContent.BOOKING;
import static plugplaytests.domainobjects.WebPageContent.PLUGPLAY_TITLE;
import static plugplaytests.domainobjects.WebPageContent.PRICING;
import static plugplaytests.domainobjects.WebPageURLs.MAIN_URL;

/**
 * Created by ER27 on 2016-05-20.
 */
public class TestIfWebPageIsVisible {

    private WebDriver driver;

    @BeforeClass
    public void openPlugPlayWebSiteViaFireFox() {

        driver = new FirefoxDriver();

        driver.navigate().to(MAIN_URL);
        driver.manage().window().maximize();
//DEBBUGER
//        String pageTitle = driver.getTitle();
//        System.out.println(pageTitle);

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PLUGPLAY_TITLE)));
    }

    @AfterClass
    public void closePlugPlayWebSite() {
        driver.close();
        driver.quit();
    }
// something to change again and again
    @Test
    public void checkIfBookingAndPricingButtonsAreClickable() {

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BOOKING)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PRICING)));

    }
}
