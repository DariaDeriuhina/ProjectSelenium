package episode5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
public class Test1 {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
// driver = new FirefoxDriver();
// driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void firstTest(){
        driver.get("https://novaposhta.ua/");
        WebElement cargoNumber = driver.findElement(By.id("cargo_number"));
        cargoNumber.sendKeys("20450637303799");
        driver.findElement(By.xpath("//input[@id = 'cargo_number']/../input[2]")).click();
        wait.until(titleIs("Керуйте доставкою посилок Нової пошти"));
// InvalidSelectorException example
// driver.findElement(By.xpath("//input[@value = 'Пошук']]")).click();
        driver.findElement(By.xpath("//*[@id=\"chat\"]/div[2]/button/span")).click();
        String text = driver.findElement(By.cssSelector("div.header__status-text")).getText();
                assertThat(text).contains("Посилка отримана");
    }
    }
