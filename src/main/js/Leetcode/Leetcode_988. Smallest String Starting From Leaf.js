/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/    
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

var smallestFromLeaf1 = function(root) {
    let result = '~'

    if (!root) {
        return ''
    }
    root.val = toChar(root.val)

    dfs(root)

    function toChar(num) {
        return String.fromCharCode(num + 'a'.charCodeAt(0))
    }

    function dfs(root) {
        if (root.left || root.right) {
            if (root.left) {
                root.left.val = toChar(root.left.val) + root.val
                dfs(root.left)
            }

            if (root.right) {
                root.right.val = toChar(root.right.val) + root.val
                dfs(root.right)
            }
        } else {
            if (root.val < result) {
                result = root.val
            }
        }
    }

    return result
};
/**
 * @param {TreeNode} root
 * @return {string}
 */
/*
    Runtime: 144 ms, faster than 7.94% of JavaScript online submissions for Smallest String Starting From Leaf.
    Memory Usage: 37.4 MB, less than 100.00% of JavaScript online submissions for Smallest String Starting From Leaf.
*/
/*
    Runtime: 116 ms, faster than 9.52% of JavaScript online submissions for Smallest String Starting From Leaf.
    Memory Usage: 38.3 MB, less than 50.00% of JavaScript online submissions for Smallest String Starting From Leaf.
*/
var smallestFromLeaf1 = function(root) {
    let list = []

    if (!root) {
        return ''
    }
    root.val = toChar(root.val)

    dfs(root)

    function toChar(num) {
        return String.fromCharCode(num + 'a'.charCodeAt(0))
    }

    function dfs(root) {
        if (root.left || root.right) {
            if (root.left) {
                root.left.val = toChar(root.left.val) + root.val
                dfs(root.left)
            }

            if (root.right) {
                root.right.val = toChar(root.right.val) + root.val
                dfs(root.right)
            }
        } else {
            list.push(root.val)
        }
    }

    list.sort()
    return list[0]
};