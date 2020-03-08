/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1019/
 * 最长连续序列
 * @param {number[]} nums
 * @return {number}
 */

var longestConsecutive = function(nums) {
    const numSet = nums.reduce((acc, curr) => {
        acc.add(curr)
        return acc
    }, new Set())

    let max = 0

    for (let i = 0; i < nums.length; i++) {
        if (!numSet.has(nums[i])) {
            continue
        } else {
            let sum = 1
            let before = nums[i] - 1
            let after = nums[i] + 1

            while(numSet.has(before)) {
                sum++
                numSet.delete(before)
                before--
            }

            while(numSet.has(after)) {
                sum++
                numSet.delete(after)
                after++
            }
            max = Math.max(max, sum)
        }
    }

    return max
};

var longestConsecutive = function(nums) {
    const numSet = nums.reduce((acc, curr) => {
        acc.add(curr)
        return acc
    }, new Set())

    let max = 0
    let visited = new Set()

    for (let i = 0; i < nums.length; i++) {
        if (visited.has(nums[i])) {
            continue
        } else {
            let sum = 1
            let before = nums[i] - 1
            let after = nums[i] + 1

            while(numSet.has(before)) {
                sum++
                visited.add(before)
                before--
            }

            while(numSet.has(after)) {
                sum++
                visited.add(after)
                after++
            }
            max = Math.max(max, sum)
        }
    }

    return max
};

console.log(longestConsecutive([100, 4, 200, 1, 3,2]))