import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieTest {
    WebDriver driver;

    @BeforeClass
    public void BrowserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void CookieDelete() {
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("button[name='submit']")).click();
        driver.navigate().refresh();
        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie seleniumcookie = driver.manage().getCookieNamed("Selenium");
        for (Cookie ck : cookies) {
            driver.manage().deleteCookie(seleniumcookie);
        }
    }

    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
