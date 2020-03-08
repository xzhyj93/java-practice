//https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
// 无重复字符的最长子串

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (!s.length) {
        return 0
    }

    let result = 1
    let prev = 0
    let last

    for (last = 1; last < s.length; last++) {
        let repeat = false
        let i

        for(i = prev; i < last; i++) {
            if (s.charAt(i) === s.charAt(last)) {
                repeat = true
                break
            }
        }

        if (repeat) {
            result = Math.max(result, last - prev)
            prev = i + 1
        } else {
            result = Math.max(result, last - prev + 1)
        }
    }

    return result
};

console.log(lengthOfLongestSubstring("abcabcbb"))