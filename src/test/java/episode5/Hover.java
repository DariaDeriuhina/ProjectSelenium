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
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Hover {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
// driver = new FirefoxDriver();
// driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void hoverTest(){
        driver.get("https://floralife.com.ua/about-plants/");
        WebElement element = driver.findElement(By.cssSelector(".w-100"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        String actualText = element.getAttribute("title");
        String expectedText = "Чайные растения";

        // Сравните ожидаемый и фактический тексты
        if (actualText.equals(expectedText)) {
            System.out.println("Ховер-текст совпадает.");
        } else {
            System.out.println("Ховер-текст не совпадает. Фактический текст: " + actualText);
        }

        // Закройте браузер и выход из драйвера
        driver.quit();
    }
}

