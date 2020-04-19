package training.task_19.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        openMainPage();
        isOnThisPage();
    }

    public void openMainPage() {
        driver.get("http://localhost/litecart/en/");
    }

    public void isOnThisPage() {
        driver.findElements(By.id("box-account-login"));
    }

}
