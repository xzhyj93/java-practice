/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (!strs.length) return ''
    let minLen = Number.POSITIVE_INFINITY
    for (let i = 0; i < strs.length; i++) {
        minLen = Math.min(strs[i].length, minLen)
    }

    let result = ''
    let num = 0

    while (num <= minLen) {
        let char = strs[0].charAt(num)
        let br = false
        for (let i = 1; i < strs.length; i++) {
            const str = strs[i]
            if (str.charAt(num) !== char) {
                br = true
                break
            }
        }

        if (br) {
            break
        } else {
            num++
        }
    }

    if (num > 0) {
        result = strs[0].substr(0, num)
    }

    return result
};

console.log(longestCommonPrefix(["dog","racecar","car"]))