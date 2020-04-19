package training.task_19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import training.task_19.Pages.CheckoutPage;
import training.task_19.Pages.ItemPage;
import training.task_19.Pages.MainPage;

public class AddRemoveItems {

    protected WebDriver driver;
    protected int amount = 3;


    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void runIt() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        ItemPage itemPage = new ItemPage(driver);
        itemPage.addItem(amount);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.removeItem();
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
