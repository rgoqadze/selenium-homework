import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeClass
    public void BrowserSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void FileUploud() {
        driver.get("http://the-internet.herokuapp.com/upload ");
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\rezo gokadze\\Desktop\\gsxr 600\\jpj1.jpg");
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");
        try {
            upload.click();
        }
        catch (StaleElementReferenceException e) {
            System.out.println("Nooooooo" + e.getMessage());
        }

    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
