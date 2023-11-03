package dev.henriqueluiz.queue

import scala.reflect.ClassTag

class SimpleGenericQueue[A: ClassTag] private (
              private var data: Array[A],
              private var front: Int,
              private var rear: Int,
              private var capacity: Int,
              private var size: Int
            )
    {
        def enqueue(item: A): Unit = {
            if isFull then
                println("Queue is full.")
            else
                rear = (rear + 1) % capacity
                data(rear) = item
                size += 1
        }

        def dequeue(): Option[A] = {
            if isEmpty then
                println("Queue is empty.")
                None
            else
                val removedItem = data(front)
                data(front) = null.asInstanceOf[A]
                front = (front + 1) % capacity
                size -= 1
                Some(removedItem)
        }

        def getFront(): Option[A] = {
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

object SimpleGenericQueue {
    def apply[A: ClassTag](capacity: Int): SimpleGenericQueue[A] = {
        new SimpleGenericQueue(new Array[A](capacity), 0, -1, capacity, 0)
    }
}
