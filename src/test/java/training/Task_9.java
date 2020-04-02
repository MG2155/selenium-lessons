package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_9 {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    }

    @Test
    public void task91a() {
        List<WebElement> allRows = driver.findElements(By.xpath("//tr/td[5]/a"));
        String[] arrayOfNames = new String[allRows.size()];
        for (int i = 0; i < allRows.size(); i++) {
            String str = allRows.get(i).getAttribute("text");
            arrayOfNames[i] = str;
        }
        Arrays.sort(arrayOfNames);
        for (int j = 0; j < allRows.size(); j++) {
            Assert.assertEquals(allRows.get(j).getAttribute("text"), arrayOfNames[j]);
        }
    }

    @Test
    public void task91b() {
        List<WebElement> allZones = driver.findElements(By.xpath("//tbody/tr/td[6]"));
        for (int i = 0; i < allZones.size(); i++) {
            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            List<WebElement> allZonesNew = driver.findElements(By.xpath("//tbody/tr/td[6]"));
            String numberOfZones = allZonesNew.get(i).getAttribute("innerText");
            int result = Integer.parseInt(numberOfZones);
            if (result != 0) {
                List<WebElement> countryList = driver.findElements(By.xpath("//tr/td[5]/a"));
                countryList.get(i).click();
                List<WebElement> zonesListone = driver.findElements(By.xpath("//table[2]/tbody/tr/td[3]/input[@type=\"hidden\"]"));
                String[] stringArrayOfZonesSorted = new String[zonesListone.size()];
                String[] stringArrayOfZonesNotSorted = new String[zonesListone.size()];
                for (int n = 0; n < zonesListone.size(); n++) {
                    List<WebElement> zonesList = driver.findElements(By.xpath("//table[2]/tbody/tr/td[3]/input[@type=\"hidden\"]"));
                    String zone = zonesList.get(n).getAttribute("value");
                    stringArrayOfZonesSorted[n] = zone;
                    stringArrayOfZonesNotSorted[n] = zone;
                }
                Arrays.sort(stringArrayOfZonesSorted);
                for (int m = 0; m < zonesListone.size(); m++) {
                    Assert.assertEquals(stringArrayOfZonesSorted[m], stringArrayOfZonesNotSorted[m]);
                }
            }
        }
    }

    @Test
    public void task92() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countries = driver.findElements(By.xpath("//tbody/tr/td[3]/a"));
        for (int i = 0; i < countries.size(); i++) {
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            List<WebElement> countriesNew = driver.findElements(By.xpath("//tbody/tr/td[3]/a"));
            countriesNew.get(i).click();

            List<WebElement> items = driver.findElements(By.xpath("//tbody/tr/td[3]/select/option[@selected=\"selected\"]"));
            String[] arrayForSelectedValuesSorted = new String[items.size()];
            String[] arrayForSelectedValuesNOTSorted = new String[items.size()];

            for (int j = 0; j < items.size(); j++) {
                List<WebElement> itemsNew = driver.findElements(By.xpath("//tbody/tr/td[3]/select/option[@selected=\"selected\"]"));
                String str = itemsNew.get(j).getAttribute("textContent");
                arrayForSelectedValuesSorted[j] = str;
                arrayForSelectedValuesNOTSorted[j] = str;

            }
            Arrays.sort(arrayForSelectedValuesSorted);
            for (int m = 0; m < items.size(); m++) {
                Assert.assertEquals(arrayForSelectedValuesSorted[m], arrayForSelectedValuesNOTSorted[m]);
            }
        }
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }
}
