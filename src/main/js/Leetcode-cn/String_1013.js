/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 * 简化路径
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {
    let dirs = path.split(/\/+/).filter(p => p)
    let results = []

    for (let i = 0; i < dirs.length; i++) {
        switch(dirs[i]) {
            case '.':
                break
            case '..':
                if (results.length) {
                    results.pop()
                }
                break
            default:
                results.push(dirs[i])
        }
    }

    return '/' + results.join('/')
};

console.log(simplifyPath("/a/./b/../../c/"))