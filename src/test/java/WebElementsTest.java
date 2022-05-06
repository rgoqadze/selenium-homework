import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class WebElementsTest {
    WebDriver driver;

    @BeforeClass
    public void BrowserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Test
    public void WebElementsHomework() {

        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }
        System.out.println(driver.findElement(By.xpath("//*[@id='elements']/button[last()]")).getText());

        List<WebElement> elements = driver.findElements(By.cssSelector("button[class*='added']"));
        elements.size();
        WebElement lastdelete = elements.get(1);
        System.out.println(lastdelete.getText());


        String element1 = driver.findElement(By.xpath("//button[contains(@class,'manually') and (text()='Delete')][last()]")).getText();
        System.out.println(element1);
    }

    @Test
    public void ElementsHomeWork() {

        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();

        WebElement loremValue = driver.findElement(By.xpath("//td[text()='Apeirian9']/preceding-sibling::td"));
        System.out.println(loremValue.getText());
        WebElement nextElement = driver.findElement(By.xpath("//td[text()='Apeirian9']/following-sibling::td"));
        System.out.println(nextElement.getText());
    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
