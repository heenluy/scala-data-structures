package dev.henriqueluiz.queue

@main def main(): Unit =
    // QUEUE ZERO
    val Q0 = Queue0[Int]
    Q0.enqueue(5)
    Q0.enqueue(10)
    Q0.enqueue(15)
    println(Q0)

    
