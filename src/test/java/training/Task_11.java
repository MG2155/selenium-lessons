package training;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Task_11 {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void task_11() throws InterruptedException {

        clickOn(By.cssSelector("a[href*=\"create\"]"));
        Thread.sleep(500);
        sendText("543215874", By.xpath("//input[@name=\"tax_id\"]"));
        sendText("Company Name", By.xpath("//input[@name=\"company\"]"));
        sendText("Name_Yury", By.xpath("//input[@name=\"firstname\"]"));
        sendText("LastName_Yury", By.xpath("//input[@name=\"lastname\"]"));
        sendText("AnyAddress", By.xpath("//input[@name=\"address1\"]"));
        sendText("AnyAddress", By.xpath("//input[@name=\"address2\"]"));
        sendText("80121", By.xpath("//input[@name=\"postcode\"]"));
        sendText("Centennial", By.xpath("//input[@name=\"city\"]"));
        clickOn(By.className("select2-selection__rendered"));
        sendText("United States", By.cssSelector("input[type=\"search\"]"));
        driver.findElement(By.cssSelector("input[type=\"search\"]")).sendKeys(Keys.ENTER);
        String email = createRandomEmail(4, 4);
        sendText(email, By.xpath("//input[@name=\"email\"]"));
        sendText("+17202400000", By.xpath("//input[@name=\"phone\"]"));
        String pass = "password1";
        sendText("password1", By.xpath("//input[@name=\"password\"]"));
        sendText("password1", By.xpath("//input[@name=\"confirmed_password\"]"));
        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        sendText(captchaVal, By.xpath("//input[@name=\"captcha\"]"));
        clickOn(By.cssSelector("button[type=\"submit\"]"));

        //Logout
        Thread.sleep(1000);
        clickOn(By.cssSelector("a[href*=\"logout\"]"));
        //Log in
        Thread.sleep(1000);
        sendText(email, By.cssSelector("input[name=\"email\"]"));
        sendText(pass, By.cssSelector("input[name=\"password\"]"));
        clickOn(By.cssSelector("button[name=\"login\"]"));
        System.out.println(email + " | " +pass);
    }


    @AfterTest
    public void stop() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
        driver = null;

    }

    public void sendText(String value, By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

    public void select(String n, By locator) {
        new Select(driver.findElement(locator)).selectByVisibleText(n);
    }

    public void clickOn(By locator) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public static String randomString(int lenght) {

        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(lenght, useLetters, useNumbers);
    }

    public static String createRandomEmail(int body, int tail) {
        return randomString(body) + "@" + randomString(tail) + ".com";
    }
}


