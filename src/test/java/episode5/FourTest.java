package episode5;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FourTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void thirdTest() {
        driver.get("https://novaposhta.ua/");
        driver.findElement(By.cssSelector("a[href*=\"office\"]")).click();
        driver.findElement(By.cssSelector("a[href*=\"office/list\"]")).click();
        WebElement Number1 = driver.findElement(By.id("oCityFilter"));
        Number1.sendKeys("м Харків Харківська обл");
        driver.findElement(By.xpath("//*[@id=\"lidb5c88e0-391c-11dd-90d9-001a92567626\"]")).click();
        driver.findElement(By.id("oWarehouseArrow")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[5]/div[2]/div/form/div[1]/div[2]/div/div/div[1]/ul/li[2]")).click();
        driver.findElement(By.cssSelector(".button_search")).click();
        String text= driver.findElement(By.cssSelector(".address")).getText();
        Assertions.assertThat(text).isEqualTo("Харків, вул. Польова, 67");
    }
}
