package training.task_19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ItemPage {

    protected WebDriver driver;
    Wait<WebDriver> flwait;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItem(int amount) {
        for (int i = 0; i < amount; i++) {
            clickOnItem();
            addItem();
            goBack();
        }
    }

    private void clickOnItem() {
        driver.findElements(By.xpath("//div[@id=\"box-most-popular\"]/div[@class=\"content\"]/ul/li/a[@class=\"link\"]")).get(0).click();
    }

    private void addItem() {
        flwait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class);
        try {
            flwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[name=\"options[Size]\"]"))));
            select(1, By.cssSelector("[name=\"options[Size]\"]"));
        } catch (Exception ignored) {
        }

        String quantityBefore = driver.findElement(By.cssSelector("span[class=\"quantity\"]")).getText();
        int q1 = Integer.parseInt(quantityBefore);
        int q2 = q1 + 1;
        String quantityAfter = String.valueOf(q2);
        flwait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"add_cart_product\"]"))).click();
        flwait.until(ExpectedConditions.textToBe(By.cssSelector("span[class=\"quantity\"]"), quantityAfter));
    }

    private void goBack() {
        driver.get("http://localhost/litecart/en/");
    }

    public void select(int n, By locator) {
        new Select(driver.findElement(locator)).selectByIndex(n);
    }

}
