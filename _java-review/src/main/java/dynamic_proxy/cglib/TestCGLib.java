package dynamic_proxy.cglib;

public class TestCGLib {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("hello cglib");
    }
}
