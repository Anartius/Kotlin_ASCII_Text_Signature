package signature

import kotlin.math.ceil
import kotlin.math.max

fun main() {
    print("Enter name and surname: ")
    val name = readLine()!!

    print("Enter person's status: ")
    val status = readLine()!!

    var letterTop = ""
    var letterMiddle = ""
    var letterBottom = ""
    name.forEach { letterTop += " " + getPartOfLetter(it, 0) }
    name.forEach { letterMiddle += " " + getPartOfLetter(it, 1) }
    name.forEach { letterBottom += " " + getPartOfLetter(it, 2) }

    val length = max(letterTop.length - 1, status.length)

    val nameLeftSpace = ceil(((length - letterTop.length).toDouble() / 2)).toInt() + 1
    val nameRightSpace = if ((length - (letterTop.length - 1)) % 2 == 0) {
        ceil(((length - letterTop.length).toDouble() / 2)).toInt() + 2
    } else (length - letterTop.length) / 2 + 3

    val statusLeftSpace = (length - status.length) / 2 + 2
    val statusRightSpace = if ((length - status.length) % 2 == 0) {
        (length - status.length) / 2 + 2
    } else (length - status.length) / 2 + 3

    println("*".repeat(length + 6))

    println("*" + " ".repeat(nameLeftSpace) + letterTop +
            " ".repeat(nameRightSpace) + "*")
    println("*" + " ".repeat(nameLeftSpace) + letterMiddle +
            " ".repeat(nameRightSpace) + "*")
    println("*" + " ".repeat(nameLeftSpace) + letterBottom +
            " ".repeat(nameRightSpace) + "*")

    println("*" + " ".repeat(statusLeftSpace) + status +
            " ".repeat(statusRightSpace) + "*")

    println("*".repeat(length + 6))

}

fun getPartOfLetter (letter: Char, level: Int) : String {

    val partOfLetter = when (letter.lowercase().first()) {
        'a' -> mutableListOf("____", "|__|", "|  |")
        'b' -> mutableListOf("___ ", "|__]", "|__]")
        'c' -> mutableListOf("____", "|   ", "|___")
        'd' -> mutableListOf("___ ", "|  \\", "|__/")
        'e' -> mutableListOf("____", "|___", "|___")
        'f' -> mutableListOf("____", "|___", "|   ")
        'g' -> mutableListOf("____", "| __", "|__]")
        'h' -> mutableListOf("_  _", "|__|", "|  |")
        'i' -> mutableListOf("_", "|", "|")
        'j' -> mutableListOf(" _", " |", "_|")
        'k' -> mutableListOf("_  _", "|_/ ", "| \\_")
        'l' -> mutableListOf("_   ", "|   ", "|___")
        'm' -> mutableListOf("_  _", "|\\/|", "|  |")
        'n' -> mutableListOf("_  _", "|\\ |", "| \\|")
        'o' -> mutableListOf("____", "|  |", "|__|")
        'p' -> mutableListOf("___ ", "|__]", "|   ")
        'q' -> mutableListOf("____", "|  |", "|_\\|")
        'r' -> mutableListOf("____", "|__/", "|  \\")
        's' -> mutableListOf("____", "[__ ", "___]")
        't' -> mutableListOf("___", " | ", " | ")
        'u' -> mutableListOf("_  _", "|  |", "|__|")
        'v' -> mutableListOf("_  _", "|  |", " \\/ ")
        'w' -> mutableListOf("_ _ _", "| | |", "|_|_|")
        'x' -> mutableListOf("_  _", " \\/ ", "_/\\_")
        'y' -> mutableListOf("_   _", " \\_/ ", "  |  ")
        'z'-> mutableListOf("___ ", "  / ", " /__")
        else -> mutableListOf("    ", "    ", "    ")
    }
    return partOfLetter[level]
}