package lesson7;

import lesson7.annotations.AfterSuite;
import lesson7.annotations.BeforeSuite;
import lesson7.annotations.Test;

public class TestClass {

    @BeforeSuite
    private void beforeTest() {
        System.out.println("before test");
    }

    @Test(priority = 2)
    private void test1() {
        System.out.print("one\n");
    }

    @Test(priority = 1)
    private void test2() {
        System.out.print("two\n");
    }

    @Test
    private void test3() {
        System.out.print("three\n");
    }

    @Test(priority = 5)
    private void test4() {
        System.out.print("four\n");
    }

    @Test(priority = 4)
    private void test5() {
        System.out.print("five\n");
    }

    @Test(priority = 5)
    private void test6() {
        System.out.print("six\n");
    }

    @Test(priority = 1)
    private void test7() {
        System.out.print("seven\n");
    }

    @Test(priority = 1)
    private void test8() {
        System.out.print("eight\n");
    }

    @Test(priority = 3)
    private void test9() {
        System.out.print("nine\n");
    }

    @Test(priority = 2)
    private void test10() {
        System.out.print("ten\n");
    }

    @AfterSuite
    private void afterTest() {
        System.out.println("after test");
    }


    //for testing

    /*@AfterSuite
    private void afterrTest() {
        System.out.println("after test");
    }*/
}
