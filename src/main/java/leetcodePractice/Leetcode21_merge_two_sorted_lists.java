import java.util.List;

public class Leetcode21_merge_two_sorted_lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null, p= null;

        if (l1 == null) {
            result = l2;
        } else if (l2 == null) {
            result = l1;
        } else if (l1.val <= l2.val) {
            result = l1;
            p = result;
        } else {
            result = l2;
            p = result;
            l2 = l1;
        }

        if (result != null) {
            p = result;
        }

        while(l2 != null) {
            if (p.next == null) {
                p.next = l2;
                break;
            } else {
                while(p.next != null && p.next.val < l2.val) {
                    p = p.next;
                }
                ListNode q = new ListNode(l2.val);
                q.next = p.next;
                p.next = q;
                p = p.next;
                l2 = l2.next;
            }
        }

        return result;
    }
}
