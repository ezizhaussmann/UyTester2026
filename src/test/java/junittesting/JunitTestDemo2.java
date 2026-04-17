package junittesting;

import org.junit.jupiter.api.*;

/**
 * @created : 17/04/2026,15:38,ven.
 **/
@TestMethodOrder(MethodOrderer.class)
public class JunitTestDemo2 {
    @BeforeAll
    public static void beforAll(){
        System.out.println("befor all execution,only once");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each execution");
    }
@Test
@Order(1)
    public void addCustomerTest(){
        System.out.println("this is Add Customer Test");
        Assertions.assertTrue(1>0);
    }


    @Test
    @Order(3)
    public void updateCustomerTest(){
        System.out.println("this is Update Customer Test");
        Assertions.assertTrue(1>=1);
    }
//    @Repeated
//    Test(5)
    @Test
    @Order(2)
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

