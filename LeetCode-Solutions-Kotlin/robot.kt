import java.awt.Robot
import java.awt.event.KeyEvent
import java.io.File
import java.util.*


fun main() {
    val words = getWords()
    typist(words)
}

private fun getWords(): String{
    val input =
        Scanner(File("/home/harsh/Pictures/Monkeytype.html").inputStream())
    val sb = StringBuilder()
    while (input.hasNext()) {
        sb.append(input.nextLine())
    }
    val sample = sb.toString().toCharArray()
    sb.clear()
    for(i in 50 until sample.size-50) {
        if(isSpace(sample, i)) sb.append(" ")
        else if(isLetter(sample, i)) sb.append(sample[i])
    }
    return sb.toString()
}

private fun isLetter(txt: CharArray, i: Int): Boolean{
    val left = arrayOf('<','l','e','t','t','e','r','>')
    val right = arrayOf('<','/','l','e','t','t','e','r')
    var x = i-1
    var y = i+1
    for(a in left.size-1 downTo 0){
        if(left[a]!=txt[x--]) return false
    }
    for(a in right.indices) {
        if(right[a]!=txt[y++]) return false
    }
    return true
}

private fun isSpace(txt: CharArray, x: Int): Boolean{
    val match = "<div class=\"word\">".toCharArray()
    var i = x
    for(c in match) {
        if(c != txt[i++]) return false
    }
    return true
}


private fun typist(sample: String) {
    val map = HashMap<Char, Int>()
    var temp = 65
    for (x in 'a'..'z') {
        map[x] = temp++
    }
    map[' '] = KeyEvent.VK_SPACE

    var speed = 101.toLong() - Scanner(System.`in`).nextLong()
    try{
        val robot = Robot()

        Thread.sleep(5000)
        for (c in sample) {
            Thread.sleep(speed)
            robot.keyPress(map[c]!!)
            robot.keyRelease(map[c]!!)
        }
    } catch (_: Exception) {}
}

