
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CommandsTest {

    @Test
    public void Seleniumhomework() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();
        sleep(5000);
        driver.findElement(By.cssSelector("#input-example > input[type=text]")).isEnabled();
        driver.getPageSource().contains("It's enabled!");
        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).getText().contains("Disable");
        driver.findElement(By.cssSelector("#input-example > input[type=text]")).sendKeys("Bootcamp");
        sleep(1000);
        driver.findElement(By.cssSelector("#input-example > input[type=text]")).clear();
        driver.quit();
    }

    @Test
    public void GetLocation() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        int element1 = driver.findElement(By.id("column-a")).getLocation().getY();
        int element2 = driver.findElement(By.id("column-b")).getLocation().getY();
        Assert.assertEquals(element1, element2);
        driver.quit();






    }
}
