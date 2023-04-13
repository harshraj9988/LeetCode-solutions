import java.util.*

    fun isValid(s: String): Boolean {
        val st = Stack<Char>()
        val valid = hashMapOf(')' to '(', '}' to '{', ']' to '[')
        for(c in s) {
            if( c in setOf('(', '{', '[')){
                st.add(c)
            }else{
                if(st.isEmpty() || valid[c] != st.pop()) {
                    return false
                }
            }
        }
        return true
    }