package Test;

import org.testng.Assert;
import org.testng.annotations.Test;import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class test2CreareContCel {


    public WebDriver driver;

    @Test
    public void testAutomat2() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://www.cel.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        String expectedPageTitle = "CEL.ro - Cel mai Cel Marketplace";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals( expectedPageTitle,actualPageTitle, "Pagina nu are titlu corect");
        System.out.println(actualPageTitle);

        WebElement switchToMenu = driver.findElement(By.className("icon-icon_user"));
        Actions action=new Actions(driver);
        action.moveToElement(switchToMenu).perform();
        switchToMenu.click();

        WebElement create = driver.findElement(By.xpath("//div[@class='myAccountMenu']/a[2]"));
        create.click();

        String actualPageTitle2=driver.getTitle();
        System.out.println(actualPageTitle2);

        WebElement suntClientNou=driver.findElement(By.xpath("//body/div[@id='mainWrapper']/div/div[@id='bodycode3']/div[@id='bodycode']/div/div/div[1]/div[2]"));
        suntClientNou.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,0)", "");

        WebElement nume=driver.findElement(By.xpath("//input[@id='firstname']"));
        nume.sendKeys("Tofan");
        WebElement prenume=driver.findElement(By.xpath("//input[@id='lastname']"));
        prenume.sendKeys("Eduard");
        WebElement email=driver.findElement(By.xpath("//tbody//tr//td//div//div//div//div//div//input[@id='email_address']"));
        email.sendKeys("edytofan33@gmail.com");

        WebElement genulWeb=driver.findElement(By.xpath("//select[@id='customers_gender']"));
        String genValue="Doamna";
        Select genSelect=new Select(genulWeb);
        genSelect.selectByVisibleText(genValue);

        WebElement telefon=driver.findElement(By.xpath("//input[@id='telephone']"));
        telefon.sendKeys("0787720837");

        WebElement adresa=driver.findElement(By.xpath("//textarea[@id='street_address']"));
        adresa.sendKeys("Erich Bergel 32");

        WebElement localitateaWeb=driver.findElement(By.xpath("//select[@id='entry_suburb']"));
        String localitateaValue="Cluj";
        Select localitateaSelect=new Select(localitateaWeb);
        localitateaSelect.selectByVisibleText(localitateaValue);

        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        JavascriptExecutor jos = (JavascriptExecutor) driver;
        jos.executeScript("window.scrollBy(0,300)", "");

        WebElement submit = driver.findElement(By.xpath("//button[contains(@onclick, 'checkall') and contains(@class, 'btn-special')]"));
        submit.click();
        String actualPageTitle1=driver.getTitle();
        System.out.println(actualPageTitle1);
        driver.close();
    }
}