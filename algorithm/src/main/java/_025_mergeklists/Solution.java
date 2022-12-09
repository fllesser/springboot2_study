package _025_mergeklists;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode l = new Solution().mergeKLists2(new ListNode[]{l1, l2, l3});
        while (l.next != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode res = new ListNode();
        res = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
            if (l1 == null) {
                temp.next = l2;
            } else if (l2 == null) {
                temp.next = l1;
            }
        }
        return head.next;
    }

    // 失败品
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        TreeMap<Integer, NAL> map = new TreeMap<>();
        for (ListNode node : lists) {
            while (node != null) {
                if (!map.containsKey(node.val)) {
                    map.put(node.val, new NAL(node));
                } else {
                    map.get(node.val).add();
                }
                node = node.next;
            }
        }
        ListNode res = new ListNode();
        ListNode temp = res;
        for (Integer i : map.keySet()) {
            temp.next = map.get(i).head;
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        return res.next;
    }

    class NAL {
        ListNode head;
        ListNode tail;
        NAL(ListNode node) {
            node = new ListNode(node.val);
            this.head = node;
            this.tail = node;
        }

        void add() {
            tail.next = new ListNode(head.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}