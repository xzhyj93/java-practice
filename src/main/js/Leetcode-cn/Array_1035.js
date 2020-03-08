/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1035/
 * 最长连续递增序列
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    if (!nums.length) return 0

    let max = 1
    let start = 0

    for (let end = 1; end < nums.length; ) {
        if (nums[end] >  nums[end -1]) {
            end++
            max = Math.max(max, end - start)
            continue
        } else {
            start = end
            end = end + 1
        }
    }

    return max
};

console.log(findLengthOfLCIS([1,3,5,7]))