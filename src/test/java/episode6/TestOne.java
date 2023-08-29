package episode6;

import org.testng.annotations.*;
public class TestOne {
    @BeforeSuite
    public void beforeSuite(){
        System.out.print("1 - beforeSuite");
    }
    @BeforeGroups
    public void beforeGroup(){
        System.out.print("1 - beforeGroup");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.print("1 - beforeClass");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.print("1 - beforeTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.print("1 - beforeMethod");
    }
    @Test
    public void test1(){
        System.out.print("1 - test1");
    }
    @Test
    public void test2(){
        System.out.print("1 - test2");
    }
    @Test
    public void test3(){
        System.out.print("1 - test3");
    }
}
