package compose.project.advent_of_code_2024

fun getSimilarity(
    list: String,
    ): String {
    var result = 0
    val left = getLeftList(list)
    val rigth = getRigthList(list)
    if (left.size == rigth.size) {
        left.forEach{ s ->
            val occurence = s.toInt().times(rigth.count { it == s })
            result += occurence
            println("occurence = $occurence")
            println("result = $result")
        }
    } else {
        return "an error occured."
    }
    return result.toString()
}

// 31
// 9 + 4 + 0 + 0 + 9 + 9
