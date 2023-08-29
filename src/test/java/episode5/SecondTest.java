package episode5;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void secondTest(){
        driver.get("https://novaposhtaglobal.ua/");
        driver.findElement(By.cssSelector("a[href*=\"track\"]")).click();
        WebElement cargoNumber = driver.findElement(By.cssSelector(".input"));
        cargoNumber.sendKeys("59500000031324");
        driver.findElement(By.cssSelector("div.button.black")).click();
        // wait.until(WebDriver::getTitle("Експрес-накладна посилки № 59500000031324"));
        String text= driver.findElement(By.cssSelector("div.tracking__bill-text")).getText();
        Assertions.assertThat(text).contains("Оформлено замовлення на доставку в країну призначення");
    }
    @AfterTest
   public void tearDown(){
        driver.quit();
        driver = null;
    }
}
//https://novaposhta.ua/