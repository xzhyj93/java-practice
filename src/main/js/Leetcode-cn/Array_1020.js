/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1020/
 * 三数之和
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums.sort((a, b) => a - b)

    let result = []
    
    for (let i = 0; i < nums.length; i++) {
        let sum = -(nums[i])
        let j = i + 1
        let k = nums.length - 1

        while(j < k) {
            if (nums[j] + nums[k] === sum) {
                result.push([nums[i], nums[j], nums[k]])
                while(nums[j + 1] === nums[j]) {
                    j++
                }
                j++
                k--
                continue
            }

            if (nums[j] + nums[k] < sum) {
                j++
                continue
            } else if (nums[j] + nums[k] > sum) {
                k--
                continue
            }
        }

        while(nums[i + 1] === nums[i]) {
            i++
        }
    }

    return result
};

console.log(threeSum([-2, 0, 0, 2, 2]))