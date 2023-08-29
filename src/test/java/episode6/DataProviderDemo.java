package episode6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderDemo {
    @DataProvider(name = "demoDataProvider")
    public Object[][] createSomeData() {
        return new Object[][] {
                { "One", 1, "First"},
                { "Two", 2, "Second"},
        };
    }
    @Test(dataProvider = "demoDataProvider")
    public void verifyData1(String st, int in, String st2) {
        System.out.println(st + " = " + in + ", " + st2);
    }
}
