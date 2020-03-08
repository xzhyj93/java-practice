/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/
 * 字符串相乘
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    if (num1 === '0' || num2 === '0') return '0'

    let products = []
    let len = 0
    for (let i = num2.length - 1; i >= 0; i--) {
        let multiplier = parseInt(num2[i])

        if (!multiply) {
            continue
        }

        let product = new Array(num2.length - 1 - i).fill(0)
        let jinwei = 0
        for (let j = num1.length - 1; j >= 0; j--) {
            let num = num1[j] * multiplier + jinwei
            if (num >= 10) {
                jinwei = Math.floor(num / 10)
            } else {
                jinwei = 0
            }
            product.push(num % 10)
        }
        if (jinwei) {
            product.push(jinwei)
        }
        len = Math.max(product.length, len)

        products.push(product)
    }

    let result = []
    let jinwei = 0
    for (let i = 0; i < len; i++) {
        let sum = products.reduce((acc, product) => {
            return acc + (product[i] || 0)
        }, 0)
        
        sum += jinwei

        if (sum >= 10) {
            jinwei = Math.floor(sum / 10)
        } else {
            jinwei = 0
        }
        result.unshift(sum % 10 + '')
    }

    if(jinwei) {
        result.unshift(jinwei)
    }

    return result.join("")
};

console.log(multiply("140", "721"))