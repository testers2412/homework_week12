package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class HotDealsTests extends Utility {
    String baseUrl="https://mobile.x-cart.com/";
    public void goToHotDealsAndVerifyLink(By type) throws InterruptedException{
        actionMouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"),type);

    }

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        goToHotDealsAndVerifyLink(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyMatchingElements("Sale",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(4000);
         String expectedMessage = "Name A - Z";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        goToHotDealsAndVerifyLink(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyMatchingElements("Sale",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Price Low - High']"));
        Thread.sleep(4000);
        String expectedMessage = "Price Low - High";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @Test
    public void verifySaleProductsPriceArrangeByRates() throws InterruptedException {
        goToHotDealsAndVerifyLink(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyMatchingElements("Sale",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Rates']"));
        Thread.sleep(4000);
        String expectedMessage = "Rates";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        goToHotDealsAndVerifyLink(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyMatchingElements("Bestsellers",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Name Z - A']"));
        Thread.sleep(4000);
        String expectedMessage = "Name Z - A";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        goToHotDealsAndVerifyLink(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyMatchingElements("Bestsellers",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Price High - Low']"));
        Thread.sleep(4000);
        String expectedMessage = "Price High - Low";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        goToHotDealsAndVerifyLink(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyMatchingElements("Bestsellers",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Rates']"));
        Thread.sleep(4000);
        String expectedMessage = "Rates";
        String actualMessage= driver.findElement(By.xpath("//span[@class='sort-by-value']")).getText();
        Assert.assertEquals("The elements are not sorted",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
