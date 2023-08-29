package episode7;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class PageObjectResult extends BaseTest {
    @Test
    public void firstTest(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.typeCargoNumber("59000701618908");
        homePage.clickSearchCargo();
        TrackingPage trackingPage = new TrackingPage(driver);
        trackingPage.waitForLoad();
        trackingPage.clickSearchCargo();
        String text = trackingPage.getMessageText();
        assertThat(text).contains("видана");
    }
}
