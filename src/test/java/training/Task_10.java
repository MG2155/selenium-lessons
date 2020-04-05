package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task_10 {

    private WebDriver driver;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void task10() {

        //Title on a store page
        String elementTitle = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"name\"]")).getAttribute("textContent");
        //Regular price on the main page
        String elementRegPrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/s")).getAttribute("textContent");
        //Campaign price on the main page
        String elementCampaignPrice = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/strong")).getAttribute("textContent");
        //Regular price color on the main page
        String regPriceColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class=\"regular-price\"]")).getCssValue("color");
        String[] grey = new String[256];
        for (int i = 0; i < 256; i++) {
            grey[i] = "rgba(" + i + ", " + i + ", " + i + ", 1)";
            if (grey[i].equals(regPriceColor)) {
                System.out.println("On a landing page \"Regular price\" color is grey: " + grey[i]);
            }
        }
        //Text-decoration of the regular price  on the main page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class=\"regular-price\"]")).getCssValue("text-decoration").contains("line-through"));
        //font-weight
        Assert.assertTrue(driver.findElement(By.className("price-wrapper")).getCssValue("font-weight").contains("700"));
        //Campaign price color on the main page
        String campaignPriceColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class=\"campaign-price\"]")).getCssValue("color");
        String[] red = new String[256];
        for (int i = 0; i < 256; i++) {
            red[i] = "rgba(" + i + ", 0, 0, 1)";
            if (red[i].equals(campaignPriceColor)) {
                System.out.println("On a landing page \"Campaign price\" color is red: " + red[i]);
            }
        }

        //Price font size on the main Page
        String regsize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class=\"regular-price\"]")).getCssValue("font-size");
        String campaignsize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/strong")).getCssValue("font-size");
        double d_reg = Double.parseDouble(regsize.replaceAll("px", ""));
        double d_campaign = Double.parseDouble(campaignsize.replaceAll("px", ""));
        Assert.assertTrue(d_campaign > d_reg);


        //go to the item page
        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li")).click();

        String regPriceColor2 = driver.findElement(By.cssSelector("s[class=\"regular-price\"]")).getCssValue("color");
        String[] grey2 = new String[256];
        for (int i = 0; i < 256; i++) {
            grey2[i] = "rgba(" + i + ", " + i + ", " + i + ", 1)";
            if (grey2[i].equals(regPriceColor2)) {
                System.out.println("On a item page \"Regular price\" color is grey: " + grey2[i]);
            }
        }
        //Text-decoration of the regular price  on the main page
        Assert.assertTrue(driver.findElement(By.cssSelector("s[class=\"regular-price\"]")).getCssValue("text-decoration").contains("line-through"));
        //font-weight
        Assert.assertTrue(driver.findElement(By.className("campaign-price")).getCssValue("font-weight").contains("700"));
        //Campaign price color on the main page
        String campaignPriceColor2 = driver.findElement(By.cssSelector("strong[class=\"campaign-price\"]")).getCssValue("color");
        String[] red2 = new String[256];
        for (int i = 0; i < 256; i++) {
            red2[i] = "rgba(" + i + ", 0, 0, 1)";
            if (red2[i].equals(campaignPriceColor2)) {
                System.out.println("On a item page \"Campaign price\" color is red: " + red2[i]);
            }
        }

        String elementTitleTwo = driver.findElement(By.xpath("//h1[@class=\"title\"]")).getAttribute("textContent");
        String itemRegPrice = driver.findElement(By.className("regular-price")).getAttribute("textContent");
        String itemCampaignPrice = driver.findElement(By.className("campaign-price")).getAttribute("textContent");

        Assert.assertEquals(elementTitle, elementTitleTwo);
        Assert.assertEquals(elementRegPrice, itemRegPrice);
        Assert.assertEquals(elementCampaignPrice, itemCampaignPrice);

        //Price font size on the item Page
        String regsize2 = driver.findElement(By.cssSelector("s[class=\"regular-price\"]")).getCssValue("font-size");
        String campaignsize2 = driver.findElement(By.cssSelector("strong[class=\"campaign-price\"]")).getCssValue("font-size");
        double d_reg2 = Double.parseDouble(regsize2.replaceAll("px", ""));
        double d_campaign2 = Double.parseDouble(campaignsize2.replaceAll("px", ""));
        Assert.assertTrue(d_campaign2 > d_reg2);
    }


    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}
