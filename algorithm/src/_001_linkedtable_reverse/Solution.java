package _001_linkedtable_reverse;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverse1(listNode1);
        //reverse2(listNode5);
        System.out.println(listNode5);

    }

    public static void reverse1(ListNode listNode) {
        ListNode temp = listNode.next;
        if (temp != null) {
            reverse1(temp);
            temp.next = listNode;
            listNode.next = null;
        }
    }

    public static void reverse2(ListNode listNode) {
        while (listNode.next != null) {
            ListNode temp = listNode;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next.next = temp;
            temp.next = null;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        ListNode result = temp;
        while (head.next != null) {
            temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next.next = temp;
            temp.next = null;
        }
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
