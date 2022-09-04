package com.chowyijiu.boot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pet {
    private String name;
    private Double weight;

}
