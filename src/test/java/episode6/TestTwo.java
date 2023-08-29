package episode6;
import org.testng.annotations.Test;

public class TestTwo {
    @Test
    public void test1() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("2 - test1");
    }
    @Test
    public void test2() throws InterruptedException {
        System.out.println("2 - test2");
    }
    @Test
    public void toExclude(){
        System.out.println("2 - excluded");
    }
}
