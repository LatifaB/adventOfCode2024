package compose.project.advent_of_code_2024

import java.util.function.Predicate

fun getLeftList(
    list: String,
    ): List<String>{
    val predicate = Predicate<Int> { it % 2 == 0 }
    return getList(list, predicate)
}
fun getRigthList(
    list: String,
    ): List<String>{
    val predicate = Predicate<Int> { it % 2 == 1 }
    return getList(list, predicate)
}
fun getList(
    list: String,
    predicate: Predicate<Int>,
    ): List<String>{
    return list.split(" ").filterIndexed { index, _ -> predicate.test(index) }
}