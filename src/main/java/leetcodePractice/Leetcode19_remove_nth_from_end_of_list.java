import leetcodePractice.Utils.ListNode;

import java.util.List;

public class Leetcode19_remove_nth_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode tail = head;

        int i = 1;

        while(i < n) {
            i++;
            tail = tail.next;
        }

        if (tail.next == null) {
            return head.next;
        }

        tail = tail.next;

        while(tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;

    }
}
