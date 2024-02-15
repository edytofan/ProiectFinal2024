package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test4 {

    public WebDriver driver;

    @Test
    public void test4() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String expectedPageTitle = "CEL.ro - Cel mai Cel Marketplace";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle, "Pagina nu are titlu corect");
        System.out.println(actualPageTitle);
    }
}
