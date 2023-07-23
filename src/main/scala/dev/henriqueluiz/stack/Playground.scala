package dev.henriqueluiz.stack

@main def main(): Unit =
    
    // ----- STACK ZERO -----
    val stack0 = Stack0.empty[Int]
    stack0.push(1)
    stack0.push(2)
    stack0.push(3)
    //println(s"STACK ZERO: ${stack0}")

    // ----- STACK ONE -----
    val stack1 = Stack1.empty[Int]
    stack1.push(1)
    stack1.push(2)
    stack1.push(3)
    //println(s"STACK ONE: $stack1")

    // ----- STACK TWO -----
    val stack2 = Stack2.empty[Int]
    stack2.push(1)
    stack2.push(2)
    stack2.push(3)
    stack2.push(4)
    stack2.push(5)
    //println(s"STACK TWO: $stack2")

    /**
      * Treinar a ánalise de complexidade de algorítimos.
    */

    val stack3 = Stack3[Int]
    stack3.push(1)
    stack3.push(2)
    stack3.push(3)
    println(s"STACK THREE: ${stack3.top(4)}")