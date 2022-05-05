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
        WebDriver driver = new ChromeDriver();
    }


    @Test
    public void WebElementsHomework() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");


        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }
        System.out.println(driver.findElement(By.xpath("//*[@id='elements']/button[3]")).getText());
        List<WebElement> elements = driver.findElements(By.cssSelector("button[class*='added']"));
        for (WebElement Listelements : elements) {
            String ElementText =  Listelements.getText();
            System.out.println(Listelements);
        }

        String element1 = driver.findElement(By.xpath("//*[contains(@class,'manually' and text()='Delete']/button[3]")).getText();
        System.out.println(element1);
        //driver.quit();

    }

    @Test
    public void ElementsHomeWork() {
       /* WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();*/
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();

        String element1 =  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]//preceding-sibling::tr[1]")).getText();
        System.out.println(element1);
        String element2 =  driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]//folowing-sibling::tr[3]")).getText();
        System.out.println(element2);

        //driver.quit();




    }

    @BeforeClass
    public void TearDowun() {
        driver.quit();
    }


}
