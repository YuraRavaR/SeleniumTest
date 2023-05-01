package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;


public class AmazonTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void VerifyNavigationToWomensWalkingShoes() {
        driver.get("http:\\amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Shoes", Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("Shoes"));
        WebElement womensWalkingShoesCategory = driver.findElement(By.xpath("//span[@class='a-list-item']//span[contains(text(), \"Women's Walking Shoes\")]"));
        womensWalkingShoesCategory.click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class= 'a-size-base a-color-base a-text-bold']")).isDisplayed());


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
