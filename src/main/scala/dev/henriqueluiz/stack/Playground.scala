package dev.henriqueluiz.stack

@main def main(): Unit =
    val stack1 = Stack.apply[Int](1)
    stack1.push(2)
    stack1.push(3)
    
    println(stack1.pop())
    println(stack1)