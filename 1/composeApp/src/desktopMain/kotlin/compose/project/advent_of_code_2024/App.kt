package compose.project.advent_of_code_2024

import adventofcode2024.composeapp.generated.resources.Res
import adventofcode2024.composeapp.generated.resources.list
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.runBlocking
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import java.util.function.Predicate
import kotlin.math.absoluteValue

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = getDistance(list = stringResource( Res.string.list)),
            )
        }
    }
}

const val testList  = "3 4 4 3 2 5 1 3 3 9 3 3"

fun getLeftList(
    list: String,
    ): List<String>{
    val predicate = Predicate<Int> { it % 2 == 0 }
    return getList(list, predicate).sorted()
}
fun getRigthList(
    list: String,
    ): List<String>{
    val predicate = Predicate<Int> { it % 2 == 1 }
    return getList(list, predicate).sorted()
}
fun getList(
    list: String,
    predicate: Predicate<Int>,
    ): List<String>{
    return list.split(" ").filterIndexed { index, _ -> predicate.test(index) }
}

fun getDistance(
    list: String,
): String {
    println("list s = $list")
    var result = 0
    val left = getLeftList(list)
    println("left s = $left")
    val rigth = getRigthList(list)
    println("rigth s = $rigth")
    if (left.size == rigth.size) {
        left.forEachIndexed { index, s ->
            println("left s = $s")
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

/*suspend fun getList(): String {
    val client = HttpClient{
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(accessToken = "your_access_token", refreshToken = "your_refresh_token")
                }
            }
        }
    }
    val result = client.get("https://adventofcode.com/2024/day/1/input").bodyAsText()
    println(result)
    client.close()
    return result
}*/

//2 + 1 + 0 + 1 + 2 + 5