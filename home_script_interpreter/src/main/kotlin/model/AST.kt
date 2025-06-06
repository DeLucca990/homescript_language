package model

data class Program(val statements: List<Statement>)

sealed class Statement
data class Rule(val condition: Condition, val actions: List<ActionStatement>) : Statement()
data class ActionStatement(val action: String, val arguments: List<String>) : Statement()

data class Condition(val event: String, val location: String, val timeCondition: TimeCondition?)
data class TimeCondition(val type: String, val hour: Int, val minute: Int)
