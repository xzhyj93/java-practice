/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
/*
  Runtime: 92 ms, faster than 7.32% of JavaScript online submissions for Minimum Path Sum.
  Memory Usage: 35.9 MB, less than 66.67% of JavaScript online submissions for Minimum Path Sum.
*/
var minPathSum = function(grid) {
  let path = new Array(grid[0].length)
  let next = new Array(path.length)
  path[0] = grid[0][0]

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (i === 0 && j === 0) {
        path[0] = next[0] = grid[0][0]
        continue
      } else if (i === 0) {
        next[j] = next[j - 1] + grid[i][j]
      } else if (j === 0) {
        next[j] = path[j] + grid[i][j]
      } else {
        next[j] = Math.min(path[j], next[j - 1]) + grid[i][j]
      }
    }

    path = next
  }

  return path[path.length - 1]
};

/**
 * @param {number[][]} grid
 * @return {number}
 */
/*
  Runtime: 60 ms, faster than 72.20% of JavaScript online submissions for Minimum Path Sum.
  Memory Usage: 36.6 MB, less than 66.67% of JavaScript online submissions for Minimum Path Sum.
*/
var minPathSum2 = function(grid) {
  const path = new Array(grid.length)
  for (let i = 0; i < path.length; i++) {
    path[i] = new Array(grid[i].length)
  }

  path[0][0] = grid[0][0]

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (i === 0 && j === 0) {
        continue
      } else if (i === 0) {
        path[i][j] = path[i][j - 1] + grid[i][j]
      } else if (j === 0) {
        path[i][j] = path[i - 1][j] + grid[i][j]
      } else {
        path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j]
      }
    }
  }

  return path[path.length - 1][path[0].length - 1]
};


console.log(minPathSum([
  [1,3,1],
  [1,5,1],
  [4,2,1]
]))