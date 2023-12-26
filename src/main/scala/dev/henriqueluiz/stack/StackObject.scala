package dev.henriqueluiz.stack

import scala.collection.mutable.ArrayBuffer

object StackObject extends App {
  // Array Stack
  private class ArrayStack[T] {
    private var data: ArrayBuffer[T] = ArrayBuffer.empty[T]

    def push(item: T): Unit = {
      data = data :+ item
    }

    def pop: Option[T] = data match {
      case x if x.isEmpty => None
      case _: ArrayBuffer[T] =>
        val top: T = data.last
        data -= data.last
        Some(top)
    }

    def peek: Option[T] = data match {
      case y if y.isEmpty => None
      case _: ArrayBuffer[T] => Some(data.last)
    }

    def peek(index: Int): Option[T] = index match {
      case 0 => None
      case z if z > data.length - 1 || z < 0 => None
      case v => Some(data(data.length - v))
    }

    override def toString: String = data.reverse.mkString("ArrayStack(", ", ", ")")
  }

  // Node Stack
  private class NodeStack[T] {
    private case class Node(item: T, var next: Option[Node] = None)
    private var data: Option[Node] = None
    private var size: Int = 0

    def push(item: T): Unit = {
      val newNode = Node(item)
      size match
        case s if s == 0 => data = Some(newNode)
        case _ =>
          val snapshot: Option[Node] = data
          data = Some(newNode)
          data.get.next = snapshot
      size += 1
    }

    def pop: Option[T] = size match {
      case s if s == 0 => None
      case _ =>
        val top: T = data.get.item
        data = data.get.next
        size -= 1
        Some(top)
    }

    def peek: Option[T] = if size > 0 then Some(data.get.item) else None

    def peek(index: Int): Option[T] = index match {
      case v if size > 0 && v > 0 && v <= size =>
        var top = data
        for i <- 1 until v do
          top = top.get.next
        Some(top.get.item)
      case _ => None
    }

    override def toString: String = {
     val elements = (0 until size).map {_ =>
       val value = data.get.item
       data = data.get.next
       value
     }
     elements.mkString("NodeStack(", ", ", ")")
    }
  }

  // array based stack
  private val arrayStack = ArrayStack[Int]
  arrayStack.push(1)
  arrayStack.push(6)
  arrayStack.push(7)
  arrayStack.push(11)
  println(arrayStack.peek(1))
  println(arrayStack)

  println("_" * 30)

  // node based stack
  private val nodeStack = NodeStack[Int]
  nodeStack.push(1)
  nodeStack.push(6)
  nodeStack.push(7)
  nodeStack.push(11)
  println(nodeStack.peek(1))
  println(nodeStack)

}
