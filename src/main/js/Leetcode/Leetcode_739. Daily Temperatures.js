/**
 * https://leetcode.com/problems/daily-temperatures/
 */
/**
 * @param {number[]} T
 * @return {number[]}
 */
/*
    Runtime: 160 ms, faster than 65.05% of JavaScript online submissions for Daily Temperatures.
    Memory Usage: 42.4 MB, less than 77.78% of JavaScript online submissions for Daily Temperatures.
*/
 var dailyTemperatures = function(T) {
    const result = []
    const stack = []

    for (let i = T.length - 1; i >= 0; i--) {
        if (!stack.length) {
            result[i] = 0
            stack.unshift(i)
            continue
        }
        while (stack.length) {
            if (T[stack[0]] > T[i]) {
                result[i] = stack[0] - i
                stack.unshift(i)
                break
            } 
            stack.shift()
        }

        if (!stack.length) {
            result[i] = 0
            stack.unshift(i)
        }
    }

    return result
 }

/*
    Runtime: 360 ms, faster than 52.71% of JavaScript online submissions for Daily Temperatures.
    Memory Usage: 42.3 MB, less than 77.78% of JavaScript online submissions for Daily Temperatures.
*/
var dailyTemperatures2 = function(T) {
    const result = []
    const close = new Array(101)
    for (let i = T.length - 1; i >= 0; i--) {
        let re = Number.POSITIVE_INFINITY

        close[T[i]] = i

        for (let higher = T[i] + 1; higher < 101; higher++) {
            if (close[higher]) {
                let distance = close[higher] - i
                re = Math.min(distance, re)
            }
        }

        if (re === Number.POSITIVE_INFINITY) {
            re = 0
        }

        result[i] = re
    }

    return result
};


console.log(dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))