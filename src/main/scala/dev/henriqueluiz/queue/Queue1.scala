package dev.henriqueluiz.queue

/**
  * Implementação de uma fila circular baseada em Array.
  * A principal diferença para a lista simples é a capacidade de
    reaproveitar os espaços vazios.
*/
class Queue1 private (
    private var arr: Array[Int],
    private var front: Int,
    private var rear: Int,
    private var capacity: Int,
    private var size: Int
    ):

    def enqueue(item: Int): Unit =
        isFull match
            case true => println("Queue is full. Cannot enqueue.")
            case _: Boolean =>
                rear = (rear + 1) % capacity // Permite que os itens sejam alocados corretamente.
                arr(rear) = item // o 'rear' vai funcionar como um index
                size += 1
    end enqueue
    
    def dequeue(): Option[Int] =
        isEmpty match
            case true =>
                println("Queue is empty. Cannot dequeue.")
                None
            case _: Boolean =>
                val item = arr(front) 
                front = (front + 1) % capacity
                size -= 1
                println(s"The $item has been dequeued.")
                Some(item)
    end dequeue

    def peek(): Option[Int] =
        isEmpty match
            case true =>
                println("Queue is empty.")
                None
            case _: Boolean =>
                Some(arr(front))
    end peek
        
    def isFull: Boolean = size == capacity
    def isEmpty: Boolean = size == 0
    def getSize: Int = size

    override def toString(): String =
        arr.mkString("Queue(", " ,", ")")

object Queue1:
    def apply(capacity: Int): Queue1 =
        new Queue1(new Array[Int](capacity), 0, -1, capacity, 0)
end Queue1