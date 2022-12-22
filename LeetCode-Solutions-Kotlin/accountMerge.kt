    import java.util.*
    import kotlin.collections.HashMap

    fun findParent(u: String, parents: HashMap<String, String>): String {
        if (parents[u].equals(u)) return u
        parents[u] = findParent(parents[u]!!, parents)
        return parents[u]!!
    }

    fun union(u: String, v: String, parents: HashMap<String, String>, ranks: HashMap<String, Int>) {
        val parU = findParent(u, parents)
        val parV = findParent(v, parents)
        if (parU == parV) {
            return
        } else if (ranks[parU]!! < ranks[parV]!!) {
            parents[parU] = parV
        } else if (ranks[parV]!! < ranks[parU]!!) {
            parents[parV] = parU
        } else {
            parents[parV] = parU
            ranks[parU]!!.inc()
        }
    }

    fun _accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val parents = HashMap<String, String>()
        val ranks = HashMap<String, Int>()
        val emailToNames = HashMap<String, String>()
        val namesToEmails = HashMap<String, TreeSet<String>>()

        for (account in accounts) {
            val n = account.size
            for (i in 1 until n) {
                parents[account[i]] = account[i]
                ranks[account[i]] = 0
                emailToNames[account[i]] = account[0]
            }
        }

        for (account in accounts) {
            val n = account.size
            for (i in 1 until n) {
                for (j in i + 1 until n) {
                    union(account[i], account[j], parents, ranks)
                }
            }
        }

        parents.keys.forEach {
            val name = findParent(it, parents)
            if(!namesToEmails.containsKey(name)) namesToEmails[name] = TreeSet()
            namesToEmails[name]!!.add(it)
        }


        val ans = ArrayList<ArrayList<String>>()
        for (record in namesToEmails) {
            val data = ArrayList<String>()
            data.add(emailToNames[record.key]!!)
            record.value.forEach { data.add(it) }
            ans.add(data)
        }

        return ans
    }

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        var group = 0
        val groups = HashMap<String, Int>()
        val names = HashMap<Int, String>()
        accounts.forEach { account ->
            val n = account.size
            names[group] = account[0]
            var oldGroup = -1
            for(i in 1 until n) {
                if(groups.containsKey(account[i])){
                    oldGroup = groups[account[i]]!!
                    break
                }else{
                    groups[account[i]] = group
                    group++
                }
            }
            if(oldGroup != -1) {
                for(i in 1 until n) {
                    groups[account[i]] = oldGroup
                }
            }
        }

        val groupEmails = HashMap<Int, TreeSet<String>>()
        groups.forEach { (email, group) ->
            if(!groupEmails.containsKey(group)) groupEmails[group] = TreeSet()
            groupEmails[group]!!.add(email)
        }

        val ans = ArrayList<ArrayList<String>>()
        groupEmails.forEach { (grp, emails) ->
            val temp = ArrayList<String>()
            temp.add(names[grp]!!)
            emails.forEach { temp.add(it) }
            ans.add(temp)
        }
        return ans
    }