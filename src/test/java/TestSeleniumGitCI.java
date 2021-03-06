import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSeleniumGitCI
{
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(120);

    }
    @Test
    public void userLogin() throws InterruptedException {
        WebElement searchTxt = driver.findElement(By.name("q"));
        searchTxt.sendKeys("automation" + Keys.ENTER);
        //WebElement submitBtn = driver.findElement(By.name("btnK"));
        //submitBtn.click();
        System.out.println("Current URL is:" + driver.getCurrentUrl());
        Assert.assertTrue(driver.getTitle().contains("automation - Google Search"));
        System.out.println("Current Title is:" + driver.getTitle());

    }
    @AfterClass
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}