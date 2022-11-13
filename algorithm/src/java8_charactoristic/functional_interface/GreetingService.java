package java8_charactoristic.functional_interface;

public interface GreetingService {
    void say(String message);
}

class Test {

    public static void main(String[] args) {
        GreetingService greetingService = message -> {
            System.out.println(message);
            System.out.println(message);
        };
        greetingService.say("hello");
    }
}
