package dynamic_proxy.cglib;

public class TestCGLib {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        String hello_cglib = proxy.send("hello cglib");
        System.out.println(hello_cglib);
    }
}
