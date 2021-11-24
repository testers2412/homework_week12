package shopping;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl="https://mobile.x-cart.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {
        actionMouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyMatchingElements("Sale",By.xpath("//h1[@id='page-title']"),"You are not on Sale page");
        Thread.sleep(4000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(2000);
        actionMouseHoverAndClick(By.xpath("//div[contains(@class,'product productid-16')]//h5[@class='product-name']"),By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        verifyMatchingElements("Product has been added to your cart",By.xpath("//li[@class='info']"),"The product is not been added");
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));
        Thread.sleep(2000);
        verifyMatchingElements("Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"),"The qty in cart is not matching");
        clearText(By.xpath("//input[@title='Quantity']"));
        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='amount16' and @ name='amount']"),"2");
        Thread.sleep(5000);
        verifyMatchingElements("Your shopping cart - 2 items",By.xpath("//h1[@class='title']"),"The qty in cart is not matching");
        Thread.sleep(2000);
        verifyMatchingElements("$29.98",By.xpath("//ul[contains(@class,'sums')]//span[contains(@class,'surcharge-cell')]"),"The subtotal is not matching");
        Thread.sleep(2000);
        verifyMatchingElements("$36.00",By.xpath("//li[@class='total']//span[@class='surcharge-cell']"),"The total is not matching");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));
        Thread.sleep(2000);
        verifyMatchingElements("Log in to your account",By.xpath("//h3[normalize-space()='Log in to your account']"),"You are not a right page");
        Thread.sleep(2000);
        RandomString rnd = new RandomString(10);
        String randString= rnd.nextString();
        sendTextToElement(By.xpath("//input[@name='email']"),randString+"@gmail.com");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));
        Thread.sleep(2000);
        sendTextToElement(By.id("shippingaddress-firstname"),"Ram");
        Thread.sleep(2000);
        sendTextToElement(By.id("shippingaddress-lastname"),"Kumar");
        Thread.sleep(2000);
        sendTextToElement(By.id("shippingaddress-street"),"9 Ayodhya Street");
        Thread.sleep(2000);
        clearText(By.id("shippingaddress-city"));
        sendTextToElement(By.id("shippingaddress-city"),"London");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.id("shippingaddress-country-code"),"GB");
        Thread.sleep(2000);
        sendTextToElement(By.id("shippingaddress-custom-state"),"Middex");
        Thread.sleep(4000);
        clearText(By.xpath("//input[@id='shippingaddress-zipcode']"));
        Thread.sleep(4000);
        sendTextToElement(By.id("shippingaddress-zipcode"),"90002");
        Thread.sleep(4000);
        clickOnElement(By.xpath("//input[@name='create_profile']"));
        Thread.sleep(5000);
        sendTextToElement(By.id("password"),"abc123");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='128']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='6']"));
        Thread.sleep(2000);
        verifyMatchingElements("$37.03",By.xpath("//div[@class='total clearfix']//span[@class='surcharge-cell']"),"The total is not matching");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(2000);
        verifyMatchingElements("Thank you for your order",By.xpath("//h1[@class='title']"),"You are not on a right page");
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        actionMouseHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyMatchingElements("Bestsellers",By.xpath("//h1[@class='title']"),"YOu are not on a bestseller page");
        Thread.sleep(2000);
        actionMouseHoverAndClick(By.xpath("//span[@class='sort-by-value']"),By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(2000);
        actionMouseHoverAndClick(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"),By.xpath("(//button[@type='button'])[12]"));
        Thread.sleep(2000);
        verifyMatchingElements("Product has been added to your cart",By.xpath("//li[@class='info']"),"The item is not been added to cart");
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        Thread.sleep(2000);
        verifyMatchingElements("Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']"),"You are not on a cart page");
        clickOnElement(By.xpath("//a[@class='clear-bag']"));
        Thread.sleep(2000);
        String alert = alertGetText();
        Thread.sleep(2000);
        String expectedAlertMessage= "Are you sure you want to clear your cart?";
        Assert.assertEquals("The alert message is not matching",expectedAlertMessage,alert);
        Thread.sleep(2000);
        alertAccept();
        verifyMatchingElements("Item(s) deleted from your cart",By.xpath("//li[@class='info']"),"The message is not matching");
        Thread.sleep(2000);
        verifyMatchingElements("Your cart is empty",By.xpath("//h1[@id='page-title']"),"The message is not matching");

    }
    @After
    public void tearDown (){
        closeBrowser();
    }
}


