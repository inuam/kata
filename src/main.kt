
fun wordIndexes(text: String): List<IntRange> {
    println("text = ${text}")
    val words = text.split(Regex("\\s+")).filter { !it.equals("") }
    var position = 0

    val headerCords: MutableList<IntRange> = mutableListOf()

    for (word in words) {
        val indexOf = text.indexOf(word, position) + word.length
        val range = IntRange(position, indexOf)
        position = indexOf
        headerCords.add(range)
    }

//    println("headerCords = ${headerCords}")
    return headerCords
}

data class Temperature(val day:Int, val min:Int, val max:Int)

fun main(args: Array<String>) {
    println("Starting !!")

    val dailyTemperatures: MutableList<Temperature> = mutableListOf()

    val wordIndexes = wordIndexes(data().split("\n").first())

    val dayIndexes = wordIndexes.get(0)
    val minIndexes = wordIndexes.get(1)
    val maxIndexes = wordIndexes.get(2)

    val days = data().split("\n").subList(2, 31)
    for (day in days) {
        println("day = ${day}")
        val dayOfMonth = day.substring(dayIndexes.start, dayIndexes.endInclusive)
        val min = day.substring(minIndexes.start, minIndexes.endInclusive)
        val max = day.substring(maxIndexes.start, maxIndexes.endInclusive)
        println("dayOfMonth = ${dayOfMonth}, ${min}, ${max}")
        dailyTemperatures.add(Temperature(dayOfMonth.trim().toInt(), min.trim().toInt(), max.trim().toInt()))
    }
//    println("dailyTemperatures = ${dailyTemperatures}")
    
}