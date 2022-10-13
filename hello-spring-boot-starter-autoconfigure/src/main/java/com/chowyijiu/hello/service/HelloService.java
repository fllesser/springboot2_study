package com.chowyijiu.hello.service;

import com.chowyijiu.hello.bean.HelloProperties;

import javax.annotation.Resource;

/**
 * 默认不要放在容器中
 */
public class HelloService {

    @Resource
    HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + ":" + userName + ">" + helloProperties.getSuffix();
    }
}
