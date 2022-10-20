package _001_linkedtable_reverse;

public class Solution {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverse1(node1);
        //reverse2(node5);
        System.out.println(node5);

    }

    public static void reverse1(Node node) {
        Node temp = node.next;
        if (temp != null) {
            reverse1(temp);
            temp.next = node;
            node.next = null;
        }
    }

    public static void reverse2(Node node) {
        while (node.next != null) {
            Node temp = node;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next.next = temp;
            temp.next = null;
        }
    }

}
