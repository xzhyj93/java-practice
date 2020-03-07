/*
  https://leetcode.com/problems/3sum-closest/submissions/ 
  16. 3Sum Closest
  Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
*/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

/*
  Runtime: 100 ms, faster than 16.17% of JavaScript online submissions for 3Sum Closest.
  Memory Usage: 34.8 MB, less than 100.00% of JavaScript online submissions for 3Sum Closest.
*/
var threeSumClosest = function (nums, target) {
  let minDiff = Number.POSITIVE_INFINITY
  let sum

  nums.sort((a, b) => a - b)
  for (let i = 0; i < nums.length - 2; i++) {
    let left = i + 1
    let right = nums.length - 1

    while (left < right) {
      let currSum = nums[i] + nums[left] + nums[right]
      if (Math.abs(currSum - target) < minDiff) {
        sum = currSum
        minDiff = Math.abs(currSum - target)
      }

      if (currSum < target) {
        left++
      } else if (currSum > target) {
        right--
      } else if (currSum === target) {
        return target
      }
    }
  }

  return sum
}

/**
  Runtime: 88 ms, faster than 21.93% of JavaScript online submissions for 3Sum Closest.
  Memory Usage: 35.2 MB, less than 100.00% of JavaScript online submissions for 3Sum Closest.
 */
var threeSumClosest2 = function (nums, target) {
  let minSum = Infinity
  let minAbs = Infinity

  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      for (let k = j + 1; k < nums.length; k++) {
        let sum = nums[i] + nums[j] + nums[k]
        let abs = Math.abs(target - sum)

        if (abs < minAbs) {
          minAbs = abs
          minSum = sum

          if (minAbs === 0) {
            return minSum
          }
        }
      }
    }
  }

  return minSum
};

console.log(threeSumClosest([0, 2, 1, -3], 1))