/**
 * https://leetcode.com/problems/accounts-merge/submissions/
 * @param {string[][]} accounts
 * @return {string[][]}
 */


/**
 * Runtime: 148 ms, faster than 94.48% of JavaScript online submissions for Accounts Merge.
  Memory Usage: 46.8 MB, less than 100.00% of JavaScript online submissions for Accounts Merge.
 */
function DSU() {
  this.parent = []
  for (let i = 0; i< 1000; i++) {
    this.parent[i] = i
  }

  this.find = function(x) {
    if (this.parent[x] !== x) this.parent[x] = this.find(this.parent[x])
    return this.parent[x]
  },

  this.union = function (x, y) {
    this.parent[this.find(x)] = this.find(y)
  }
 }

 var accountsMerge = function(accounts) {
  const dsu = new DSU()

  const email2Name = new Map()
  const email2Id = new Map()

  accounts.forEach(([name, ...emails], index) => {
    emails.forEach(email => {
      email2Name.set(email, name)
      if (!email2Id.has(email)) {
        email2Id.set(email, index)
      } 

      dsu.union(email2Id.get(email), email2Id.get(emails[0]))
    })
  })

  const result =  new Map() // {index: {name, emails: Set(email)}}

  email2Name.forEach((name, email) => {
    const index = dsu.find(email2Id.get(email))
    if (result.has(index)) {
      result.get(index).emails.add(email)
    } else {
      result.set(index, {
        name,
        emails: new Set([email])
      })
    }
  })

  return Array.from(result.values()).map(({name, emails}) => ([
    name,
    ...Array.from(emails).sort()
  ]))

 }


/**
 * Runtime: 164 ms, faster than 74.13% of JavaScript online submissions for Accounts Merge.
Memory Usage: 54.7 MB, less than 100.00% of JavaScript online submissions for Accounts Merge.
 */
var accountsMerge2 = function(accounts) {
  const email2Name = new Map()    // {email: name}
  const graph = new Map()     //{email: new Set(emails)}

  accounts.forEach(([name, ...emails]) => {
    email2Name.set(emails[0], name)

    emails.forEach(email => {
      !graph.get(emails[0]) && graph.set(emails[0], new Set())
      graph.get(emails[0]).add(email)

      !graph.get(email) && graph.set(email, new Set())
      graph.get(email).add(emails[0])
    })
  })

  const seen = new Set()
  const result = []

  graph.forEach((set, key) => {
    if (seen.has(key)) {
      return
    }

    const emails = new Set()

    function dfs(em) {
      for (let email of graph.get(em)) {
        if (seen.has(email)) {
          continue
        }

        seen.add(email)
        emails.add(email)
        dfs(email)
      }
    }

    dfs(key)
    result.push([email2Name.get(key), ...(Array.from(emails).sort())])
  })  

  return result
}

/*
Runtime: 9480 ms, faster than 5.52% of JavaScript online submissions for Accounts Merge.
Memory Usage: 56.3 MB, less than 100.00% of JavaScript online submissions for Accounts Merge.
*/
var accountsMerge1 = function(accounts) {
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
// console.log(accountsMerge([["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]))
console.log(accountsMerge([["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]))