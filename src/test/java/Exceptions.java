import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class Exceptions {
    WebDriver driver;

    @BeforeClass
    public void BrowserSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void DatePicker() throws InterruptedException {
        driver.get("https://jqueryui.com/datepicker/ ");
        driver.switchTo().frame(0);

        try {
            driver.switchTo().frame(0);
        } catch (NoSuchFrameException e) {
            System.out.println(e.getMessage());
        }

        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
        WebElement WebTable = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody"));
        List<WebElement> rows = WebTable.findElements(By.tagName("td"));
        int rowscount = rows.size();
        for (int i = 0; i < rowscount; i++) {
            String row = rows.get(i).getText();
            if (row.equals("30")) {
                rows.get(i).click();
            }

        }

    }

    @Test
    public void TimeOutExeption() {
        driver.get("https://demoqa.com/alerts ");

        WebElement element = driver.findElement(By.id("timerAlertButton"));
        element.click();

        try {
            new WebDriverWait(driver, 4).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println(e.getMessage());
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }
        driver.switchTo().defaultContent();

        try {
            element.click();
            driver.get(driver.getCurrentUrl());
            element.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale elemet" + e.getMessage());
        }


    }
    @AfterClass
    public void TearDowun() {

        driver.quit();
    }

}

