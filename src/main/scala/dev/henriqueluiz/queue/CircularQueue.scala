package dev.henriqueluiz.queue

class CircularQueue private (
              private var data: Array[Int],
              private var front: Int,
              private var rear: Int,
              private var capacity: Int,
              private var size: Int
            )
    {
        def enqueue(item: Int): Unit = {
            if isFull then
                println("Queue is full.")
            else
                rear = (rear + 1) % capacity
                data(rear) = item
                size += 1
        }

        /* 
            * Se o dividendo for menor que o divisor, o resto será o dividendo.
            * '(front + 1) % capacity' = resto da divisão de (front + 1) / capacity
            * Se eu não usar essa fórmula, a fila será preenchida uma única vez.
            * Ex.: se o array tiver o tamanho fixo igual a 3, após atingir esse index,
                eu não vou poder reaproveitar a fila.
        */
        def dequeue(): Option[Int] = {
            if isEmpty then
                println("Queue is empty.")
                None
            else
                val removedItem = data(front)
                data(front) = 0
                front = (front + 1) % capacity
                size -= 1
                Some(removedItem)
        }

        def getFront(): Option[Int] = {
            if isEmpty then
                println("Queue is empty.")
                None
            else
                Some(data(front))
        }

        def isEmpty: Boolean = size == 0
        def isFull: Boolean = size == capacity

        override def toString(): String = {
            data.mkString("Queue(", ", ", ")")
        }
    }

object CircularQueue {
    def apply(capacity: Int): CircularQueue = {
        new CircularQueue(new Array[Int](capacity), 0, -1, capacity, 0)
    }
}
