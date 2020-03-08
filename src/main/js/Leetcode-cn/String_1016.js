//https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function(s1, s2) {
    if (!s1.length) return true
    if (s1.length > s2.length) return false

    let charNums = {}
    for (let i = 0; i < s1.length; i++) {
        let char = s1.charAt(i)
        charNums[char] = (charNums[char] || 0) + 1
    }

    let start = 0
    let end = 0
    let leftCharNums = {...charNums}

    while (end < s2.length) {
        let char = s2[end]
        if (leftCharNums[char]) {
            if (end - start + 1 === s1.length) {
                return true
            } else {
                leftCharNums[char]--
                end++
            }
        } else if (leftCharNums[char] === undefined) {
            start = end = end + 1
            leftCharNums = {...charNums}
        } else if (leftCharNums[char] === 0) {
            for (let j = start; j < end; j++) {
                if (s2[j] === char) {
                    start = j + 1
                    end = end + 1
                    break
                } else {
                    leftCharNums[s2[j]]++
                }
            }
        }
    }

    return false
};

console.log(checkInclusion("ab", "eidcaooo"))