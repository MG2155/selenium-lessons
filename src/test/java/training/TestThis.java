package training;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestThis {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(1500);
    }

    @Test(priority = 1)
    public void mainBtn() {
        List<WebElement> allMainBtns = driver.findElements(By.cssSelector("li[id*=\"app-\"]"));
        for (int i = 0; i < allMainBtns.size(); i++) {
            boolean result = false;
            int attempts = 0;
            while (attempts < 2) {
                try {
                    allMainBtns.get(i).click();
                    result = true;
                    break;
                } catch (StaleElementReferenceException e) {
                }
                attempts++;
            }
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }


}
