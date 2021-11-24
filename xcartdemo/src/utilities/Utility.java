package utilities;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will click element
     *
     * @param by
     */

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    /**
     * This Method get text from element
     *
     * @param by
     * @return
     */

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    /**
     * This method will send text on element
     *
     * @param by
     * @param text
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void clearText(By by){
        driver.findElement(by).clear();
    }

    /**
     * Method will select the text from Dropdown menu by visible text
     *
     * @param by
     * @param text
     */

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    /**
     * Method will select the element from the dropdown by value
     *
     * @param by
     * @param value
     */

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown1 = driver.findElement(by);
        Select select = new Select(dropDown1);
        select.selectByValue(value);

    }

    /**
     * Method will select the element by index number
     *
     * @param by
     * @param index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        WebElement dropdown2 = driver.findElement(by);
        Select select = new Select(dropdown2);
        select.selectByIndex(index);
    }

    /**
     * Method will accept the alert
     */
    public void alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    /**
     * Method will dismiss the alert
     */
    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Mehod will get the text from alert
     */
    public String alertGetText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();

    }

    /**
     * Method will send the text to alert if needed
     *
     * @param alertText
     */
    public void alertSendKeys(String alertText) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(alertText);
    }

    /**
     * Method will perform drag and drop action
     *
     * @param drag
     * @param drop
     */
    public void actionDragAndDrop(By drag, By drop) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(drag);
        WebElement droppable = driver.findElement(drop);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }

    /**
     * Method will perform Right click action on the mouse
     *
     * @param by
     */
    public void actionRightClick(By by) {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick().build().perform();
    }

    /**
     * Method will move slider to given parameter place
     *
     * @param by
     * @param x
     * @param y
     */
    public void actionSlider(By by, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(by);
        actions.dragAndDropBy(slider, x, y).build().perform();
    }

    public void actionMouseHoverAndClick(By main, By list) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        WebElement hover1 = driver.findElement(list);
        actions.moveToElement(hover).moveToElement(hover1).click().build().perform();

    }

    public void actionMouseHover(By main) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        actions.moveToElement(hover).click().build().perform();
    }

    public void actionMouseHoverOnly(By main) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(main);
        actions.moveToElement(hover).build().perform();
    }

    public void verifyMatchingElements(String expectedMessage, By by, String message) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(message, expectedMessage, actualMessage);
    }
    public void sortDataFromElementsAndVerifySorting(By by) {
        List<WebElement> name = driver.findElements(by);
        String[] beforesort = new String[name.size()];
        for (int i = 0; i < name.size(); i++) {
            beforesort[i] = name.get(i).getText().trim();
        }
        Arrays.sort(beforesort);
        WebElement sort = driver.findElement(by);
        sort.click();
        name = driver.findElements(by);
        String[] aftersort = new String[name.size()];

        for (int i = 0; i < name.size(); i++) {
            aftersort[i] = name.get(i).getText().trim();
            Assert.assertArrayEquals("Elements are not sorted", beforesort, aftersort);
        }
    }



}
