package collection;

import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(5);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(1);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
    }
}
