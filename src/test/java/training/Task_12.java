package training;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Task_12 {
    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        sendText("admin", By.cssSelector("input[name='username']"));
        sendText("admin", By.cssSelector("input[name='password']"));
        clickOn(By.cssSelector("button[name='login']"));
    }

    @Test
    public void test12() throws InterruptedException {
        Thread.sleep(1000);
        clickOn(By.linkText("Catalog"));
        clickOn(By.cssSelector("a[href*=\"edit_product\"]"));
        Thread.sleep(1000);
        String name = randomString(5);
        sendText(name, By.cssSelector("[name=\"name[en]\"]"));
        clickOn(By.xpath("(//input[@type=\"radio\"])[1]"));
        sendText("2155", By.cssSelector("input[name=\"code\"]"));
        clickOn(By.xpath("//input[@value=\"1-1\"]"));
        sendText("1", By.cssSelector("input[name=\"quantity\"]"));
        File relative = new File("src/img/rub_d.jpg");
        String path1 = relative.getAbsolutePath();
        driver.findElement(By.cssSelector("[type=\"file\"]")).sendKeys(path1);
        Thread.sleep(3500);
        sendText("01012020", By.cssSelector("input[name=\"date_valid_from\"]"));
        sendText("01012025", By.cssSelector("input[name=\"date_valid_to\"]"));
        Thread.sleep(1000);
        //Information
        clickOn(By.cssSelector("a[href*='information']"));
        select(1, By.cssSelector("select[name=\"manufacturer_id\"]"));
        sendText("text", By.cssSelector("input[name=\"keywords\"]"));
        sendText("text", By.cssSelector("input[name*=\"short\"]"));
        sendText("text", By.cssSelector("div[class=\"trumbowyg-editor\"]"));
        sendText("text", By.cssSelector("input[name=\"head_title[en]\"]"));
        sendText("text", By.cssSelector("input[name=\"meta_description[en]\"]"));
        //Prices
        clickOn(By.cssSelector("a[href*='prices']"));
        sendText("100", By.cssSelector("input[name=\"purchase_price\"]"));
        select(1, By.cssSelector("select[name=\"purchase_price_currency_code\"]"));
        sendText("100", By.cssSelector("input[name=\"prices[USD]\"]"));
        sendText("85", By.cssSelector("input[name=\"prices[EUR]\"]"));
        clickOn(By.cssSelector("[name=\"save\"]"));
        Thread.sleep(1000);
        driver.findElement(By.linkText(name)).isDisplayed();
    }


    @AfterTest
    public void stop() {

        driver.quit();
        driver = null;

    }


    public void sendText(String value, By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public void select(int n, By locator) {
        new Select(driver.findElement(locator)).selectByIndex(n);
    }

    public void clickOn(By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static String randomString(int lenght) {

        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }
}