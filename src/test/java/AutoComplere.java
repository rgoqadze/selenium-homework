import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AutoComplere {

    WebDriver driver;

    @BeforeClass
    public void BrowserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Suggestions() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input.gLFyf")).sendKeys("Automation");
        WebDriverWait wait = new WebDriverWait(driver,3);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='G43f7e']/li[last()]")).click();
    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
