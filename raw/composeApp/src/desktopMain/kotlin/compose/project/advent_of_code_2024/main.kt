package compose.project.advent_of_code_2024

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "adventOfCode2024",
    ) {
        App()
    }
}