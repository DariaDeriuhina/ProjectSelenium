package episode6;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Thirdtestt {
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
    @DataProvider(name = "demoDataProvider")
    public Object[][] createSomeData() {
        return new Object[][] {
                { "м. Харків, Харківська обл.", "м. Київ, Київська обл.", "4000", "20", "50", "60", "80", "Flat"},
                { "м. Харків, Харківська обл.", "м. Київ, Київська обл.", "4001", "21", "50", "60", "80", "Flat"},
                { "м. Харків, Харківська обл.", "м. Київ, Київська обл.", "4002", "21", "50", "60", "81", "Flat"}
        };
    }

    @Test(dataProvider = "demoDataProvider")
    public void thirdTest (String st1, String st2, String st4, String st5, String st6, String st7, String st8, String st3) {
            driver.get("https://novaposhta.ua/");
            driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/ul/li[1]/a/span")).click();
            WebElement Number1 = driver.findElement(By.id("DeliveryForm_senderCity"));
            Number1.sendKeys(st1);
            driver.findElement(By.xpath("//*[@id=\"lie71f8842-4b33-11e4-ab6d-005056801329\"]")).click();
            WebElement Number2 = driver.findElement(By.id("DeliveryForm_recipientCity"));
            Number2.sendKeys(st2);
            driver.findElement(By.xpath("//*[@id=\"lie718a680-4b33-11e4-ab6d-005056801329\"]/span")).click();
            WebElement Number3 = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div[6]/div/div/div[1]/div[1]/div[2]/input"));
            Number3.sendKeys(st4);
            WebElement Number4 = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div[6]/div/div/div[1]/div[1]/div[3]/input"));
            Number4.sendKeys(st5);
            WebElement Number5 = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div[6]/div/div/div[1]/div[1]/div[4]/input"));
            Number5.sendKeys(st6);
            WebElement Number6 = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div[6]/div/div/div[1]/div[1]/div[5]/input"));
            Number6.sendKeys(st7);
            WebElement Number7 = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div[6]/div/div/div[1]/div[1]/div[6]/input"));
            Number7.sendKeys(st8);
            WebElement kancheck = driver.findElement(By.id("add-pack"));
            kancheck.click();
            driver.findElement(By.xpath("//*[@id=\"add-pack\"]")).click();
            WebElement Number8 = driver.findElement(By.name("DeliveryForm[packing][1][packType]"));
            Number8.sendKeys(st3);
            driver.findElement(By.xpath("//*[@id=\"packing_row_1\"]/div[1]/div/div/ul/li[45]")).click();
            driver.findElement(By.xpath("//input[@value='Розрахувати вартість']")).click();
            String text = driver.findElement(By.xpath("//*[@id=\"top_block\"]/div[1]/div/form/div[1]/div/div[1]/div[2]/h3[1]")).getText();
            Assertions.assertThat(text).contains("Разом: 2,210.00 ... 2,810.00грн");
        }


@AfterTest
public void tearDown(){
        driver.quit();
        driver = null;
        }
}
