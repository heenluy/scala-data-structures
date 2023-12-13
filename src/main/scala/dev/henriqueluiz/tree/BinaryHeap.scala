package dev.henriqueluiz.tree

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object BinaryHeap extends App {
    class MaxHeap private (private var elements: ArrayBuffer[Int]){ 
        @tailrec
        private final def heapifyDown(index: Int): Unit = {
            val left = leftChild(index)
            val right = rightChild(index)
            var largest = index

            if left < elements.length && elements(left) > elements(largest) then
                largest = left
            
            if right < elements.length && elements(right) > elements(largest) then
                largest = right
                
            
            if largest != index then
                swap(index, largest)
                heapifyDown(largest)
        }

        private def swap(i: Int, j: Int): Unit = {
            val temp = elements(i)
            elements(i) = elements(j)
            elements(j) = temp
        }

        @tailrec
        private final def heapifyUp(index: Int): Unit = {
            if index <= 0 then return
            val parentIndex: Int = parent(index)
            
            if elements(index) > elements(parentIndex) then
                swap(index, parentIndex)
                heapifyUp(parentIndex)
        } 

        def insert(element: Int): Unit = {
            elements += element
            heapifyUp(elements.length - 1)
        }

        def remove(): Option[Int] = {
            if elements.isEmpty then
                println("Heap is empty.")
                return None
            val max = elements(0)
            elements(0) = elements.last
            elements.remove(elements.length - 1)
            heapifyDown(0)
            Some(max)
        }

        private def parent(index: Int): Int = (index - 1) / 2
        private def leftChild(index: Int): Int = index * 2 + 1
        private def rightChild(index: Int): Int = index * 2 + 2
        
        def isEmpty: Boolean = elements.isEmpty
        def getMaxElement: Option[Int] = elements.headOption

        override def toString: String = {
            elements.mkString("BinaryHeap(", ", ", ")")
        }
    }

    private object MaxHeap {
        def empty: MaxHeap = MaxHeap(ArrayBuffer.empty[Int])
    }

    private val binaryHeap = MaxHeap.empty
    binaryHeap.insert(5)
    binaryHeap.insert(8)
    binaryHeap.insert(11)
    binaryHeap.insert(7)
    binaryHeap.insert(29)
    println(binaryHeap)
}
