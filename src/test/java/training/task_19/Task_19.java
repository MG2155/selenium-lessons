package training.task_19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class Task_19 {
    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void test13() throws InterruptedException {
        Wait<WebDriver> flwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class);
        for (int i = 0; i < 3; i++) {
            List<WebElement> mostPop = driver.findElements(By.xpath("//div[@id=\"box-most-popular\"]/div[@class=\"content\"]/ul/li/a[@class=\"link\"]"));
            mostPop.get(0).click();
            flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"add_cart_product\"]")));
            try {
                flwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[name=\"options[Size]\"]"))));
                select(1, By.cssSelector("[name=\"options[Size]\"]"));
            } catch (Exception ignored) {
            }
            flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"add_cart_product\"]"))).click();
            String quantityOfItems = Integer.toString(i + 1);
            WebElement quantityElement = driver.findElement(By.cssSelector("span[class=\"quantity\"]"));
            flwait.until(ExpectedConditions.attributeToBe(quantityElement, "textContent", quantityOfItems));
            driver.get("http://localhost/litecart/en/");
        }
        WebElement checkout = driver.findElement(By.xpath("(//*[contains(@href,'checkout')])[3]"));
        checkout.click();
        flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"confirm\"]")));
        int size = driver.findElements(By.cssSelector("[class=\"shortcut\"]")).size();
        Thread.sleep(400);
        for (int j = 0; j < size; j++) {
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"order_confirmation-wrapper\"]/table/tbody/tr[2]"));
            flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"remove_cart_item\"]"))).click();
            flwait.until(stalenessOf(refresh));
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

    public void select(int n, By locator) {
        new Select(driver.findElement(locator)).selectByIndex(n);
    }
}