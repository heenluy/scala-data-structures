package dev.henriqueluiz.queue

import scala.reflect.ClassTag


object ArrayQueueObject extends App {
  private class ArrayQueue[T: ClassTag](capacity: Int, queueStrategy: (a: Int, b: Int) => Int) {
    private val data: Array[Option[T]] = new Array[Option[T]](capacity)

    private var front: Int = 0
    private var rear: Int = -1
    private var size: Int = 0

    def enqueue(element: T): Unit = data match {
      case d if size == capacity => println("The is queue full. Cannot enqueue!")
      case _ =>
        rear = queueStrategy(rear, capacity)
        data(rear) = Some(element)
        size += 1
    }

    def dequeue: Option[T] = data match {
      case d if d.isEmpty =>
        println("The queue is empty. Cannot dequeue!")
        None
      case elements: Array[Option[T]] =>
        val firstIn: Option[T] = elements(front)
        elements(front) = None
        front = queueStrategy(front, capacity)
        size -= 1
        firstIn
    }

    def peek: Option[T] = if data.isEmpty then None else data(front)

    override def toString: String = {
      val elements = data.map(v => { if v == null then "_" else if v.isEmpty then "_" else v.get.toString })
      elements.mkString("Queue(", ", ", ")")
    }
  }

  // Simple Queue
  private val simple = ArrayQueue[Int](5, (a, b) => a + 1)
  simple.enqueue(7)
  simple.enqueue(18)
  simple.enqueue(13)
  simple.enqueue(6)
  simple.enqueue(2)
  println(simple)
  println(simple.dequeue)
  println(simple)


  println("-" * 30)

  // Circular Queue
  private val circular = ArrayQueue[Int](5, (a, b) => (a + 1) % b)
  circular.enqueue(7)
  circular.enqueue(18)
  circular.enqueue(13)
  circular.enqueue(6)
  circular.enqueue(2)
  println(circular)
  println(circular.dequeue)
  println(circular)
  circular.enqueue(44)
  println(circular)

}
