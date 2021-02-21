package inid.lhz.test;

import inid.lhz.day07.demo01.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 初始化方法
     * 用于资源申请,所有测试方法在执行之前都会先执行改方法
     */
    @Before
    public void init() {
        System.out.println("int...");
    }

    /**
     * 释放资源方法
     * 用于资源释放,所有测试方法在执行之后都会先执行改方法
     */
    @After
    public void close() {
        System.out.println("close...");
    }

    /**
     * 添加calculator add的测试方法
     */
    @Test
    public void testadd() {
        Calculator c = new Calculator();
        int result = c.add(1, 2);

        //断言,我断言这个结果是3; 3是预期结果,result是真实结果,如果两个值不一样则断言失败
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        int sub = calculator.sub(100, 10);
        //断言
        Assert.assertEquals(90, sub);
    }
}
