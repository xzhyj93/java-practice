/**
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 * @param {number} n
 * @return {number[][]}
 */

 /**
  * Runtime: 48 ms, faster than 94.96% of JavaScript online submissions for Spiral Matrix II.
Memory Usage: 33.6 MB, less than 100.00% of JavaScript online submissions for Spiral Matrix II.
  * @param {*} n 
  */
var generateMatrix = function(n) {
    const result = []
    for (let i = 0; i < n; i++) result.push([])

    let rowStart = 0
    let rowEnd = n - 1
    let colStart = 0
    let colEnd = n - 1
    let num = 1

    while(rowStart <= rowEnd && colStart <= colEnd) {
        // to right
        for (let i = colStart; i <= colEnd; i++) {
            result[rowStart][i] = num++
        }

        rowStart++

        // to bottom
        for (let i = rowStart; i <= rowEnd; i++) {
            result[i][colEnd] = num++
        }

        colEnd--

        // to left
        for (let i = colEnd; i >= colStart; i--) {
            result[rowEnd][i] = num++
        }

        rowEnd--

        // to top
        for (let i = rowEnd; i >= rowStart; i--) {
            result[i][colStart] = num++
        }

        colStart++
    }

    return result
}

/**
 * Runtime: 68 ms, faster than 16.28% of JavaScript online submissions for Spiral Matrix II.
Memory Usage: 33.9 MB, less than 100.00% of JavaScript online submissions for Spiral Matrix II.
 * @param {} n 
 */
var generateMatrix2 = function(n) {
    const result = []
    for (let i = 0 ; i < n; i++) {
        result[i] = []
    }

    let direction = 'right'
    let row = 0
    let col = 0

    let num = 1

    for (let i = 0; i < n * n; i++) {
        result[row][col] = num++

        if (direction === 'right') {
            if (col >= n - 1 || result[row][col + 1]) {
                direction = 'down'
                row++
            } else {
                col++
            }
        } else if (direction === 'down') {
            if (row >= n - 1 || result[row + 1][col]) {
                direction = 'left'
                col--
            } else {
                row++
            }
        } else if (direction === 'left') {
            if (col <= 0 || result[row][col - 1]) {
                direction = 'up'
                row--
            } else {
                col--
            }
        } else if (direction === 'up') {
            if (result[row - 1][col]) {
                direction = 'right'
                col++
            } else {
                row--
            }
        }
    }

    return result
};

console.log(generateMatrix(4))