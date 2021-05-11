import java.util.*;

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        while(l1 != null && l2 != null) {
            int num1 = l1.val;
            int num2 = l2.val;
            if(num1 <= num2) {
                listNode.next = new ListNode(num1);
                l1 = l1.next;
            } else {
                listNode.next = new ListNode(num2);
                l2 = l2.next;
            }
            listNode = listNode.next;
        }

        while(l1 != null) {
                listNode.next = new ListNode(l1.val);
                l1 = l1.next;
            listNode = listNode.next;
        }

        while(l2 != null) {
            listNode.next = new ListNode(l2.val);
            l2 = l2.next;
            listNode = listNode.next;
        }
        return head.next;
        
    }
}