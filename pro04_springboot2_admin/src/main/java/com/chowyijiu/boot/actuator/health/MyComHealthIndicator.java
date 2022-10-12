package com.chowyijiu.boot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb
        Map<String, Object> map = new HashMap<>();
        if (1 != 1) {
            //builder.up();//健康
            builder.status(Status.UP);
            map.put("count", 1);
            map.put("ms", 100);
        } else {
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err", "time out");
            map.put("ms", 3000);
        }

        builder.withDetails(map);
    }
}
