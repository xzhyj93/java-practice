/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/
 * 岛屿的最大面积
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    if (!grid.length) return 0

    let max = 0
    let visited = []
    for (let i = 0; i < grid.length; i++) {
        visited.push([])
    }

    function measureIsland(i, j) {
        let sum = 1

        visited[i][j] = 1

        ;[[i + 1, j], [i - 1, j], [i, j + 1], [i, j - 1]].forEach(([m, n]) => {
            if (m >= 0 && n >= 0 && m < grid.length && n < grid[0].length && grid[m][n] && !visited[m][n]) {
                sum += measureIsland(m, n)
            }
        })

        return sum
    }

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] && !visited[i][j]) {
                let sum = measureIsland(i, j)
                max = Math.max(max, sum)
            }
        }
    }

    return max
};

console.log(maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,1,1,0,1,0,0,0,0,0,0,0,0],
    [0,1,0,0,1,1,0,0,1,0,1,0,0],
    [0,1,0,0,1,1,0,0,1,1,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0]]))