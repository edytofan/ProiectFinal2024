package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test1 {

    public WebDriver driver;

    @Test
    public void testAutomat1() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        String expectedPageTitle="CEL.ro - Cel mai Cel Marketplace";
        String actualPageTitle=driver.getTitle();
        Assert.assertEquals(expectedPageTitle,actualPageTitle,"Pagina nu are titlu corect");
        System.out.println(actualPageTitle);


        WebElement switchToMenu = driver.findElement(By.className("icon-icon_user"));
        Actions action=new Actions(driver);
        action.moveToElement(switchToMenu).perform();
        switchToMenu.click();

        WebElement login=driver.findElement(By.xpath("//div[@class='myAccountMenu']//a[contains(text(),'Conecteaza-te')]"));
        login.click();

        String actualPageTitle1=driver.getTitle();
        System.out.println(actualPageTitle1);

        WebElement email=driver.findElement(By.xpath("//input[@id='email_address']"));
        email.sendKeys("edytofan3333@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Scorpion01");
        WebElement submit=driver.findElement(By.xpath("//div[@id='logintable']//button[@type='submit']"));
        submit.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
        String actualPageTitle2=driver.getTitle();
        System.out.println(actualPageTitle2);

        List<WebElement> produsAles=driver.findElements(By.xpath("//body/div[@id='mainWrapper']/div[@class='content-wrapper']/div[@class='homepage_products']/div[@class='products']/div[1]/div[1]"));
        produsAles.get(0).click();

        WebElement adaugaInCos = driver.findElement(By.xpath("//div[contains(@onclick, 'add_to_cart') and contains(@class, 'btn_add_to_cart')]"));
        adaugaInCos.click();
        String ActualPageTitle3=driver.getTitle();
        System.out.println(ActualPageTitle3);
        driver.close();
    }
}