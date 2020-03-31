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

public class Task_7 {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(1500);
    }

    @Test(priority = 1)
    public void mainBtn() throws InterruptedException {
        List<WebElement> allMainBtns = driver.findElements(By.id("app-"));
        for (int i = 0; i < allMainBtns.size(); i++) {
            List<WebElement> mBtns = driver.findElements(By.id("app-"));
            mBtns.get(i).click();
            Thread.sleep(200);
            Assert.assertNotNull(driver.findElement(By.cssSelector("h1[style*='margin']")).getText());
            List<WebElement> addBtns = driver.findElements(By.cssSelector("li[id*='doc']"));
            for (int j = 0; j < addBtns.size(); j++) {
                List<WebElement> items = driver.findElements(By.cssSelector("li[id*='doc']"));
                items.get(j).click();
                Thread.sleep(200);
                Assert.assertNotNull(driver.findElement(By.cssSelector("h1[style*='margin']")).getText());
            }
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
