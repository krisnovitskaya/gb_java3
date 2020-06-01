package less07;

import less07.annotation.AfterSuite;
import less07.annotation.BeforeSuite;
import less07.annotation.Test;

public class ClassForTest1 {


    @BeforeSuite
    public void go(){

        System.out.println("Before go");
    }



    @Test(priority = 2)
    public void test1(){
        System.out.println("test1 priority 2 done.");
    }
    @Test(priority = 2)
    public void test2(){
        System.out.println("test2 priority 2 done.");
    }
    @Test(priority = 8)
    public void test3(){
        System.out.println("test3 priority 8 done.");
    }
    @Test
    public void test4(){
        System.out.println("test4 priority (default = 5) done.");
    }
    @Test(priority = 1)
    public void test5(){
        System.out.println("test5 priority 1 done.");
    }



    @AfterSuite
    public void end(){

        System.out.println("After end");
    }
//    @AfterSuite
//    public void end2(){
//
//        System.out.println("After end");
//    }
}
