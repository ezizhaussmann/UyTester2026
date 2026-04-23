package testng_tests;

import org.testng.annotations.*;

/**
 * @created : 21/04/2026,20:12,mar.
 **/
public class TestNGDemo1 {
    @BeforeClass
    public void beforeclass(){
        System.out.println("this is from TestNGDemo1");
    }
    
    @BeforeMethod
    public void beforemethod() {
        System.out.println("this is from TestNGDemo1 before method");
    }
    
    @AfterMethod
    public void aftermethod() {
        System.out.println("this is from TestNGDemo1 after method");
    }

    @Test
    public void test1(){
        System.out.println("this is from TestNGDemo1 test1");
    }
    
    @AfterClass
    public void afterclass(){
        System.out.println("this is from TestNGDemo1");
    }
}
