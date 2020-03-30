package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Task_3 {

    private WebDriver driver;

    @Test
    public void test1() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();

    }

//    @Test
//    public void test2() {
//
//        driver.findElement(By.linkText("Appearence")).click();
//        driver.findElement(By.linkText("Template")).click();
//        driver.findElement(By.linkText("Logotype")).click();
//
//    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}