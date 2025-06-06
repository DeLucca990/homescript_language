import parser.HomeScriptParser
import interpreter.HomeScriptInterpreter
import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Uso: ./gradlew run --args='tests/arquivo.homs'")
        return
    }

    val code = File(args[0]).readText()
    val program = HomeScriptParser.parse(code)
    HomeScriptInterpreter.execute(program)
}
