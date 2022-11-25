package java8_charactoristic.method_reference;

import java.util.ArrayList;

public class ReferenceTest {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("Test Reference " + i);
        }
        strings.stream().limit(15).forEach(System.out::println);
    }
}
