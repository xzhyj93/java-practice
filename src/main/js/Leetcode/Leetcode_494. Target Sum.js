/*Add to List

Share
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.*/

/**
 * @param {number[]} nums
 * @param {number} S
 * @return {number}
 */

 /*
  Approach 3: 2D Dynamic Programming
  Runtime: 140 ms, faster than 73.04% of JavaScript online submissions for Target Sum.
  Memory Usage: 41.5 MB, less than 100.00% of JavaScript online submissions for Target Sum.
 */
 var findTargetSumWays = function(nums, s) {
   const dp = new Array(nums.length)
   for (let i = 0; i < nums.length; i++) {
     dp[i] = new Array(2001).fill(0)
   }

   dp[0][nums[0] + 1000] = 1
   dp[0][-nums[0] + 1000] += 1

   for (let i = 1; i < nums.length; i++) {
     for (let sum = 0; sum < dp[i].length; sum++) {
       if (dp[i - 1][sum]) {
         dp[i][sum + nums[i]] += dp[i - 1][sum]
         dp[i][sum - nums[i]] += dp[i - 1][sum]
       }
     }
   }

   return s > 1000 || nums.length === 0 ? 0 : dp[nums.length - 1][s + 1000]
 }

 /*
  Approach 2: Recursion with Memoization

  Runtime: 312 ms, faster than 46.52% of JavaScript online submissions for Target Sum.
  Memory Usage: 43.2 MB, less than 100.00% of JavaScript online submissions for Target Sum.
 */
/**
 * memo[i][sum] 存的是从i到结尾的数字的和为sum的排列个数
 * @param {*} nums 
 * @param {*} S 
 */
var findTargetSumWays3 = function(nums, S) {
  let memo = []
  for (let i = 0; i < nums.length; i++) {
    memo[i] = new Array(1001)
  }

  return calculate(0, 0)

  function calculate(i, sum) {
    if (i === nums.length) {
      if (sum === S) {
        return 1
      } 

      return 0
    }

    if (memo[i][sum] !== undefined) {
      return memo[i][sum]
    }

    memo[i][sum] = calculate(i + 1, sum + nums[i]) + calculate(i + 1, sum - nums[i])

    return memo[i][sum]
  }
}

/*
  Approach 1: Brute Force

  Runtime: 1536 ms, faster than 29.56% of JavaScript online submissions for Target Sum.
  Memory Usage: 34.4 MB, less than 100.00% of JavaScript online submissions for Target Sum.
*/
let co = 0
var findTargetSumWays2 = function(nums, S) {
  let count = 0
  // let sums = []
  // for (let i = 0; i < nums.length; i++) {
  //   sums[i] = new Array(1001)
  // }

  calculate(0, 0)

  function calculate(i, sum) {
    if (i === nums.length) {
      if (sum === S) {
        count++
      }

      return
    }

    console.log('time', ++co)

    calculate(i + 1, sum + nums[i])
    calculate(i + 1, sum - nums[i])
  }

  return count
}

 /*
  Runtime: 3896 ms, faster than 10.87% of JavaScript online submissions for Target Sum.
  Memory Usage: 40.5 MB, less than 100.00% of JavaScript online submissions for Target Sum.
*/
var findTargetSumWays1 = function(nums, S) {
    if (nums.length === 0) {
      return 0
    } else if (nums.length === 1) {
      return (nums[0] === S ? 1 : 0) + (nums[0] === -S ? 1 : 0)
    }

    const newNums = nums.slice(0, nums.length - 1)
    const num = nums[nums.length - 1]
    return findTargetSumWays(newNums, S - num) + findTargetSumWays(newNums, S + num)
};

console.log(findTargetSumWays([1,1,1,1,1], 3))