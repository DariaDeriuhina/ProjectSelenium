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
public class FifthTest {
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
        driver.findElement(By.cssSelector("a[href*=\"estimatedate\"]")).click();
        WebElement Number1 = driver.findElement(By.id("EstimateDateForm_serviceType"));
        Number1.sendKeys("Адреса-Адреса");
        driver.findElement(By.id("DoorsDoors")).click();
        WebElement Number2 = driver.findElement(By.id("EstimateDateForm_senderCity"));
        Number2.sendKeys("Дніпро");
        driver.findElement(By.xpath("//*[@id=\"lidb5c88f0-391c-11dd-90d9-001a92567626\"]")).click();
        WebElement Number3 = driver.findElement(By.id("EstimateDateForm_recipientCity"));
        Number3.sendKeys("Київ");
        driver.findElement(By.xpath("//*[@id=\"li8d5a980d-391c-11dd-90d9-001a92567626\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div[1]/form/div[2]/input[1]")).click();
        String text= driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div[1]/form/div[1]/div[1]/div/b")).getText();
        Assertions.assertThat(text).isEqualTo("26 січня 2023 18:00");
    }

}