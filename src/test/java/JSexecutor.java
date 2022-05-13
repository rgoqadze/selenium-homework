import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.crypto.dom.DOMCryptoContext;

import static java.lang.Thread.sleep;

public class JSexecutor {

    WebDriver driver;
    private DOMCryptoContext document;

    @BeforeClass
    public void BrowserSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void ItemDelete() throws InterruptedException {

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]"));
        Actions  actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        WebElement delete = driver.findElement(By.cssSelector("#container > ul > li:nth-child(3)"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;",delete);



    }
    @Test
    public void Scroll() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        WebElement entries = driver.findElement(By.id("zone2-entries"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",entries);
        //String text = js.executeScript("return document.getElementById('zone2-entries').value").toString();
        //System.out.println(text);





    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
