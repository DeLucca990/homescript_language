# Pdl Language

## Context:
Pdl is a general-purpose programming language designed to be simple, intuitive, and educational. Its primary goal is to teach fundamental concepts of programming logic and algorithm development. The language supports basic types (`integer`, `decimal`, `text`, and `boolean`), arithmetic and logical operations, typed function parameters, and conditional (`if`/`else`), looping (`while`) constructs and have 
built-in `print` function. 

## Code Example:
```bash
var message: text = "Hello World PDL!";
var counter: integer = 0;

func hello_world(name: text): text {
    return "Hello, " + name + "!";
}

func factorial(n: integer): integer {
    var result: integer = 1;
    while (n > 1) {
        result = result * n;
        n = n - 1;
    }
    return result;
}

func main() {
    print(message);

    var name: text = "Explorer";
    print(hello_world(name));

    var num: integer = 5;
    print("The factorial of " + num + " is:");
    print(factorial(num));

    if (num > 0) {
        print("Positive number!");
    } else {
        print("Zero or negative number.");
    }
}

main();
```