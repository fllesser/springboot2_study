package com.chowyijiu.boot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myservice")
public class MyServiceEndpoint {

    @ReadOperation
    public Map<String, Object> getDockerInfo() {
        //http://localhost:8080/actuator/myservice
        return Collections.singletonMap("dockInfo", "docker started...");
    }

    @WriteOperation
    public void stopDocker() {
        System.out.println("dock stopped...");
    }
}
