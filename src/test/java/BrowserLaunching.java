import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunching {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Java/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

    }
}
