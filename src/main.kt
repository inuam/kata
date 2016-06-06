
fun headerPositions(text: String) {
    println("text = ${text}")
    val words = text.split(Regex("\\s+"))
    var position = 0

    val headerCords: MutableList<IntRange> = mutableListOf()

    for (word in words) {
        val indexOf = text.indexOf(word, position) + word.length
        val range = IntRange(position, indexOf)
        position = indexOf
        headerCords.add(range)
    }

    println("words = ${words}")
    println(headerCords)

    for (intRange in headerCords) {
        print(text.subSequence(intRange.start, intRange.endInclusive))
    }

}

data class Temperature(val day:Int, val min:Int, val max:Int)

fun main(args: Array<String>) {
    println("Starting !!")
    headerPositions("find all the words in this sentence")
}