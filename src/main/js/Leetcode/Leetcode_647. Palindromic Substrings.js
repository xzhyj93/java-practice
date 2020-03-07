/**
 * @param {string} s
 * @return {number}
 */

 // TODO: 马拉车算法
 var countSubstrings_todo = function(s) {
    let total = 0
    s = s.split('').join('#')
    let counts = new Array(s.length)
    let le

    for (let i = 0; i < s.length; i++) {
        if (i === 0 || i === s.length - 1) {
            counts[i] = 1
            total += 1
        }

        
    }


 }
/*
    Runtime: 72 ms, faster than 67.04% of JavaScript online submissions for Palindromic Substrings.
    Memory Usage: 34.9 MB, less than 83.33% of JavaScript online submissions for Palindromic Substrings.
*/
var countSubstrings1 = function(s) {
    let count = 0
    const str = s.split('').join('#')

    for(let i = 0; i < str.length; i++) {
        if (str[i] !== '#') count++
        let left = i - 1
        let right = i + 1
        while(left >= 0 && right <str.length && str[left] === str[right]) {
            if (str[left] !== '#') count++
            left--
            right++

        }
    }

    return count
};

console.log(countSubstrings(""))