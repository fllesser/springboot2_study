package java8_charactoristic.stream_;


import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        Long aLong = Stream.iterate(2L, i -> i + 1).limit(3).reduce(Long::sum).get();
        System.out.println(aLong);
        Node a = new Node(0);
        AtomicInteger start = new AtomicInteger(0);
        Node node = Stream.iterate(a, j -> {
            if (j.next == null) {
                j.next = new Node(start.incrementAndGet());
            }
            return j.next;
        }).limit(10).reduce(Node::sum).get();
        System.out.println(node);

        System.out.println();
        Stream.iterate(a, i -> i.next).limit(10).forEach(System.out::println);
        IntStream intStream = new Random().ints().limit(10).distinct();
        intStream.forEach(System.out::println);
//        IntSummaryStatistics intSummaryStatistics = intStream.summaryStatistics();
//        System.out.println(intSummaryStatistics.getAverage());
    }

    static class Node {
        Node next;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public static Node sum(Node n1, Node n2) {
            return new Node(n1.value + n2.value);
        }
    }
}

