package episode7;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
public class DemoTestAfter extends BaseTest {
    @Test
    public void firstTest(){
        driver.get("https://novaposhta.ua/");
        WebElement cargoNumber =
                driver.findElement(By.id("cargo_number"));
        cargoNumber.sendKeys("59000701618908");
        driver.findElement(By.xpath("//input[@id = 'cargo_number']/../input[2]")).click();
        wait.until(titleIs("Керуйте доставкою посилок Нової пошти"));
        driver.findElement(By.xpath("//input[@value = 'Пошук']")).click();
        String text = driver.findElement(By.cssSelector(".np- message")).getText();
                assertThat(text).contains("видана");
    }
}
