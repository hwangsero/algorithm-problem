import java.util.*;

class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        int num = 0;
        while(l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1+num2+num;
            num = sum / 10;
            sum %= 10;
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(num > 0) {
            listNode.next = new ListNode(num);
        }
        return head.next;
    }
}