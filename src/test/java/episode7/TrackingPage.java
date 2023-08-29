package episode7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TrackingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TrackingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForLoad() {
        wait.until(titleIs("Керуйте доставкою посилок Нової пошти"));
    }

    public void clickSearchCargo() {
        driver.findElement(By.xpath("//input[@value = 'Пошук']")).click();
    }

    public String getMessageText() {
        return driver.findElement(By.cssSelector(".np-message")).getText();
    }
}