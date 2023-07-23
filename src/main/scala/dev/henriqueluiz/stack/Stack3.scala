package dev.henriqueluiz.stack

// Uma Stack (pilha) baseada em Nós.
class Stack3[A]:
    case class Node(data: A, var next: Option[Node] = None)
    
    private var linkedNode: Option[Node] = None
    private var size: Int = 0

    def push(element: A): Stack3[A] =
        val node = Node(element)    
        isEmpty match
            case true =>
                // Se a Pilha estiver vazia, ela passará a ter 1.
                linkedNode = Some(node)
            
            case _: Boolean =>
                // Pega a referência antiga.
                val oldNodeRef = linkedNode

                // O novo elemento vai para o topo e aponta para o antigo.
                linkedNode = Some(node)
                linkedNode.get.next = oldNodeRef
        size += 1
        this
    end push

    def pop(): Option[(A, Stack3[A])] =
        isEmpty match
            case true =>
                println("The stack is empty.")
                None
            case _: Boolean =>
                val removed = linkedNode.get.data
                linkedNode = linkedNode.get.next
                size -= 1
                Some(removed, this)
    end pop

    def top(): Option[A] =
        isEmpty match
            case true => None
            case _: Boolean => Some(linkedNode.get.data)
    end top

    def top(index: Int): Option[A] =
        var currentNode = linkedNode
        var data: Option[A] = None
        
        isEmpty match
            case true =>
                println("The stack is empty.")
                None
            
            case _: Boolean =>
                for 
                    i <- 1 until index
                do
                    if !currentNode.get.next.isDefined then
                        println(s"This index (${index}) isn't valid.")
                        data = None
                    else
                        currentNode = currentNode.get.next
                        data = Some(currentNode.get.data)
                    end if
        data
    end top

    def isEmpty: Boolean = size == 0
    def getSize: Int = size

    override def toString(): String =
        var ref = linkedNode
        var result = "Stack("
        while ref.isDefined do
            if !ref.get.next.isDefined then
                result += s"${ref.get.data}"
            else
                result += s"${ref.get.data}, "
            ref = ref.get.next
        result += ")"
        result
