/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
/*
Runtime: 120 ms, faster than 62.66% of JavaScript online submissions for Add Two Numbers II.
Memory Usage: 39.2 MB, less than 33.33% of JavaScript online submissions for Add Two Numbers II.
*/
var addTwoNumbers = function(l1, l2) {
    let a1 = []
    let a2 = []

    while(l1) {
        a1.push(l1.val)
        l1 = l1.next
    }

    while(l2) {
        a2.push(l2.val)
        l2 = l2.next
    }

    let arr = []
    let jinwei = 0

    for (let i1 = a1.length - 1, i2 = a2.length - 1; i1 >= 0 || i2 >= 0 || jinwei; i1--, i2--) {
        let val = (i1 >= 0 ? a1[i1]  : 0 )+ (i2 >=0 ? a2[i2] : 0) + jinwei
        if (val > 9) {
            arr.unshift(val % 10)
            jinwei = 1
        } else {
            arr.unshift(val)
            jinwei = 0
        }
    }

    let head = new ListNode(arr[0])
    let p = head

    for (let i = 1; i < arr.length; i++) {
        p.next = new ListNode(arr[i])
        p = p.next
    }

    p.next = null

    return head
};


/**
 * XXXXXXXXX
 * Not Accept, 直接相加有大数的问题
 */
var addTwoNumbers_wrong = function(l1, l2) {
    let n1 = 0
    let n2 = 0

    while(l1) {
        n1 = n1 * 10 + l1.val
        l1 = l1.next
    }

    while(l2) {
        n2 = n2 * 10 + l2.val
        l2 = l2.next
    }

    let num = n1 + n2
    let val
    let head = null

    if (num === 0) {
        return new ListNode(0)
    }

    while(num) {
        val = num % 10
        let newH = new ListNode(val)
        newH.next = head
        head = newH
        num = Math.floor(num / 10)
    }

    return head
};