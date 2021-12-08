import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testcase.TestCase

/** Default testCase. */
fun <T> testCase(attach: T, input: String) = TestCase<T>().apply {
    setInput(input)
    setAttach(attach)
}

class Task1Test : StageTest<Unit>() {

    override fun generate() = listOf(
            testCase(Unit, "")
    )

    override fun check(reply: String, clue: Unit): CheckResult {
        val badge = " _____________\n" +
                "| Hyper Skill |\n" +
                " •••••••••••••"

        if (reply.trim('\n', ' ') != badge.trim(' ')) {
            return CheckResult.wrong(
                    "Your output is wrong! " +
                            "See example #1.")
        } else {
            return CheckResult.correct()
        }

    }
}

