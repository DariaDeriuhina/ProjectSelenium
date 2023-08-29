package episode5;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Firsttest {
    @Test
    public void firsttest(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("http://google.com/");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium-java");

        driver.findElement(By.xpath("//input[@value='Поиск в Google']")).click();
        String text = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertThat(text).contains("Selenium");
        driver.quit();
    }
}
