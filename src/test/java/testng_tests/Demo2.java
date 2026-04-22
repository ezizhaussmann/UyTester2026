package testng_tests;

import org.testng.annotations.*;

/**
 * @created : 21/04/2026,19:51,mar.
 **/
public class Demo2 {
    @BeforeClass
    public void beforeclass(){
        System.out.println("this is from demo2");
    }
    @BeforeMethod
    public void beforemethod() {
        System.out.println("this is from demo2 before method");
    }
    @AfterMethod
    public void aftermethod() {
        System.out.println("this is from demo2 after method");
    }

    @Test
    public void test1(){
        System.out.println("this is from demo2 test1 ✅ ");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("this is from demo2");
    }
}
