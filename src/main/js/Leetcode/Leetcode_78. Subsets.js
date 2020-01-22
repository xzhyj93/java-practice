/**
 * https://leetcode.com/problems/subsets/
 * @param {number[]} nums
 * @return {number[][]}
 */

var subsets = function(nums) {
  let results = [[]]
  
  nums.forEach(num => {
    let len = results.length

    for (let i = 0; i < len; i++) {
      results.push([...results[i], num])
    }
  })

  return results
};

/*
  Runtime: 52 ms, faster than 96.87% of JavaScript online submissions for Subsets.
  Memory Usage: 35.3 MB, less than 11.76% of JavaScript online submissions for Subsets.
*/
var subsets = function(nums) {
  let results = [[]]
  
  nums.forEach(num => {
    const result = []
    results.forEach(re => {
      result.push([...re, num])
    })

    results = results.concat(result)
  })

  return results
};

console.log(subsets([1,2,3]))