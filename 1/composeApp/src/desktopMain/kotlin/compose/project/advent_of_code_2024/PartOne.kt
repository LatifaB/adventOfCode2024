package compose.project.advent_of_code_2024

import kotlin.math.absoluteValue


fun getDistance(
    list: String,
): String {
    var result = 0
    val left = getLeftList(list).sorted()
    val rigth = getRigthList(list).sorted()
    if (left.size == rigth.size) {
        left.forEachIndexed { index, s ->
            val dist = (s.toInt() - rigth[index].toInt()).absoluteValue
            result += dist
            println("dist = $dist")
            println("result = $result")
        }
    } else {
        return "an error occured."
    }
    return result.toString()
}

//2 + 1 + 0 + 1 + 2 + 5