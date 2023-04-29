package SeleniumTest;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class RozetkaTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Yura Kochubailo.000\\Desktop\\Selenium WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }

    @Test
    public void testSearch() {
        driver.get("https://rozetka.com.ua/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='search']"));
        searchBar.click();
        searchBar.sendKeys("iphone 13", Keys.ENTER);
        searchBar.getRect();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
