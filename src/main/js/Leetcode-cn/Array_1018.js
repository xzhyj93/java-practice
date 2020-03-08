/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1018/
 * 数组中的第K个最大元素

 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    let numCount = {}

    nums.forEach(num => {
        numCount[num] = (numCount[num] || 0) + 1
    })

    const numCountList = Object.entries(numCount).sort((a, b) => b[0] - a[0])

    let index = 0
    for (let i = 0; i < numCountList.length; i++) {
        index += numCountList[i][1]

        if (index >= k) {
            return numCountList[i][0]
        }
    }
}

var findKthLargest_1 = function(nums, k) {
    nums.sort((a, b) => b - a)

    return nums[k - 1]
};

console.log(findKthLargest([3,2,3,1,2,4,5,5,6], 4))