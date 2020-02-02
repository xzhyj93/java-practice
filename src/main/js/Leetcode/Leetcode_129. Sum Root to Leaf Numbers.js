/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
function TreeNode(val) {
    this.val = val
    this.left = this.right = null
}
/**
 * @param {TreeNode} root
 * @return {number}
 */

/*
    Runtime: 60 ms, faster than 52.43% of JavaScript online submissions for Sum Root to Leaf Numbers.
    Memory Usage: 34.4 MB, less than 50.00% of JavaScript online submissions for Sum Root to Leaf Numbers.
*/
var sumNumbers = function(root) {
    let total = 0

    if (!root) {
        return 0
    }

    root.value = root.val

    dfs(root)

    function dfs(root) {
        if (root.left || root.right) {
            if (root.left) {
                root.left.value = root.value * 10 + root.left.val
                dfs(root.left)
            }
    
            if (root.right) {
                root.right.value = root.value * 10 + root.right.val
                dfs(root.right)
            }
        } else {
            total += root.value
        }
        
    }
    
    return total
};