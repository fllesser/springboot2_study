package dynamic_proxy.cglib;

public class Test {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("hello cglib");
    }
}
