package com.chowyijiu.boot.pro04_springboot2_admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("断言测试")
@SpringBootTest
public class AssertTest {

    JdbcTemplate jdbcTemplate;


    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        assertEquals(5, cal, "业务逻辑计算失败");
        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1, o1, "不是同一个对象");
    }

    @Test
    @DisplayName("Array assertion")
    void testAssertArray() {
        int[] array = {1, 2};
        //assertEquals(new int[]{1, 2}, new int[]{1, 2}, "不是同一个数组对象");
        assertEquals(array, array, "不是同一个数组对象");
    }

    @Test
    @DisplayName("组合断言")
    void testAll() {
        assertAll("test",
                () -> assertTrue(true && true),
                () -> assertEquals(1, 1));
    }

    @DisplayName("异常断言")
    @Test
    void testException() {
        //断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class, () -> {int i = 10 / 0;},"业务逻辑正常运行");
        //如果测试方法时间超过1s将会异常
            assertTimeout(Duration.ofSeconds(1L), () -> Thread.sleep(100), "业务逻辑没有超时");
    }

    @DisplayName("快速失败")
    @Test
    void testFail() {
        if (1 != 1) {
            fail("测试失败");
        }
    }


    int cal(int i, int j) {
        return i + j;
    }
}
