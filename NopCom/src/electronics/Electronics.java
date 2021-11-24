package electronics;

import net.bytebuddy.utility.RandomString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class Electronics extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonePageSuccessfully() throws InterruptedException {
        actionMouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"),By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        verifyMatchingElements("Cell phones",By.xpath("//h1[normalize-space()='Cell phones']"),"You are not on the cell phone page");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='List']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
        Thread.sleep(2000);
        verifyMatchingElements("Nokia Lumia 1020",By.xpath("//h1[text()='Nokia Lumia 1020']"),"You are not on the right page");
        Thread.sleep(2000);
        verifyMatchingElements("$349.00",By.xpath("//span[text()=' $349.00 ']"),"The price is not matching");
        Thread.sleep(2000);
        clearText(By.xpath("//input[@value='1']"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@value='1']"),"2");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[7]//div[1]//button[1]"));
        verifyMatchingElements("The product has been added to your shopping cart",By.xpath("//p[text()='The product has been added to your ']"),"The items not been added to cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);
        actionMouseHoverAndClick(By.xpath("//span[text()='Shopping cart']"),By.xpath("//button[text()='Go to cart']"));
        Thread.sleep(2000);
        verifyMatchingElements("Shopping cart",By.xpath("//h1[normalize-space()='Shopping cart']"),"You are not on right page");
        Thread.sleep(2000);
        String expectedMessage = "2";
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.xpath("//input[@value='2']")).getAttribute("value");
        Thread.sleep(2000);
        Assert.assertEquals("Qty is not matching", expectedMessage, actualMessage);
        Thread.sleep(2000);
        verifyMatchingElements("$698.00",By.xpath("//span[@class='product-subtotal']"),"The total is not matching");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);
        verifyMatchingElements("Welcome, Please Sign In!",By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"You are not on a right page");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        Thread.sleep(2000);
        verifyMatchingElements("Register",By.xpath("//h1[normalize-space()='Register']"),"You are not on the register page");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        Thread.sleep(2000);
        sendTextToElement(By.id("FirstName"),"Ram");
        Thread.sleep(2000);
        sendTextToElement(By.id("LastName"),"Kumar");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"9");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"8");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1980");
        Thread.sleep(2000);
        RandomString rnd = new RandomString(10);
        String randString= rnd.nextString();
        sendTextToElement(By.id("Email"),randString+"@gmail.com");
        Thread.sleep(2000);
        sendTextToElement(By.id("Password"),"Abc123");
        Thread.sleep(2000);
        sendTextToElement(By.id("ConfirmPassword"),"Abc123");
        Thread.sleep(2000);
        clickOnElement(By.id("register-button"));
        Thread.sleep(2000);
        verifyMatchingElements("Your registration completed",By.xpath("//div[@class='result']"),"Registration is not complete");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        verifyMatchingElements("Shopping cart",By.xpath("//h1[normalize-space()='Shopping cart']"),"You are not on a right page");
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"133");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Vadodara");
        sendTextToElement(By.xpath("//input[@data-val-required='Street address is required']"),"9 Ayodhyay Apartments");
        sendTextToElement(By.xpath("//input[@data-val-required='Zip / postal code is required']"),"391440");
        sendTextToElement(By.xpath("//input[@type='tel']"),"00919825336419");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='2nd Day Air___Shipping.FixedByWeightByTotal']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Payments.Manual']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@name='CreditCardType']"),"visa");
        sendTextToElement(By.xpath("//input[@name='CardholderName']"),"Ram Kumar");
        sendTextToElement(By.xpath("//input[@name='CardNumber']"),"4111 1111 1111 1111");
        selectByValueFromDropDown(By.xpath("//select[@name='ExpireMonth']"),"3");
        selectByValueFromDropDown(By.xpath("//select[@name='ExpireYear']"),"2025");
        sendTextToElement(By.xpath("//input[@name='CardCode']"),"756");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));
        Thread.sleep(2000);
        verifyMatchingElements("Credit Card",By.xpath("//span[normalize-space()='Credit Card']"),"The payment method is not right");
        Thread.sleep(2000);
        verifyMatchingElements("2nd Day Air",By.xpath("//span[normalize-space()='2nd Day Air']"),"The shipping type is not right");
        Thread.sleep(2000);
        verifyMatchingElements("$698.00",By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"),"The total is not matching");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        Thread.sleep(2000);
        verifyMatchingElements("Thank you",By.xpath("//h1[normalize-space()='Thank you']"),"You are not on a right page");
        Thread.sleep(2000);
        verifyMatchingElements("Your order has been successfully processed!",By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),"You are not on a right page");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        Thread.sleep(2000);
        verifyMatchingElements("Welcome to our store",By.xpath("//h2[normalize-space()='Welcome to our store']"),"YOu are not on a right page");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Log out']"));
        Thread.sleep(2000);
        String actualMessage1=driver.getCurrentUrl();
        Thread.sleep(2000);
        String expectedMessage1= "https://demo.nopcommerce.com/";
        Assert.assertEquals("You are not on a right page",expectedMessage1,actualMessage1);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}
