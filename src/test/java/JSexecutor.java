import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class JSexecutor {

   static WebDriver driver;

    @BeforeMethod
    public void BrowserSetup() {

        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
//       System.setProperty("webdriver.chrome.driver","C:\\Users\\rezo gokadze\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
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
        String text = (String) js.executeScript("return document.getElementById('zone2-entries').innerText;");
        if(text.equals("0 Entries")){
            System.out.println("0 Entries");
        }
        else {
            System.out.println("Not found");
        }

    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
