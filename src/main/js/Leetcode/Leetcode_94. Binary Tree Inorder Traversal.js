/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
document.write("<script language=javascript src='utils/TreeNode.js'></script>")

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
/*
    使用 stack
    1
     \
      3
     /
    2
*/
var inorderTraversal = function(root) {
    if (!root) return []

    let stack = []
    let result = []

    let p = root 

    while(p || stack.length) {
        while(p) {
            stack.push(p)
            p = p.left
        }
        p = stack.pop()
        result.push(p.val)
        p = p.right
    }

    return result
}

/*
递归方法：
    Runtime: 44 ms, faster than 98.72% of JavaScript online submissions for Binary Tree Inorder Traversal.
    Memory Usage: 34 MB, less than 12.50% of JavaScript online submissions for Binary Tree Inorder Traversal.

    Runtime: 120 ms, faster than 5.57% of JavaScript online submissions for Binary Tree Inorder Traversal.
    Memory Usage: 33.7 MB, less than 81.25% of JavaScript online submissions for Binary Tree Inorder Traversal.
*/
var inorderTraversal_recursive = function(root) {
    let result = []
    inorder(root)

    function inorder(root) {
        if (!root) return
        inorder(root.left)
        result.push(root.val)
        inorder(root.right)
    }

    return result
};

window.onload = function() {
    const tree = generateTreeNode([1, null, 2, 3])
    console.log(tree)
    console.log(inorderTraversal(tree))
}
