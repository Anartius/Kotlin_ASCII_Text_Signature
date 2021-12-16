package signature

import java.io.File
import kotlin.math.max
import kotlin.math.ceil
import kotlin.math.floor

fun main() {

    print("Enter name and surname: ")
    val name = readLine()!!
    print("Enter person's status: ")
    val status = readLine()!!

    var nameTopLine = ""
    var statusTopLine = ""
//    val romanFileName = "../ASCII Text Signature/ASCII Text Signature/task/src/roman.txt"
//    val mediumFileName = "../ASCII Text Signature/ASCII Text Signature/task/src/medium.txt"
    val romanFileName = "src/roman.txt"
    val mediumFileName = "src/medium.txt"
    val roman = File(romanFileName)
    val medium = File(mediumFileName)
    val romanLines = roman.readLines(Charsets.US_ASCII)
    val mediumLines = medium.readLines(Charsets.US_ASCII)

    name.forEach { nameTopLine += getPartOfLetter(romanLines, it, 0) }
    status.forEach { statusTopLine += getPartOfLetter(mediumLines, it, 0) }
    val max = max(nameTopLine.length, statusTopLine.length)
    println("8".repeat(max + 8))

    printLines(name, romanLines, max)
    printLines(status, mediumLines, max)

    println("8".repeat(max + 8))
}


// Printing part of name or status. Get needed String as <String> and
// line number as <Int>. Print needed line.
fun printLines (string: String, lines: List<String>, maxStrLength: Int) {
    val fontHeight = lines[0].split(" ").first().toInt()
    var str = ""
    string.forEach { str += getPartOfLetter(lines, it, 0) }

    val length = str.length
    val leftSpace = if (maxStrLength == length) {
        ((maxStrLength + 4) - length) / 2
    } else {
        floor(((maxStrLength + 4) - length).toDouble() / 2).toInt()
    }
    val rightSpace = if (maxStrLength == length) {
        ((maxStrLength + 4) - length) / 2
    } else {
        ceil(((maxStrLength + 4) - length).toDouble() / 2).toInt()
    }

    for (i in 0 until fontHeight) {
        var line = ""
        string.forEach { line += getPartOfLetter(lines, it, i) }
        println("88" + " ".repeat(leftSpace) + line + " ".repeat(rightSpace) + "88")
    }
}


// Get as input char as <Char>, and number of needed line as <int>.
// Return needed line as <String>
fun getPartOfLetter(lines: List<String>, char: Char, level: Int) : String {
    val fontHeight = lines[0].split(" ").first().toInt()
    var line = if (fontHeight == 10) "          " else "     "
    for (i in lines.indices) {
        if (lines[i].split(" ").first() == char.toString()) {
            line = lines[i + 1 + level]
            break
        }
    }

    return line
}