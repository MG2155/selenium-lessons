package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_7 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        Thread.sleep(1500);
    }

    @Test(priority = 1)
    public void appearance() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Appearence"))).click();
        String appearenceTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(appearenceTitle, "Template");
        Thread.sleep(300);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Template"))).click();
        String templateTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(templateTitle, "Template");
        Thread.sleep(300);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logotype"))).click();
        String logotypeTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(logotypeTitle, "Logotype");
        Thread.sleep(300);
    }

    @Test(priority = 2)
    public void catalog() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Catalog"))).click();
        Thread.sleep(400);
        String catalogTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(catalogTitle, "Catalog");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span[contains(text(),'Catalog')]"))).click();
        Thread.sleep(400);
        String catalogChildTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(catalogChildTitle, "Catalog");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Product Groups"))).click();
        Thread.sleep(400);
        String productGroupsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(productGroupsTitle, "Product Groups");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Option Groups"))).click();
        Thread.sleep(400);
        String optionGroupsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(optionGroupsTitle, "Option Groups");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manufacturers"))).click();
        Thread.sleep(400);
        String manufacturersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(manufacturersTitle, "Manufacturers");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Suppliers"))).click();
        Thread.sleep(400);
        String suppliersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(suppliersTitle, "Suppliers");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delivery Statuses"))).click();
        Thread.sleep(400);
        String deliveryStatusesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(deliveryStatusesTitle, "Delivery Statuses");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sold Out Statuses"))).click();
        Thread.sleep(400);
        String soldOutStatusesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(soldOutStatusesTitle, "Sold Out Statuses");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Quantity Units"))).click();
        Thread.sleep(400);
        String quantityUnitsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(quantityUnitsTitle, "Quantity Units");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSV Import/Export"))).click();
        Thread.sleep(400);
        String cSVImportExportTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(cSVImportExportTitle, "CSV Import/Export");
    }

    @Test(priority = 3)
    public void countries() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Countries"))).click();
        Thread.sleep(400);
        String countriesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(countriesTitle, "Countries");
    }

    @Test(priority = 4)
    public void currencies() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Currencies"))).click();
        Thread.sleep(400);
        String currenciesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(currenciesTitle, "Currencies");
    }

    @Test(priority = 5)
    public void customers() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Customers"))).click();
        Thread.sleep(400);
        String customersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(customersTitle, "Customers");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span[contains(text(),'Customers')]"))).click();
        Thread.sleep(400);
        String customersChildTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(customersChildTitle, "Customers");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSV Import/Export"))).click();
        Thread.sleep(400);
        String cutomerCSVImportExportTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(cutomerCSVImportExportTitle, "CSV Import/Export");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Newsletter"))).click();
        Thread.sleep(400);
        String newsletterTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(newsletterTitle, "Newsletter");
    }

    @Test(priority = 6)
    public void geoZones() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Geo Zones"))).click();
        Thread.sleep(400);
        String geoZonesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(geoZonesTitle, "Geo Zones");
    }

    @Test(priority = 7)
    public void languages() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Languages"))).click();
        Thread.sleep(400);
        String languagesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(languagesTitle, "Languages");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span[contains(text(),'Languages')]"))).click();
        Thread.sleep(400);
        String languagesChildTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(languagesChildTitle, "Languages");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Storage Encoding"))).click();
        Thread.sleep(400);
        String storageEncodingTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(storageEncodingTitle, "Storage Encoding");
    }

    @Test(priority = 8)
    public void modules() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Modules"))).click();
        Thread.sleep(400);
        String jobModulesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(jobModulesTitle, "Job Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Background Jobs"))).click();
        Thread.sleep(400);
        String backgroundJobsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(backgroundJobsTitle, "Job Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Customer"))).click();
        Thread.sleep(400);
        String customerTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(customerTitle, "Customer Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Shipping"))).click();
        Thread.sleep(400);
        String shippingTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(shippingTitle, "Shipping Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Payment"))).click();
        Thread.sleep(400);
        String paymentModulesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(paymentModulesTitle, "Payment Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order Total"))).click();
        Thread.sleep(400);
        String orderTotalModulesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(orderTotalModulesTitle, "Order Total Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order Success"))).click();
        Thread.sleep(400);
        String orderSuccessModulesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(orderSuccessModulesTitle, "Order Success Modules");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order Action"))).click();
        Thread.sleep(400);
        String orderActionTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(orderActionTitle, "Order Action Modules");
    }

    @Test(priority = 9)
    public void orders() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Orders"))).click();
        Thread.sleep(400);
        String ordersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(ordersTitle, "Orders");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span[contains(text(),'Orders')]"))).click();
        Thread.sleep(400);
        String oedersChildTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(oedersChildTitle, "Orders");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Order Statuses"))).click();
        Thread.sleep(400);
        String orderStatusesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(orderStatusesTitle, "Order Statuses");
    }

    @Test(priority = 10)
    public void pages() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Pages"))).click();
        Thread.sleep(400);
        String pagesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(pagesTitle, "Pages");
    }

    @Test(priority = 11)
    public void reports() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Reports"))).click();
        Thread.sleep(400);
        String reportsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(reportsTitle, "Monthly Sales");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Monthly Sales"))).click();
        Thread.sleep(400);
        String monthlySalesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(monthlySalesTitle, "Monthly Sales");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Most Sold Products"))).click();
        Thread.sleep(400);
        String mostSoldProductsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(mostSoldProductsTitle, "Most Sold Products");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Most Shopping Customers"))).click();
        Thread.sleep(400);
        String mostShoppingCustomersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(mostShoppingCustomersTitle, "Most Shopping Customers");
    }

    @Test(priority = 12)
    public void settings() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Settings"))).click();
        Thread.sleep(400);
        String settingsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(settingsTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Store Info"))).click();
        Thread.sleep(400);
        String storeInfoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(storeInfoTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Defaults"))).click();
        Thread.sleep(400);
        String defaultsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(defaultsTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("General"))).click();
        Thread.sleep(400);
        String generalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(generalTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Listings"))).click();
        Thread.sleep(400);
        String listingsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(listingsTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Images"))).click();
        Thread.sleep(400);
        String imagesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(imagesTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout"))).click();
        Thread.sleep(400);
        String checkoutTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(checkoutTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Advanced"))).click();
        Thread.sleep(400);
        String advancedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(advancedTitle, "Settings");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Security"))).click();
        Thread.sleep(400);
        String securityTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(securityTitle, "Settings");
    }

    @Test(priority = 13)
    public void slides() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Slides"))).click();
        Thread.sleep(400);
        String slidesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(slidesTitle, "Slides");
    }

    @Test(priority = 14)
    public void tax() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tax"))).click();
        Thread.sleep(400);
        String taxTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(taxTitle, "Tax Classes");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tax Classes"))).click();
        Thread.sleep(400);
        String taxClassesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(taxClassesTitle, "Tax Classes");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Tax Rates"))).click();
        Thread.sleep(400);
        String taxRatesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(taxRatesTitle, "Tax Rates");
    }

    @Test(priority = 15)
    public void translations() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Translations"))).click();
        Thread.sleep(400);
        String translationsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(translationsTitle, "Search Translations");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Search Translations"))).click();
        Thread.sleep(400);
        String searchTranslationsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(searchTranslationsTitle, "Search Translations");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Scan Files"))).click();
        Thread.sleep(400);
        String scanFilesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(scanFilesTitle, "Scan Files For Translations");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CSV Import/Export"))).click();
        Thread.sleep(400);
        String varCSVImportExportTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(varCSVImportExportTitle, "CSV Import/Export");
    }

    @Test(priority = 16)
    public void users() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Users"))).click();
        Thread.sleep(400);
        String usersTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(usersTitle, "Users");
    }

    @Test(priority = 17)
    public void vQmods() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("vQmods"))).click();
        Thread.sleep(400);
        String vQmodsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(vQmodsTitle, "vQmods");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[1]/a/span[contains(text(),'vQmods')]"))).click();
        Thread.sleep(400);
        String vQmodsChildTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[style*='top']"))).getText();
        Assert.assertEquals(vQmodsChildTitle, "vQmods");


    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }



}
