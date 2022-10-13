package com.chowyijiu.boot.pro06_admin_server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Pro06AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pro06AdminServerApplication.class, args);
    }

}
