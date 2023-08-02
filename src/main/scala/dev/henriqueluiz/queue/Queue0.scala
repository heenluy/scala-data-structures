package dev.henriqueluiz.queue

// É uma implementação simples da estrtura fila (Queue).
// Possui o tamanho dinâmico.
class Queue0[A]:
    
    /**
    * Uma 'case class' funciona como se fosse uma classe estática do Java.
    * @param data é o tipo genérico a ser usado.
    * @param next aponta para o próximo nó (iniciada como null).
    * 
    */
    private case class Node(data: A, var next: Option[Node] = None)

    private var front: Option[Node] = None
    private var rear: Option[Node] = None
    private var size: Int = 0

    def enqueue(item: A): Unit =
        val newNode = Node(item)

        isEmpty match
            case true => front = Some(newNode)
            case _: Boolean => rear.get.next = Some(newNode)

        // 1° rear e front = newNode0 = Node(item0, None)
        // - front = newNode0.next -> newNode1
        // - rear = newNode1.next -> None

        rear = Some(newNode) // Sempre vai ser o último nó com next null.
        size += 1
    end enqueue

    def dequeue(): Option[A] =
        if isEmpty then
            println("The queue is empty.")
            None

        val item = front.get.data
        front = front.get.next
        size -= 1

        if isEmpty then rear = None
        Some(item)
    end dequeue   

    def getFront: Option[A] =
         isEmpty match
            case true => None
            case _: Boolean => Some(front.get.data)
    end getFront
        
    def isEmpty: Boolean = size == 0
    def getSize: Int = size

    override def toString(): String =
        var ref = front
        var result: String = "Queue("
        while ref.isDefined do
            if !ref.get.next.isDefined then
                result += s"${ref.get.data}"    
            else
                result += s"${ref.get.data}, "
            ref = ref.get.next
        result += ")"
        result