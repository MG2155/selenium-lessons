package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task_17 {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/login.php");
        sendText("admin", By.cssSelector("input[name='username']"));
        sendText("admin", By.cssSelector("input[name='password']"));
        clickOn(By.cssSelector("button[name='login']"));
    }

    @Test
    public void task_17() throws InterruptedException {

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        clickOn(By.linkText("Rubber Ducks"));
        clickOn(By.linkText("Subcategory"));
        List<WebElement> size = driver.findElements(By.xpath("//tr/td[3]/a"));
        for (int i = 0; i < size.size(); i++) {
            List<WebElement> list = driver.findElements(By.xpath("//tr/td[3]/a"));
            list.get(i).click();
            List<LogEntry> allLogs = driver.manage().logs().get("browser").getAll();
            for (LogEntry str : allLogs
            ) {
                Assert.assertNull(str);
            }
            driver.navigate().back();
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }


    public void sendText(String value, By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public void clickOn(By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
