/**
 * https://leetcode.com/problems/basic-calculator-ii/
 * @param {string} s
 * @return {number}
 */
/*
    Runtime: 68 ms, faster than 85.02% of JavaScript online submissions for Basic Calculator II.
    Memory Usage: 41.3 MB, less than 50.00% of JavaScript online submissions for Basic Calculator II.
*/
var calculate = function(s) {
    s = s.replace(/\s+/g, '')
    let nums = s.split(/[+-]/)

    let flag = [1]

    for (let i = 0; i < s.length; i++) {
        if (s[i] === '+') {
            flag.push(1)
        } else if (s[i] === '-') {
            flag.push(-1)
        }
    }

    let result = nums.reduce(function(re, curr, index) {
        return re + flag[index] * getNum(curr)
    }, 0)

    function getNum(s) {
        if (s == +s) {
            return +s
        }

        let num = 1
        let curr = 0
        let flag = '*'

        for (let i = 0; i < s.length + 1; i++) {
            let char = s[i]
            if (char === '*' || char === '/' || i === s.length) {
                if (flag === '*') {
                    num = num * curr
                } else {
                    num = Math.floor(num / curr)
                }

                curr = 0
                flag = char
            } else {
                curr = curr * 10 + (+char)
            }
        }

        return num
    }

    return result
};

console.log(calculate(" 0 - 0"))

/*
var calculate = function(s) {
    let stack = []
    let flag = 1
    let result = 0

    for (let i = 0; i < s.length;) {
        let num = 0
        while (s[i] === ' ' || s[i] >= 0) {
            if (s[i] !== ' ') {
                num = num * 10 + s[i]
            }
            i++
        }

        if (s[i] === '+') {
            result = flag * num
            flag = 1
        } else if (s[i] === '-') {
            result = flag * num
            flag = -1
        } else {
            let num2 = 0
            let symbol = s[i]
            while (s[i] === ' ' || s[i] >= 0) {
                if (s[i] !== ' ') {
                    num = num * 10 + s[i]
                }
                i++
            }
        }

        if(['+', '-'].includes(s[i])) {
            
            i++
            continue
        }

        while()
    }
};*/