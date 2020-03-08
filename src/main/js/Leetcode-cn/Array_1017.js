/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1017/
 * 数组与排序
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0
    let right = nums.length - 1

    if (nums.length === 0) return -1
    if (nums.length === 1) return target === nums[0] ? 0 : -1

    while(left < right) {
        let mid = Math.floor((left + right) / 2)
        if (target === nums[left]) {
            return left
        }

        if (target === nums[right]) {
            return right
        }

        if (target === nums[mid]) {
            return mid
        }

        if (nums[left] < nums[right]){
            if (target > nums[left] && target < nums[right]) {
                if (nums[mid] > target) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
                continue
            } else {
                break
            }
        } else if (nums[left] > nums[right]) {
            if (nums[mid] > nums[left]) {
                if (target > nums[left] && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
    }
    return -1
};

console.log(search([7,8,1,2,3,4,5,6], 2))