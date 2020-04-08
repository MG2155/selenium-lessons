package training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
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
        String rgbaNumbers = regPriceColor.replaceAll("[rgba(,)]", "");
        int[] numbers = Arrays.stream(rgbaNumbers.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Assert.assertEquals(numbers[0], numbers[1]);
        Assert.assertEquals(numbers[1], numbers[2]);

        //Text-decoration of the regular price  on the main page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class=\"regular-price\"]")).getCssValue("text-decoration").contains("line-through"));
        //font-weight
        Assert.assertTrue(driver.findElement(By.className("price-wrapper")).getCssValue("font-weight").contains("700"));
        //Campaign price color on the main page
        String campaignPriceColor = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//strong[@class=\"campaign-price\"]")).getCssValue("color");
        String rgbaNumbers2 = campaignPriceColor.replaceAll("[rgba(,)]", "");
        int[] numbers2 = Arrays.stream(rgbaNumbers2.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Assert.assertEquals(0, numbers2[2]);
        Assert.assertEquals(numbers2[1], numbers2[2]);


        //Price font size on the main Page
        String regsize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]//s[@class=\"regular-price\"]")).getCssValue("font-size");
        String campaignsize = driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li/a/div[@class=\"price-wrapper\"]/strong")).getCssValue("font-size");
        double d_reg = Double.parseDouble(regsize.replaceAll("px", ""));
        double d_campaign = Double.parseDouble(campaignsize.replaceAll("px", ""));
        Assert.assertTrue(d_campaign > d_reg);


        //go to the item page
        driver.findElement(By.xpath("//div[@id=\"box-campaigns\"]/div/ul/li")).click();

        String regPriceColor2 = driver.findElement(By.cssSelector("s[class=\"regular-price\"]")).getCssValue("color");
        String rgbaNumbers3 = regPriceColor2.replaceAll("[rgba(,)]", "");
        int[] numbers3 = Arrays.stream(rgbaNumbers3.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Assert.assertEquals(numbers3[0], numbers3[1]);
        Assert.assertEquals(numbers3[1], numbers3[2]);
        //Text-decoration of the regular price  on the main page
        Assert.assertTrue(driver.findElement(By.cssSelector("s[class=\"regular-price\"]")).getCssValue("text-decoration").contains("line-through"));
        //font-weight
        Assert.assertTrue(driver.findElement(By.className("campaign-price")).getCssValue("font-weight").contains("700"));
        //Campaign price color on the main page
        String campaignPriceColor4 = driver.findElement(By.cssSelector("strong[class=\"campaign-price\"]")).getCssValue("color");
        System.out.println("********************");
        System.out.println(campaignPriceColor4);
        String rgbaNumbers4 = campaignPriceColor4.replaceAll("[rgba(,)]", "");
        int[] numbers4 = Arrays.stream(rgbaNumbers4.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Assert.assertEquals(0, numbers4[2]);
        Assert.assertEquals(numbers4[1], numbers4[2]);

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
