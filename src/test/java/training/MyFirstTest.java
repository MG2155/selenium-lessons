package training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class MyFirstTest {

    private WebDriver driver;

    @Before
    public void start() {

        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("password");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
