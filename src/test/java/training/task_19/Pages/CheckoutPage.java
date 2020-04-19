package training.task_19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CheckoutPage {

    protected WebDriver driver;
    Wait<WebDriver> flwait;
    private int howManyItems;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeItem() throws InterruptedException {
        goCheckoutPage();
        getHowManyItemsForRemoving();
        removeOneItem();
    }

    public void goCheckoutPage() {
        flwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class);
        WebElement checkout = driver.findElement(By.xpath("(//*[contains(@href,'checkout')])[3]"));
        checkout.click();
        flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"confirm\"]")));
    }

    public void getHowManyItemsForRemoving() {
        howManyItems = driver.findElements(By.cssSelector("[class=\"shortcut\"]")).size();
    }

    public void removeOneItem() throws InterruptedException {
        for (int i = 0; i < howManyItems; i++) {
            flwait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(250))
                    .ignoring(Exception.class);
            Thread.sleep(400);
            WebElement refresh = driver.findElement(By.xpath("//*[@id=\"order_confirmation-wrapper\"]/table/tbody/tr[2]"));
            flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"remove_cart_item\"]"))).click();
            flwait.until(stalenessOf(refresh));
        }
    }

}