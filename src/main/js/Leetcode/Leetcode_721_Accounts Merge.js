/**
 * @param {string[][]} accounts
 * @return {string[][]}
 */
// var accountsMerge = function(accounts) {
//   const emails = new Map()

//   accounts.forEach(([name, ...emails]) => {

//   })
// }

/*
Runtime: 9480 ms, faster than 5.52% of JavaScript online submissions for Accounts Merge.
Memory Usage: 56.3 MB, less than 100.00% of JavaScript online submissions for Accounts Merge.
*/
var accountsMerge = function(accounts) {
    const results = []

    accounts.forEach(([name, ...emails]) => {
      emails = deduplication(emails).sort()
      if (results.length === 0) {
        results.push([name, ...emails])
      } else {
        const filters = []
        results.forEach(([reName, ...reEmails], index) => {
          if (reName !== name) {
            return
          }

          if (isArraysHasDuplication(reEmails, emails)) {
            filters.push(index)
          }
        })

        if (filters.length) {
          const re = filters.reduce((curr, index) => {
            const [_reName, ...reEmails] = results[index]
            return curr.concat(reEmails)
          }, emails)
          for(let i = filters.length -1; i>0; i--) {
            results.splice(filters[i], 1)
          }
          results[filters[0]] = [name, ...((deduplication(re).sort()))]
        } else {
          results.push([name, ...emails])
        }

      }
    })

    return results
};

function isArraysHasDuplication(arr1, arr2) {
  return arr1.some(item1 => arr2.some(item2 => item2 === item1))
}

function deduplication(arr) {
  return arr.filter((item, index) => arr.indexOf(item) === index)
}

// console.log(accountsMerge([["David","David0@m.co","David1@m.co"],["David","David3@m.co","David4@m.co"],["David","David4@m.co","David5@m.co"],["David","David2@m.co","David3@m.co"],["David","David1@m.co","David2@m.co"]]))
console.log(accountsMerge([["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]))