package signature

fun main() {
    val name = readLine()!!
    val nameLength = name.length
    println("*".repeat(nameLength + 4))
    println("* $name *")
    println("*".repeat(nameLength + 4))
}
