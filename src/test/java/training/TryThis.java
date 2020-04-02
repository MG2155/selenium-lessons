package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TryThis {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void task10() {
        String elementTitle = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"name\"]")).getAttribute("textContent");
        String elementRegPrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/s")).getAttribute("textContent");
        String elementSalePrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/strong")).getAttribute("textContent");

        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li")).click();

        String elementTitleTwo = driver.findElement(By.xpath("//h1[@class=\"title\"]")).getAttribute("textContent");
        String itemRegPrice = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String itemSalePrice = driver.findElement(By.className("campaign-price")).getAttribute("textContent");

        Assert.assertEquals(elementTitle, elementTitleTwo);
        Assert.assertEquals(elementRegPrice, itemRegPrice);
        Assert.assertEquals(elementSalePrice, itemSalePrice);
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
