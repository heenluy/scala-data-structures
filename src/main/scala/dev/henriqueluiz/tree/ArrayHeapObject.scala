package dev.henriqueluiz.tree

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object ArrayHeapObject extends App {
    class BinaryHeap private (
                            private var items: ArrayBuffer[Int],
                            private val priorityFun: (x: Int, y: Int) => Boolean

    ){
        @tailrec
        private final def heapifyDown(index: Int): Unit = {
            val left = leftChild(index)
            val right = rightChild(index)
            var biggest = index

            if left < items.length && priorityFun(items(left), items(biggest)) then
                biggest = left

            if right < items.length && priorityFun(items(right), items(biggest)) then
                biggest = right

            if index != biggest then
                swap(index, biggest)
                heapifyDown(biggest)
        }

        @tailrec
        private final def heapifyUp(index: Int): Unit = {
            if index <= 0 then return
            val parentEl = parent(index)

            if priorityFun(items(index), items(parentEl)) then
                swap(index, parentEl)
                heapifyUp(parentEl)
        }

        private def swap(i: Int, j: Int): Unit = {
            val t: Int = items(i)
            items(i) = items(j)
            items(j) = t
        }

        def insert(item: Int): Unit = {
            items += item
            heapifyUp(items.length - 1)
        }

        def remove(): Option[Int] = {
            if items.isEmpty then
                println("The max heap is empty")
                return None

            val maxEl = items(0)
            items(0) = items.last
            items -= items.last
            heapifyDown(0)
            Some(maxEl)
        }

        private def parent(index: Int): Int = (index - 1) / 2
        private def leftChild(index: Int): Int = index * 2 + 1
        private def rightChild(index: Int): Int = index * 2 + 2

        def getMaxElement: Option[Int] = items.headOption

        override def toString: String = {
            items.mkString("BinaryHeap(", ", ", ")")
        }
    }

    private object BinaryHeap {
        def max: BinaryHeap = BinaryHeap(ArrayBuffer.empty[Int], (x, y) => x > y)
        def min: BinaryHeap = BinaryHeap(ArrayBuffer.empty[Int], (x, y) => x < y)
    }

    println("__Max Heap__")
    private val maxHeap = BinaryHeap.max
    maxHeap.insert(4)
    maxHeap.insert(8)
    maxHeap.insert(2)
    maxHeap.insert(16)
    println(maxHeap)
    maxHeap.remove()
    println(maxHeap)
    println("-" * 25)

    println("__Min Heap__")
    private val minHeap = BinaryHeap.min
    minHeap.insert(4)
    minHeap.insert(8)
    minHeap.insert(2)
    minHeap.insert(16)
    println(minHeap)
    minHeap.remove()
    println(minHeap)
    
    // TODO: create a method which removes a specific element.
    // TODO: create a node-based queue.
}
