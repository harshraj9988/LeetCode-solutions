import java.util.*
import kotlin.collections.LinkedHashSet

class LFUCache(private val capacity: Int) {

    private val keyValue = HashMap<Int, Int>()
    private val keyUse = HashMap<Int, Int>()
    private val useKey = HashMap<Int, LinkedHashSet<Int>>()

    private var leastUsed = -1

    fun get(key: Int): Int {
        if (!keyValue.containsKey(key)) return -1

        val currUse = updatePreviousUse(key)
        updateUse(currUse, key)

        return keyValue[key]!!
    }


    fun put(key: Int, value: Int) {
        if (capacity <= 0) return

        if (keyValue.containsKey(key)) {
            keyValue[key] = value
            val currUse = updatePreviousUse(key)
            updateUse(currUse, key)
            return
        }

        if(keyValue.size >= capacity) {
            removeLeastUsed()
        }

        leastUsed = 1
        updateUse(1, key)
        keyValue[key] = value
    }

    private fun removeLeastUsed() {
        val key = useKey[leastUsed]!!.iterator().next()
        keyValue.remove(key)
        useKey[leastUsed]!!.remove(key)
        keyUse.remove(key)
    }

    private fun updateUse(currUse: Int, key: Int) {
        keyUse[key] = currUse
        val set = useKey[currUse] ?: LinkedHashSet()
        set.add(key)
        useKey[currUse] = set
    }

    private fun updatePreviousUse(key: Int): Int {
        val prevUse = keyUse[key]!!
        useKey[prevUse]?.remove(key)
        if (prevUse == leastUsed && useKey[key]!!.size == 0) {
            leastUsed++
        }
        return prevUse + 1
    }

}