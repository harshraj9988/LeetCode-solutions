import java.util.*

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int?

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>?
}

class NestedIterator(nestedList: List<NestedInteger>) {
    private var list = nestedList
    private var index = -1

    private val ls = Stack<Pair<List<NestedInteger>, Int>>()

    init {
        goToNextInt()
    }

    private fun goToNextInt() {
        index++
        while(index == list.size && ls.isNotEmpty()) {
            list = ls.peek().first
            index = ls.pop().second
        }
        if(index == list.size) return
        while(index < list.size && !list[index].isInteger()) {
            val temp = list[index].getList()!!
            if(temp.isEmpty()) goToNextInt()
            ls.add(Pair(list, index+1))
            list = list[index].getList()!!
            index = 0
        }
    }

    fun next(): Int {
        val value = list[index].getInteger()!!
        goToNextInt()
        return value
    }

    fun hasNext(): Boolean {
        return index < list.size
    }
}