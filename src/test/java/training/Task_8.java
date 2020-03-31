package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Task_8 {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void sticker() {
        List<WebElement> allDucks = driver.findElements(By.className("product"));
        for (int i = 0; i < allDucks.size(); i++) {
            int j = allDucks.get(i).findElements(By.className("sticker")).size();
            String str = allDucks.get(i).findElement(By.className("sticker")).getText();
            System.out.println("Duck #" + (i + 1) + " has a sticker's value: " + str + " and amount of stickers: " + j);
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}
