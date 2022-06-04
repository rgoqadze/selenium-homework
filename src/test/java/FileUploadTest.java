import com.gargoylesoftware.htmlunit.BrowserVersion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest {


    @BeforeMethod
    public void BrowserSetup() {

       /* WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();*/
//        WebDriver driver = new HtmlUnitDriver(true);
    }

    @Test
    public void FileUploud() {
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);

        driver.get("http://the-internet.herokuapp.com/upload ");
        File path = new File("src/test/resources/6b07ae6d-5096-4671-8b99-249eb8f89858.jpg");
        driver.findElement(By.id("file-upload")).sendKeys(path.getAbsolutePath());
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

       //driver.quit();
    }
}
