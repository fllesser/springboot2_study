package _024_swappairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;
        ListNode tmp = new ListNode(0, head);
        ListNode l = head;
        ListNode r = head.next;
        while (l != null && r != null) {
            tmp.next = r;
            l.next = r.next;
            r.next = l;

            tmp = l;
            l = l.next;
            if (l != null) r = l.next; //
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

