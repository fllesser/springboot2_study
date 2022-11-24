package collection;

import java.util.PriorityQueue;

public class TestPriorityQueue {

    //可以接收一个 Comparator 作为构造参数，从而来自定义元素优先级的先后。
    public static void main(String[] args) {
        PriorityQueue<Person> peoples = new PriorityQueue<>((p1, p2) -> p2.age.compareTo(p1.age));
        peoples.add(new Person("xiaohong", 20));
        peoples.add(new Person("xiaoming", 21));
        peoples.add(new Person("xiaoxixi", 24));
        peoples.add(new Person("xiaohaha", 18));
        peoples.add(new Person("xiaonainiu", 17));
        System.out.println(peoples.poll());
        System.out.println(peoples.poll());
        System.out.println(peoples.poll());
        System.out.println(peoples.poll());
        System.out.println(peoples.poll());
    }
}

class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
