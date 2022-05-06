import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    @Test
    public void WebFormsHomework() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("dropdowm-menu-1"));
        Select langunage = new Select(element);
        langunage.selectByValue("sql");
        if (element.getText().contains("SQL")) {
            System.out.println("element is Displayd");
        } else {
            System.out.println("element is not Displayd");
        }
        List<WebElement> options = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement seleniumoptions : options) {
            if (!seleniumoptions.isSelected())
                seleniumoptions.click();
        }

        driver.findElement(By.xpath("//*[@id=\"radio-buttons\"]/input[3]")).click();
        WebElement options1 = (WebElement) driver.findElements(By.xpath("//*[@id=\"fruit-selects\"]"));
        //driver.quit();
        Select orange = new Select(options1);
        List<WebElement> listoptions = orange.getOptions();
        for(WebElement fruitoptions : listoptions)
        if (fruitoptions.getText().contains("Orange"))
            System.out.println("Orange is Displayed");
        else {
            System.out.println("Orange is not Displayd");
        }
        driver.quit();
    }
}
