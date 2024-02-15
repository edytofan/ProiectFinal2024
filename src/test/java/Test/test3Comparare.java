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

public class test3Comparare {

    public WebDriver driver;

    @Test
    public void testautomat3() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String expectedPageTitle = "CEL.ro - Cel mai Cel Marketplace";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle,"Pagina nu are titlu corect");
        System.out.println(actualPageTitle);

        WebElement telefoaneMobile=driver.findElement(By.xpath("//a[normalize-space()='Telefoane Mobile & Gadget']"));
        telefoaneMobile.click();

        WebElement telefoaneMobileSelect=driver.findElement(By.xpath("//body//div[@id='mainWrapper']//div[@id='bodycode']//div//div//a[1]"));
        telefoaneMobileSelect.click();

        List<WebElement> telefon1=driver.findElements(By.xpath("//body/div[@id='mainWrapper']/div[@class='content-wrapper']/div[@id='bodycode3']/div[@id='bodycode']/div[@class='listingPageWrapper']/div[@class='listingWrapper']/div[@class='productlisting']/div[1]"));
        telefon1.get(0).click();
        WebElement compara1=driver.findElement(By.xpath("//span[@id='retinut']"));
        compara1.click();
        driver.navigate().back();

        List<WebElement> telefon2=driver.findElements(By.xpath("//div[@id='bodycode3']//div[1]//div[2]//div[3]"));
        telefon2.get(0).click();
        WebElement compara2=driver.findElement(By.xpath("//span[@id='retinut']"));
        compara2.click();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement comparaTot= driver.findElement(By.xpath("//span[@class='icon-wrapper']//i[@class='icon-heart']"));
        comparaTot.click();

        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement checkbox=driver.findElement(By.xpath("//input[@id='select_all_TelefoaneMobile']"));
        checkbox.click();
        WebElement comparaProduse=driver.findElement(By.xpath("//div[@id='meniu_c']//button[1]//span[1]"));
        comparaProduse.click();

        

        //driver.close();
    }
}