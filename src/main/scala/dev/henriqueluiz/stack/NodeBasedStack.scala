package dev.henriqueluiz.stack

class NodeBasedStack[A] {
    case class Node (element: A, var next: Option[Node] = None)
    private var data: Option[Node] = None
    private var size: Int = 0
    
    def push(element: A): NodeBasedStack[A] =
        val newNode = Node(element)
        isEmpty match
            case true =>
                data = Some(newNode)
            case _: Boolean =>
                val snapshotNode = data
                data = Some(newNode)
                data.get.next = snapshotNode
        size += 1
        this

    def pop(): Option[(A, NodeBasedStack[A])] =
        isEmpty match
            case true =>
                println("The stack is empty.")
                None
            case _: Boolean => 
                val removedEl = data.get.element
                data = data.get.next
                size -= 1
                Some((removedEl, this))

    def top(): Option[A] = isEmpty match
        case true => None
        case _: Boolean => Some(data.get.element)

    def top(index: Int): Option[A] = index match
        case x if isEmpty =>
            println("The stack is empty.")
            None
        case y if y <= 0 || y > size =>
            println(s"Invalid index: $index")
            None
        case _ =>
            var snapshotNode = data
            for i <- 1 until index do
                snapshotNode = snapshotNode.get.next
            Some(snapshotNode.get.element)
    
    def isEmpty: Boolean = size == 0
    
    override def toString(): String =
        var snapshotNode = data
        var result = "Stack("
        while snapshotNode.isDefined do
            if !snapshotNode.get.next.isDefined then
                result += s"${snapshotNode.get.element}"
            else
                result += s"${snapshotNode.get.element}, "
            snapshotNode = snapshotNode.get.next
        result += ")"
        result
}