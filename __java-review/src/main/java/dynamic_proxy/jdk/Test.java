package dynamic_proxy.jdk;

public class Test {


    /**
     * jdk动态代理最致命的问题就是, 它只能代理实现了接口的类!!!, 而cglib动态代理解决了这个问题
     * @param args
     */
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("hello jdk ");

    }
}
