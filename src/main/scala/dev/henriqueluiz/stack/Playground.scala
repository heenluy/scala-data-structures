package dev.henriqueluiz.stack

@main def main(): Unit =
    
    // ----- STACK ZERO -----
    val stack0 = StackZero.empty[Int]
    stack0.push(1)
    stack0.push(2)
    stack0.push(3)
    println(s"STACK ZERO :: $stack0")

    // ----- STACK ONE -----
    val stack1 = StackOne.empty[Int]
    stack1.push(1)
    stack1.push(2)
    stack1.push(3)
    println(s"STACK ONE :: $stack1")

    // ----- STACK TWO -----
    val stack2 = StackTwo.empty[Int]
    stack2.push(1)
    stack2.push(2)
    stack2.push(3)
    stack2.push(4)
    stack2.push(5)
    println(s"STACK TWO :: $stack2")

    // ----- STACK TEST -----
    val stackTest = StackTest.empty[String]
    stackTest.push("World")
    stackTest.push("Hello")
    println(s"STACK TEST :: $stackTest")