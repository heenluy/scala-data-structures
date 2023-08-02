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
    println("QUEUE ONE => " + Q1)

    Q1.dequeue()
    
    // ADICIONARÁ O ITEM NO INÍCIO DA FILA
    Q1.enqueue(1)
    println("QUEUE ONE => " + Q1)

    // QUEUE ONE
    val Q2 = Queue2.apply(5)
    Q2.enqueue(1)
    Q2.enqueue(2)
    Q2.enqueue(3)
    Q2.enqueue(4)
    Q2.enqueue(5)
    println("QUEUE TWO => " + Q2)

    //Q2.dequeue()

    // CAUSARÁ UM ERRO DE ÍNDICE
    //Q2.enqueue(6)

    
