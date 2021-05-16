import java.util.*;



class Solution {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        while(head != null) {
            if(head.ne)

            ListNode next = head.next;
            while(next != null && next.val == head.val) {
                next = next.next;
            }
            head.next = next;
            head = head.next;
    }
        return listNode.next;
}
}