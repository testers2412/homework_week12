package computer;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        actionMouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        verifyMatchingElements("Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"), "The test has failed");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        actionMouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"), By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@class='picture']//img[@title='Show details for Build your own computer']"));
        verifyMatchingElements("Build your own computer", By.xpath("//h1[text()='Build your own computer']"), "You are not on the required page");
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "1");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "5");
        Thread.sleep(3000);
        actionMouseHover(By.xpath("//label[text()='400 GB [+$100.00]']"));
        Thread.sleep(3000);
        actionMouseHover(By.xpath("//label[text()='Vista Premium [+$60.00]']"));
        Thread.sleep(3000);
        actionMouseHover(By.xpath("//label[text()='Total Commander [+$5.00]']"));
        Thread.sleep(3000);
        verifyMatchingElements("$1,475.00", By.xpath("//span[@id='price-value-1']"), "The Price is not matching");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        verifyMatchingElements("The product has been added to your shopping cart", By.xpath("//p[@class='content']"), "The item is not added in cart");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//span[@title='Close']"));
        actionMouseHoverOnly(By.xpath("//span[@class='cart-label']"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));
        Thread.sleep(3000);
        verifyMatchingElements("Shopping cart", By.xpath("//h1[text()='Shopping cart']"), "You are not in hte Shopping Cart");
        Thread.sleep(3000);
        clearText(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        clickOnElement(By.xpath("//button[normalize-space()='Update shopping cart']"));
        verifyMatchingElements("$2,950.00", By.xpath("//tr[@class='order-subtotal']//span[@class='value-summary'][text()='$2,950.00']"), "The total is not matching");
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(3000);
        verifyMatchingElements("Welcome, Please Sign In!", By.xpath("//h1[text()='Welcome, Please Sign In!']"), "You are not on the right page");
        clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Ram");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Kumar");
        Thread.sleep(2000);
        RandomString rnd = new RandomString(10);
        String randString= rnd.nextString();
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), randString+"@gmail.com");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "133");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Vadodara");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@data-val-required='Street address is required']"), "9 Ayodhya Apartments");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@data-val-required='Zip / postal code is required']"), "391440");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@type='tel']"), "00919825336419");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Next Day Air___Shipping.FixedByWeightByTotal']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Payments.Manual']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"), "MasterCard");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Ram Kumar");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5553 0422 4198 4105");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "9");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "765");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));
        Thread.sleep(2000);
        verifyMatchingElements("Credit Card", By.xpath("//span[normalize-space()='Credit Card']"), "The card type is not credit card");
        verifyMatchingElements("Next Day Air", By.xpath("//span[normalize-space()='Next Day Air']"), "The delivery service is not matching");
        verifyMatchingElements("$2,950.00", By.xpath("//span//strong[contains(text(),'$2,950.00')]"), "The total is not matching");
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        verifyMatchingElements("Thank you", By.xpath("//h1[normalize-space()='Thank you']"), "You are not on the right page");
        verifyMatchingElements("Your order has been successfully processed!", By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"), "You are not on the right page");
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        verifyMatchingElements("Welcome to our store", By.xpath("//h2[normalize-space()='Welcome to our store']"), "You are not on the right page");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}


