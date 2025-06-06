package interpreter

import model.*

object HomeScriptInterpreter {
    fun execute(program: Program) {
        for (stmt in program.statements) {
            when (stmt) {
                is Rule -> {
                    println("== Condição de evento ==")
                    println("Evento '${stmt.condition.event}' em '${stmt.condition.location}'")
                    stmt.condition.timeCondition?.let {
                        println("Restrição de tempo: ${it.type} ${"%02d".format(it.hour)}:${"%02d".format(it.minute)}")
                    }
                    println("== Ações a serem executadas ==")
                    stmt.actions.forEach { action ->
                        println("- ${action.action}(${action.arguments.joinToString(", ")})")
                    }
                }

                is ActionStatement -> {
                    println("- ${stmt.action}(${stmt.arguments.joinToString(", ")})")
                }

                else -> {
                    println("Instrução desconhecida: $stmt")
                }
            }
        }
    }
}
