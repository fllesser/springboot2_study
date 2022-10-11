package com.chowyijiu.boot.pro04_springboot2_admin;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("前置条件测试")
@SpringBootTest
public class AssumptionsTest {

    @Test
    @Disabled
    void test1() {
        Assumptions.assumeTrue(false, "结果不是true");
        System.out.println("1111");
    }
}
