package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl= "https://mobile.x-cart.com/";
    public void selectMenu(String menu) throws InterruptedException {
        List<WebElement> menuBar = driver.findElements(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/child::*"));
        for (WebElement product :menuBar){
            if(product.getText().equalsIgnoreCase(menu)){
                Thread.sleep(2000);
                product.click();
                break;
            }
        }

    }

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingSuccessfully() throws InterruptedException {
        selectMenu("Shipping");
        Thread.sleep(2000);
        verifyMatchingElements("Shipping",By.xpath("//h1[@id='page-title']"),"You are not on a Shipping page");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        selectMenu("New!");
        Thread.sleep(2000);
        verifyMatchingElements("New arrivals",By.xpath("//h1[@id='page-title']"),"You are not on a New Arrivals page");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException{
        selectMenu("Coming soon");
        Thread.sleep(2000);
        verifyMatchingElements("Coming soon",By.xpath("//h1[@id='page-title']"),"You are not on a Coming soon page");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException{
        selectMenu("Contact us");
        verifyMatchingElements("Contact us",By.xpath("//h1[@id='page-title']"),"You are not on a Contact us page");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
