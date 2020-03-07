/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * @param {number[]} nums
 * @return {number}
 */

var removeDuplicates = function(nums) {
  let realIndex = 1
  for (let i = 2; i < nums.length; i++) {
    if (nums[i] !== nums[realIndex - 1]) {
      realIndex++
      nums[realIndex] = nums[i]
    }
  }

  return realIndex + 1
}
/*
  Runtime: 140 ms, faster than 5.90% of JavaScript online submissions for Remove Duplicates from Sorted Array II.
  Memory Usage: 35.4 MB, less than 100.00% of JavaScript online submissions for Remove Duplicates from Sorted Array II.
*/
var removeDuplicates = function(nums) {
    for (let i = 2; i < nums.length; ) {
      if (nums[i] === nums[i - 2]) {
        nums.splice(i, 1)
      } else {
        i++
      }
    }
};

console.log(removeDuplicates([1,1,1,2,2,3]))