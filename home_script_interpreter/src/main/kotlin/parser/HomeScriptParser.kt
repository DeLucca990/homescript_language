package parser

import model.*

object HomeScriptParser {
    private val ruleRegex = Regex(
        """when\s+([a-zA-Z_][\w]*)\s+in\s+"([^"]+)"(?:\s+(after|before)\s+(\d{1,2}):(\d{2}))?\s*\{([^}]*)}""",
        RegexOption.DOT_MATCHES_ALL
    )

    private val actionLineRegex = Regex("""([a-zA-Z_][\w]*)\s+((?:"[^"]+"|\w+)(?:\s*,\s*(?:"[^"]+"|\w+))*)""")

    fun parse(code: String): Program {
        val statements = mutableListOf<Statement>()

        // Quando possui 'when'
        for (match in ruleRegex.findAll(code)) {
            val event = match.groupValues[1]
            val location = match.groupValues[2]
            val timeType = match.groupValues[3]
            val hour = match.groupValues[4]
            val minute = match.groupValues[5]
            val body = match.groupValues[6].trim()

            val timeCondition = if (timeType.isNotBlank()) {
                TimeCondition(timeType, hour.toInt(), minute.toInt())
            } else null

            val condition = Condition(event, location, timeCondition)
            val actions = parseActions(body)

            statements.add(Rule(condition, actions))
        }

        // Quando não possui 'when'
        val cleanedCode = ruleRegex.replace(code, "").trim()

        val isolatedActions = parseActions(cleanedCode)
        statements.addAll(isolatedActions)

        return Program(statements)
    }

    private fun parseActions(body: String): List<ActionStatement> {
        return body.lines()
            .mapNotNull { line ->
                val trimmed = line.trim()
                if (trimmed.isBlank()) return@mapNotNull null

                val match = actionLineRegex.matchEntire(trimmed)
                if (match != null) {
                    val action = match.groupValues[1]
                    val args = match.groupValues[2].split(",").map { it.trim().removeSurrounding("\"") }
                    ActionStatement(action, args)
                } else {
                    println("Linha ignorada (sintaxe inválida): $trimmed")
                    null
                }
            }
    }
}