import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ClientInfoStatus;
import java.util.List;

public class WebTablesTest {
    WebDriver driver;

    @BeforeClass
    public void BrowserSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Table() {
        driver.get("http://techcanvass.com/Examples/webtable.html");

        WebElement table = driver.findElement(By.id("t01"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowscount = rows.size();
        for (int i = 0; i < rowscount; i++){
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            int columnscount = columns.size();

            for(int j = 0; j <columnscount; j++){
                String cellText = columns.get(j).getText();
                if (cellText.equals("Honda")) {
                    System.out.println("Honda's Value is:" + columns.get(2).getText());
                }

            }

        }
    }
    @AfterClass
    public void TearDowun() {

        driver.quit();
    }
}
