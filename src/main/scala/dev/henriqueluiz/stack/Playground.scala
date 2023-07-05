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