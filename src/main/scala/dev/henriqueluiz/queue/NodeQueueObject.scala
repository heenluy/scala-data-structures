package dev.henriqueluiz.queue

object NodeQueueObject extends App {
  class NodeQueue[T] {
    private case class Node(element: T, var next: Option[Node] = None)
    private var front: Option[Node] = None
    private var rear: Option[Node] = None
    private var size: Int = 0

    def enqueue(element: T): Unit = {
      val node: Node = Node(element)
      if size == 0 then
        front = Some(node)
      else
        rear.get.next = Some(node)
      rear = Some(node)
      size += 1
    }

    def dequeue: Option[T] = {
      if size == 0 then None
      else
        val temp: T = front.get.element
        front = front.get.next
        size -= 1
        if size == 0 then rear = None
        Some(temp)
    }

    def getFrontElement: Option[T] = if size == 0 then None else Some(front.get.element)
    def getRearElement: Option[T] = if size == 0 then None else Some(rear.get.element)

    override def toString: String = {
      var frontRef = front
      val elements = (0 until size).map(_ => {
        val element = frontRef.get.element
        frontRef = frontRef.get.next
        element
      })
      elements.mkString("Queue(", ", ", ")")
    }
  }

  val queue = NodeQueue[String]
  queue.enqueue("A")
  queue.enqueue("B")
  queue.enqueue("C")
  queue.enqueue("D")
  println(queue)
  println(queue.getFrontElement)
  println(queue.getRearElement)
}
