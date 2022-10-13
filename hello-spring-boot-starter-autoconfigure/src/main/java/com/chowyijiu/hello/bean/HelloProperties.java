package com.chowyijiu.hello.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("chowyijiu.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public HelloProperties() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
