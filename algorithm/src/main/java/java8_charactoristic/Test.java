package java8_charactoristic;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        integers.forEach(System.out::println);
        integers.forEach(Test::print);
    }

    public static void print(Object str) {
        System.out.println(str);
    }
}
