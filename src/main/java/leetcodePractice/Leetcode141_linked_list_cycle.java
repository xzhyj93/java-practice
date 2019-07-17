import leetcodePractice.Utils.ListNode;

import java.util.HashSet;
import java.util.List;

public class Leetcode141_linked_list_cycle {
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();

        while(head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
