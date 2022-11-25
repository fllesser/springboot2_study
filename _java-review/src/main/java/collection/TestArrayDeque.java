package collection;

import java.util.ArrayDeque;

public class TestArrayDeque {

    public static void main(String[] args) {
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.add(5);
        integers.add(4);
        integers.add(10);
        integers.add(2);
        integers.add(1);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println("----------------");
        // ArrayDeque 也可以用于实现栈。
        integers.push(1);
        integers.push(2);
        integers.push(3);
        System.out.println(integers.pop());
    }
}
