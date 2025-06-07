# HomeScript Language Interpreter

A Kotlin-based interpreter for the HomeScript automation language. This tool parses and executes event-driven scripts defined in the HomeScript DSL, printing conditions and actions to the console.

## Features

* **Rule Parsing**: Supports `Rule` statements with event conditions and optional time restrictions.
* **Action Execution**: Prints a list of actions to be executed for each rule.
* **Extensible AST**: Easily extendable model definitions for adding new statement types.

## Prerequisites

* **Java Development Kit**: Version 17
* **Gradle**: Version 8.14 or higher
* **Kotlin**: Bundled with the Gradle Kotlin plugin

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/DeLucca990/homescript_language
   # Navigate to the project directory
   cd home_script_interpreter
   ```
2. Configure your `JAVA_HOME`.
   Ensure your `JAVA_HOME` environment variable points to a JDK 17 installation. For example (macOS/Homebrew):
   
   ```bash
   export JAVA_HOME="$(brew --prefix openjdk@17)/libexec/openjdk.jdk/Contents/Home"
   ```
3. **Build the project**
   ```bash
   ./gradlew build
   ```

## Usage

Run the interpreter with a HomeScript file as an argument:

```bash
./gradlew run --args='tests/test1.homs'
```

## Example Script

```homs
when door_opened at front_door
  turn_off "living_room_light"
  lock "front_door"
  set_temperature "bedroom1_thermostat", "20"
```

Output:

```
== Condições de Evento ==
Evento 'door_opened' em 'front_door'
== Ações a serem executadas ==
- turn_off(living_room_light)
- lock(front_door)
- set_temperature(bedroom1_thermostat, 20)
```