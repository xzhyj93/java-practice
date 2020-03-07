function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

function generateTreeNode(list) {
    let root = new TreeNode(list[0])
    let stack = [root]

    for (let i = 1; i < list.length;) {
        let p = stack.pop()
        
        if (list[i]) {
            p.left = new TreeNode(list[i])
            stack.push(p.left)
        }
        i++

        if (list[i]) {
            p.right = new TreeNode(list[i])
            stack.push(p.right)
        }
        i++
    }

    return root
}