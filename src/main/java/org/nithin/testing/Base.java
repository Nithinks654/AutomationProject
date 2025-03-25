package org.nithin.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Base {

    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor js;

    private static final SecureRandom secureRandom = new SecureRandom();


    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }


    // Get current page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get current page URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Get page source code
    public String getPageSource() {
        return driver.getPageSource();
    }

    // Navigate back
    public void navigateBack() {
        driver.navigate().back();
    }

    // Navigate forward
    public void navigateForward() {
        driver.navigate().forward();
    }

    // Refresh page
    public void refreshPage() {
        driver.navigate().refresh();
    }

    // Open a new tab
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    // Switch to the last opened tab
    public void switchToLastTab() {
        String lastTab = driver.getWindowHandles().toArray()[driver.getWindowHandles().size() - 1].toString();
        driver.switchTo().window(lastTab);
    }

    public void getTextAndValidate(WebElement element,String expectedMessage) {
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }


    // Hover over an element
    public void hoverOverElement(WebElement element) {

        actions.moveToElement(element).perform();
    }

    // Drag and Drop
    public void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }

    // Right-click (Context Click)
    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }
    public void leftClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }


    public void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilClickableAndClick(WebElement element) {
        waitUntilClickable(element);
        element.click();
    }


    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public WebElement getElementInsideShadowRoot(WebElement hostElement, By shadowElement) {
        SearchContext context = hostElement.getShadowRoot();
        return context.findElement(shadowElement);
    }

    public List<WebElement> getElementsInsideShadowRoot(WebElement hostElement, By shadowElement) {
        SearchContext context = hostElement.getShadowRoot();
        return context.findElements(shadowElement);
    }

    public WebElement getElementInsideShadowRootDirect(String hostElement, String shadowElement) {
        WebElement hostEle = driver.findElement(By.cssSelector(hostElement));
        By shadowEle = By.cssSelector(shadowElement);
        return getElementInsideShadowRoot(hostEle, shadowEle);
    }


    // Select by visible text
    public void selectByVisibleText(WebElement dropdown, String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    // Select by value
    public void selectByValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    // Select by index
    public void selectByIndex(WebElement dropdown, int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }


    // Get all elements by locator
    public List<WebElement> getElementsByLocator(By locator) {
        return driver.findElements(locator);
    }

    // Get all elements by element
    public List<WebElement> getElements(String element) {
        return driver.findElements(By.cssSelector(element));
    }

    // Check if an element exists
    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }


    public void clickElement(WebElement element) {
//        waitUntilClickable(element);
        waitUntilVisible(element);
        element.click();
    }

    public void doubleClickElement(WebElement element) {
        waitUntilClickableAndClick(element);
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }


    // Scroll to a specific element
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        scrollLittleUp();
    }


    // Scroll to the bottom of the page
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to the top of the page
    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    // Scroll right by a specified pixel amount
    public void scrollRight(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], 0);", pixels);
    }

    // Scroll left by a specified pixel amount
    public void scrollLeft(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], 0);", -pixels);
    }

    // Scroll down by a specified pixel amount
    public void scrollDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    // Scroll up by a specified pixel amount
    public void scrollUp(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, arguments[0]);", -pixels);
    }

    // Scroll a little down
    public void scrollLittleDown() {
        executeJavaScript("window.scrollBy(0, 150);");
    }

    // Scroll a little up
    public void scrollLittleUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -150);");
    }


    public void switchToIframe(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    public void switchToIframe(String iframeId) {
        driver.switchTo().frame(iframeId);
    }

    public void switchToIframe(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Get current window handle
    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    // Switch to a specific window by title
    public void switchToWindowByTitle(String title) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    // Switch to a specific window by index
    public void switchToWindowByIndex(int index) {
        String windowHandle = driver.getWindowHandles().toArray()[index].toString();
        driver.switchTo().window(windowHandle);
    }


    public WebElement getShadowRootElement(WebElement shadowHost, String cssSelector) {
        return ((SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost))
                .findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> getShadowRootElements(WebElement shadowHost, String cssSelector) {
        return ((SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost))
                .findElements(By.cssSelector(cssSelector));
    }


    public void clickUsingJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public String getInnerTextUsingJS(WebElement element) {
        return (String) js.executeScript("return arguments[0].innerText;", element);
    }

    public void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }


    // Double click an element
    public void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    // Click and hold an element
    public void clickAndHold(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();
    }

    // Release an element after clicking and holding
    public void releaseElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.release(element).perform();
    }


    // Execute custom JavaScript
    public Object executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script, args);
    }

    // Scroll to a specific pixel position
    public void scrollToPixelPosition(int x, int y) {
        executeJavaScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }

    // Simulate pressing Enter key using JavaScript
    public void pressEnterUsingJS(WebElement element) {
        executeJavaScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {'key': 'Enter'}));", element);
    }

    // Add a new cookie
    public void addCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    // Get a specific cookie by name
    public String getCookieValue(String name) {
        Cookie cookie = driver.manage().getCookieNamed(name);
        return (cookie != null) ? cookie.getValue() : null;
    }

    // Delete a specific cookie
    public void deleteCookie(String name) {
        driver.manage().deleteCookieNamed(name);
    }

    // Delete all cookies
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }


    // Accept alert (Click OK)
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss alert (Click Cancel)
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // Get alert text
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    // Send text to alert input box
    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    // Press Enter key on an element
    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    // Press Tab key on an element
    public void pressTab() {
        actions.sendKeys(Keys.TAB).build().perform();
    }

    // Press Escape key
    public void pressEscape() {
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    // Press Backspace key
    public void pressBackspace() {
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
    }

    // Press Space key
    public void pressSpace() {
        actions.sendKeys(Keys.SPACE).build().perform();
    }

    // Press Down Arrow key
    public void pressArrowDown() {
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
    }

    // Press Up Arrow key
    public void pressArrowUp() {
        actions.sendKeys(Keys.ARROW_UP).build().perform();
    }

    // Press Left Arrow key
    public void pressArrowLeft(WebElement element) {
        element.sendKeys(Keys.ARROW_LEFT);
    }

    // Press Right Arrow key
    public void pressArrowRight(WebElement element) {
        element.sendKeys(Keys.ARROW_RIGHT);
    }

    public static String generateRandomString(int length) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int character = secureRandom.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    public static String generateRandomNumericString(int length) {
        String NUMERIC_STRING = "0123456789";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = secureRandom.nextInt(NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(digit));
        }
        return builder.toString();
    }

    public static String randomEmailGenerator() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <= 5; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "test" + randomString + timeStamp + "@gmail.com";
    }

}
