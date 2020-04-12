package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task_14 {

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
    public void task_14() {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        clickOn(By.cssSelector("[class=\"fa fa-pencil\"]"));

        List<WebElement> allExternalLinks = driver.findElements(By.cssSelector("[class=\"fa fa-external-link\"]"));

        for (int i = 0; i < allExternalLinks.size(); i++) {
            List<WebElement> allExternalLinks2 = driver.findElements(By.cssSelector("[class=\"fa fa-external-link\"]"));
            allExternalLinks2.get(i).click();

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            System.out.println("#" + i + ". Main: " + tabs.get(0));
            driver.switchTo().window(tabs.get(1));
            System.out.println("#" + i + ". New: " + tabs.get(1));
            driver.close();
            driver.switchTo().window(tabs.get(0));
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
