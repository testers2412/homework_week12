package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl= "https://demo.nopcommerce.com/";
    /**
     * Method to select the product from menu
     * @param menu
     */

    public  void selectMenu(String menu) throws InterruptedException {
        List<WebElement> menuBar= driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        for(WebElement product:menuBar){
            if(product.getText().equalsIgnoreCase(menu)){
            Thread.sleep(2000);
            product.click();
            break;
        }}
    }
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }



    @Test
    public void goToComputersPage() throws InterruptedException {
        selectMenu("Computers");
        Thread.sleep(2000);
        String expectedResult= "Computers";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);


       //Assert.assertEquals("Test is not passed",);
    }
    @Test
    public void goToElectronicsPage() throws InterruptedException {
        selectMenu("Electronics");
        Thread.sleep(2000);
        String expectedResult= "Electronics";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);
    }
    @Test
    public void goToApparelPage() throws InterruptedException {
        selectMenu("Apparel");
        Thread.sleep(3000);
        String expectedResult= "Apparel";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);
    }
    @Test
    public void goToDigitalDownloadsPage() throws InterruptedException {
        selectMenu("Digital downloads");
        Thread.sleep(3000);
        String expectedResult= "Digital downloads";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);


    }
    @Test
    public void goToBooksPage() throws InterruptedException {
        selectMenu("Books");
        Thread.sleep(3000);
        String expectedResult= "Books";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);
    }
    @Test
    public void goToJewelryPage() throws InterruptedException {
        selectMenu("Jewelry");
        Thread.sleep(3000);
        String expectedResult= "Jewelry";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);
    }
    @Test
    public void goToGiftCardsPage() throws InterruptedException {
        selectMenu("Gift Cards");
        Thread.sleep(3000);
        String expectedResult= "Gift Cards";
        String actualResult = getTextFromElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']"));
        Assert.assertEquals("The test is failed",expectedResult,actualResult);
    }
    @After
    public void tearDown(){
     closeBrowser();
    }



}
