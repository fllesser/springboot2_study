package com.chowyijiu.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller 的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理数学异常
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public String handleArithmeticException(Exception e) {
        log.error("异常是: " + e);
        return "login";
    }
}
