package junittesting;

import org.junit.jupiter.api.*;

/**
 * @created : 17/04/2026,15:38,ven.
 **/
public class JunitTestDemo1 {
    @BeforeAll
    public static void beforAll(){
        System.out.println("befor all execution,only once");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each execution");
    }
@Test
    public void addCustomerTest(){
        System.out.println("this is Add Customer Test");
        Assertions.assertTrue(1>0);
    }

    @Disabled
    @Test
    public void updateCustomerTest(){
        System.out.println("this is Update Customer Test");
        Assertions.assertTrue(1>3);
    }
    @RepeatedTest(5)
    public void deleteCustomerTest(){
        System.out.println("this is Delete Customer Test");
    }
    @AfterEach
    public void afterEach(){
        System.out.println("after each execution");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after all execution, only once");
    }

}

