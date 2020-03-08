/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 *  复原IP地址

 * @param {string} s
 * @return {string[]}
 */

function isValid(s) {
    if (s >= 256) {
        return false
    } else if (s === '0') {
        return true
    } else if (s[0] === '0') {
        return false
    } else {
        return true
    }
}

function genArr(s, len) {
    if (s.length > 3 * len || s.length < len) {
        return []
    }

    if (len === 1) {
        return isValid(s) ? [[s]] : []
    }

    let results = []

    for (let i = 0; i < 3; i++) {
        let str = s.substring(0, i + 1)
        if (isValid(str)) {
            let remains = genArr(s.substr(i + 1), len - 1)
            if (remains.length) {
                remains.forEach(remain => results.push([str, ...remain]))
            }
        }
        
    }

    return results
} 

var restoreIpAddresses = function(s) {
    let results = genArr(s, 4)

    return results.map(item => item.join('.'))
};

console.log(restoreIpAddresses("010010"))