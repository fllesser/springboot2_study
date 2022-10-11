package com.chowyijiu.boot.pro04_springboot2_admin;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@DisplayName("参数化测试")
public class TestParameterized {

    @ParameterizedTest
    @DisplayName("test1")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void test1(int i) {
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("test2")
    @MethodSource("stringProvider")
    void test2(String i) {
        System.out.println(i);
    }

    static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }
}
