import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SwitchToTest {

    WebDriver driver;

    @BeforeClass
    public void BrowserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void SwitchTo() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");
        WebElement input = driver.findElement(By.id("tinymce"));
        input.click();
        input.clear();
        input.sendKeys("Here Goes");
        System.out.println(input.getText());
        driver.switchTo().defaultContent();
        WebElement alignecentre = driver.findElement(By.cssSelector("button[title='Align center']"));
        alignecentre.click();
        alignecentre.isSelected();

    }
    @Test
    public void Alerts() {

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();


    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
