package dev.henriqueluiz.queue

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object PriorityQueue extends App {

  private class PriorityQueue[T](var heap: ArrayBuffer[T], val priorityFunc: (T, T) => Boolean) {
    def enqueue(item: T): Unit = {
      heap = heap :+ item
      heapifyUp(heap.length - 1)
    }

    def dequeue(): Option[T] = {
      if heap.isEmpty then return None
      val priorityItem: T = heap(0)
      heap(0) = heap.last
      heap -= heap.last
      heapifyDown(0)
      Some(priorityItem)
    }

    @tailrec
    private def heapifyUp(index: Int): Unit = {
      if index <= 0 then return
      val parent: Int = (index - 1) / 2

      if priorityFunc(heap(index), heap(parent)) then
        swap(index, parent)
        heapifyUp(parent)
    }

    @tailrec
    private def heapifyDown(index: Int): Unit = {
      val left = index * 2 + 1
      val right = index * 2 + 2
      var priorityIndex: Int = if left < heap.length && priorityFunc(heap(left), heap(index)) then left else index
      if right < heap.length && priorityFunc(heap(right), heap(priorityIndex)) then priorityIndex = right

      if priorityIndex != index then
        swap(index, priorityIndex)
        heapifyDown(priorityIndex)
    }

    private def swap(i: Int, j: Int): Unit = {
      val temporary: T = heap(i)
      heap(i) = heap(j)
      heap(j) = temporary
    }

    override def toString: String = heap.mkString("Queue(", ", ", ")")
  }

  private val maxQueue = new PriorityQueue[Int](ArrayBuffer.empty[Int], (x, y) => x > y)
  maxQueue.enqueue(1)
  maxQueue.enqueue(8)
  maxQueue.enqueue(6)
  maxQueue.enqueue(4)
  maxQueue.enqueue(17)
  println(maxQueue)
  maxQueue.dequeue()
  println(maxQueue)

  println("_" * 25)

  private val minQueue = new PriorityQueue[Int](ArrayBuffer.empty[Int], (x, y) => x < y)
  minQueue.enqueue(1)
  minQueue.enqueue(8)
  minQueue.enqueue(6)
  minQueue.enqueue(4)
  minQueue.enqueue(17)
  println(minQueue)
  minQueue.dequeue()
  println(minQueue)

}
