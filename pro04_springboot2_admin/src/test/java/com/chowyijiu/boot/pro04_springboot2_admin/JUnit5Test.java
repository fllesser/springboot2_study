package com.chowyijiu.boot.pro04_springboot2_admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


@DisplayName("JUnit5功能测试类")
@SpringBootTest
public class JUnit5Test {

    @DisplayName("测试display name注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @DisplayName("测试方法test2")
    @Disabled
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    void test3() {
        System.out.println(5);
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) //默认为秒 TimeUnit.SECONDS
    @Test
    void testTimeout() throws InterruptedException {
        System.out.println(1);
        Thread.sleep(600); //这里是毫秒
        System.out.println(2);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试要开始了");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束了");
    }
}
