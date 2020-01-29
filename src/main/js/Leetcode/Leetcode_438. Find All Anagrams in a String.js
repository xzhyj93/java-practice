/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

 /**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
/*
    Runtime: 92 ms, faster than 82.30% of JavaScript online submissions for Find All Anagrams in a String.
    Memory Usage: 42.3 MB, less than 44.44% of JavaScript online submissions for Find All Anagrams in a String.
*/
var findAnagrams = function(s, p) {
    const result = []
    let pCharts = new Array(26).fill(0)
    p.split('').forEach(char => {
        pCharts[char.charCodeAt(0) - 'a'.charCodeAt(0)]++
    })
    let chars = [...pCharts]    // chars counts
    let start = 0   //起始位 start indices
    let right = 0   //遍历到哪一位 

    while(start < s.length - p.length + 1 && right < s.length) {
        let charIndex = s.charCodeAt(right) - 'a'.charCodeAt(0)
        if (chars[charIndex] > 0) {
            chars[charIndex]--
            if (right === start + p.length - 1) {
                result.push(start)
                addCharsCount(start)
                start++
                right++
            } else {
                right++
            }
        } else if (pCharts[charIndex] > 0) {
            while(s.charAt(start) !== s.charAt(right)) {
                addCharsCount(start)
                start++
            }
            start++
            right++
        } else {
            chars = [...pCharts]
            start = right = right + 1
        }
    }

    function addCharsCount(i) {
        chars[s.charCodeAt(i) - 'a'.charCodeAt(0)]++
    }

    return result
};

/*
    Runtime: 756 ms, faster than 24.73% of JavaScript online submissions for Find All Anagrams in a String.
    Memory Usage: 41.4 MB, less than 44.44% of JavaScript online submissions for Find All Anagrams in a String.
*/
var findAnagrams2 = function(s, p) {
    const result = []
    let pCharts = new Array(26).fill(0)
    p.split('').forEach(char => {
        pCharts[char.charCodeAt(0) - 'a'.charCodeAt(0)]++
    })

    for (let i = 0; i < s.length - p.length + 1;) {
        let j = 0
        let chars = [...pCharts]
        while (j < p.length){
            let charIndex = s.charCodeAt(i + j) - 'a'.charCodeAt(0)
            if (chars[charIndex] > 0) {
                chars[charIndex]--
                j++
            } else if (pCharts[charIndex] > 0) {
                j = p.length + 1
                i++
            } else {
                i = i + j + 1
                j = p.length + 1
            }
        }

        if (j === p.length) {
            result.push(i)
            i++
        }
    }

    return result
};

console.log(findAnagrams("abab", "ab"))
console.log(findAnagrams("baa", "aa"))
console.log(findAnagrams("cbaebabacd", "abc"))
console.log(findAnagrams("abaacbabc", "abc"))
console.log(findAnagrams("ababc", "abc"))