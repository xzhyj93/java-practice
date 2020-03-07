/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} n
 * @param {number} x
 * @return {boolean}
 */
/*
Runtime: 56 ms, faster than 83.00% of JavaScript online submissions for Binary Tree Coloring Game.
Memory Usage: 34 MB, less than 100.00% of JavaScript online submissions for Binary Tree Coloring Game.
*/
var btreeGameWinningMove = function(root, n, x) {
    let xNode = null

    function findX(p) {
        if (xNode) {
            return
        } else if (!p) {
            return
        } else {
            if (p.val === x) {
                xNode = p
            } else {
                findX(p.left)
                findX(p.right)
            }
        }
    }
    findX(root)

    function calcXNodes(p) {
        let num = 0
        if (p) {
            num++
            num += calcXNodes(p.left)
            num += calcXNodes(p.right)
        }

        return num
    }
    let xLeftNum = calcXNodes(xNode.left)
    let xRightNum = calcXNodes(xNode.right)
    let leftNum = n - xLeftNum - xRightNum - 1

    return xLeftNum > (xRightNum + leftNum + 1) || xRightNum > (xLeftNum + leftNum + 1) || leftNum > (xLeftNum + xRightNum + 1)
}

// wrong answer
var btreeGameWinningMove_wrong = function(root, n, x) {
    if (x === 1) {
        return !is2Power(n + 1)
    } else {
        if (x === 2) {
            if (is2Power(n + 1)) {
                return true
            } else {
                return false
            }
        }
        return true
    }
};

function is2Power(num) {
    if (num === 1) return false

    let square = 2
    while (num > square) {
        square = square * 2
    }

    return num === square
}

console.log(btreeGameWinningMove([1,2,3,4,5,6,7],
    7,
    1))