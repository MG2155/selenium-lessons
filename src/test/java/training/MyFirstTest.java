package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyFirstTest {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("password");
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}