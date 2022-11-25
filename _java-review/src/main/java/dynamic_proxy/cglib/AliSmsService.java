package dynamic_proxy.cglib;

public class AliSmsService {

    public String send(String message) {
        System.out.println(message);
        return message;
    }
}
