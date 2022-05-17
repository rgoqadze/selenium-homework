import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
    }

    @Test
    public void GetLocation() {
        driver.get(" http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        int element1 = driver.findElement(By.id("column-a")).getLocation().getY();
        int element2 = driver.findElement(By.id("column-b")).getLocation().getY();
        Assert.assertEquals(element1, element2);
        driver.quit();
    }
    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
