package episode7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String HTTPS_NOVAPOSHTA_UA = "https://novaposhta.ua/";
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HTTPS_NOVAPOSHTA_UA);
    }

    public void typeCargoNumber(String cargonumber) {
        WebElement cargoNumber = driver.findElement(By.id("cargo_number"));
        cargoNumber.sendKeys(cargonumber);

    }

    public void clickSearchCargo() {
        driver.findElement(By.xpath("//input[@id = 'cargo_number']/../input[2]")).click();
    }
}
