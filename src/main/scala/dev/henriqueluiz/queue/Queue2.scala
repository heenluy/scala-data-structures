package dev.henriqueluiz.queue

/**
  * Implementação de uma fila circular baseada em Array.
*/
class Queue2 private (
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
                rear = (rear + 1)
                arr(rear) = item
                size += 1
    end enqueue
    
    def dequeue(): Option[Int] =
        isEmpty match
            case true =>
                println("Queue is empty. Cannot dequeue.")
                None
            case _: Boolean =>
                val item = arr(front)
                front = (front + 1)
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

object Queue2:
    def apply(capacity: Int): Queue2 =
        new Queue2(new Array[Int](capacity), 0, -1, capacity, 0)
end Queue2
