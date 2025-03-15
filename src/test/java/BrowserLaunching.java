import org.nithin.testing.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.nithin.testing.Base.randomEmailGenerator;

public class BrowserLaunching {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Java/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(3000);
        String msg = driver.findElement(By.cssSelector("div.signup-form > h2")).getText();
        Assert.assertEquals(msg, "New User Signup!");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("nithin");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("test12368854@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(3000);
//      boolean succesmsg =driver.findElement(By.cssSelector("div > h2.title >b")).i;
//      if (!succesmsg) {
        String emailExists = driver.findElement(By.cssSelector("form > p[style='color: red;']")).getText();
        Assert.assertEquals(emailExists, "Email Address already exist!");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).clear();
        String mailid = randomEmailGenerator();
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(mailid);
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(3000);
//      }


        String signupmsg = driver.findElement(By.cssSelector("div > h2.title >b")).getText();

        Assert.assertEquals(signupmsg, "ENTER ACCOUNT INFORMATION");
        driver.findElement(By.cssSelector("input#id_gender1")).click();
        driver.findElement(By.cssSelector("input#password")).sendKeys("testing@123");
        WebElement days = driver.findElement(By.cssSelector("select#days"));
        WebElement month = driver.findElement(By.cssSelector("select#months"));
        WebElement year = driver.findElement(By.cssSelector("select#years"));

        Select daysDropdown = new Select(days);
        Select monthDropdown = new Select(month);
        Select yearDropdown = new Select(year);
        daysDropdown.selectByIndex(4);
        monthDropdown.selectByValue("6");
        yearDropdown.selectByVisibleText("1999");

        WebElement checkBox = driver.findElement(By.id("newsletter"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(x,y)");
        js.executeScript("arguments[0].scrollIntoView(true)", checkBox);
        js.executeScript("arguments[0].click()", checkBox);
        driver.findElement(By.cssSelector("input#first_name")).sendKeys("Nithin");
        driver.findElement(By.cssSelector("input#last_name")).sendKeys("K S");
        driver.findElement(By.cssSelector("input#address1")).sendKeys("Channapatna");
        driver.findElement(By.cssSelector("input#state")).sendKeys("karnataka");
        driver.findElement(By.cssSelector("input#city")).sendKeys("Ramanagara");
        driver.findElement(By.cssSelector("input#zipcode")).sendKeys("562160");
        driver.findElement(By.cssSelector("input#mobile_number")).sendKeys("7857893567");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

        String creatMsg = driver.findElement(By.cssSelector("div > h2.title > b")).getText();
        Assert.assertEquals(creatMsg, "ACCOUNT CREATED!");
        driver.close();
    }
}
