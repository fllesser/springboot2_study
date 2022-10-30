package _004_merget_twolist;

public class Solution {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        ListNode listNode = new Solution().mergeTwoLists(list1, list2);
        System.out.println(listNode);
    }

    /**
     * 合并两个有序单向链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode node = new ListNode();
        ListNode temp = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
            if (list1 == null) {
                temp.next = list2;
            } else if (list2 == null) {
                temp.next = list1;
            }
        }
        return node.next;
    }
}
