/*
dp
https://leetcode.com/problems/coin-change/
*/

/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
/*
Runtime: 156 ms, faster than 32.76% of JavaScript online submissions for Coin Change.
Memory Usage: 37.1 MB, less than 72.73% of JavaScript online submissions for Coin Change.
*/
var coinChange1 = function(coins, amount) {
    if (amount === 0) {
        return 0
    }
    const results = new Array(amount + 1).fill(-1)

    for (let i = 1; i <= amount; i++) {
        const total = i
        let result = -1
        if (coins.includes(total)) {
            result = 1
        } else {
            // let min = Number.POSITIVE_INFINITY
            let min = amount + 1

            for (let j = coins.length - 1; j >= 0; j--) {
                const preTotal = results[total - coins[j]]
                if (total > coins[j] && preTotal !== -1) {
                    min = Math.min(min, preTotal + 1)
                }
            }


            result = min === amount + 1 ? -1 : min
        }


        results[i] = result

    }

    return results[amount]
};

/*
Runtime: 72 ms, faster than 96.94% of JavaScript online submissions for Coin Change.
Memory Usage: 38.5 MB, less than 27.27% of JavaScript online submissions for Coin Change.
*/

var coinChange = function(coins, amount) {
    if (amount === 0) {
        return 0
    }
    const results = [0]

    for (let total = 1; total <= amount; total++) {
        let min = amount + 1

        for (let j = coins.length - 1; j >= 0; j--) {
            if (total >= coins[j]) {
                const preTotal = results[total - coins[j]]
                min = Math.min(min, preTotal + 1)
            }
            
        }


        results[total] = min
        console.log(total, min)
    }

    return results[amount] > amount ? -1 : results[amount]
};

console.log(coinChange([1, 2, 5],11))