package dev.henriqueluiz.queue

@main def main(): Unit =
    // QUEUE ZERO
    val Q0 = Queue0[Int]
    Q0.enqueue(5)
    Q0.enqueue(10)
    Q0.enqueue(15)
    println("QUEUE ZERO => " + Q0)

    // QUEUE ONE
    val Q1 = Queue1.apply(5)
    Q1.enqueue(1)
    Q1.enqueue(2)
    Q1.enqueue(3)
    Q1.enqueue(4)
    Q1.enqueue(5)
    println("QUEUE ONE => " + Q1.peek())

    
