import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsTest {
    @Test
    public void WaitsHomework() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.findElement(By.id("startStopButton")).click();
        WebDriverWait wait = new WebDriverWait(driver,60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resetButton")));
        if (element.isDisplayed()){
            System.out.println("Progress Bar Displayd 100%");
        }
        else {
            System.out.println("Progres Bar is not Displayd");
        }

        driver.quit();
    }
}
