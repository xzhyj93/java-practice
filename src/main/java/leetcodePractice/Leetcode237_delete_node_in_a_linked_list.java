package leetcodePractice;

import leetcodePractice.Utils.ListNode;

/**
 * Created by 祁连山 on 2019/7/16.
 */
public class Leetcode237_delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
