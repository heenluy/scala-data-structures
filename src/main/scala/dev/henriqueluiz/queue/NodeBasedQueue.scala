package dev.henriqueluiz.queue

class NodeBasedQueue[A] {
  private case class Node(element: A, var next: Option[Node] = None)
  private var front: Option[Node] = None
  private var rear: Option[Node] = None
  private var size: Int = 0
  
  /*
   * PARTE MAIS INTERESSANTE DESSE MÉTODO
   * ------------------------------------
   * Na 1ª operação, o 'front' e o 'rear' apontam para o mesma endereço na mémoria.
   * A partir da 2ª operação, o 2º case vai servir só para definir o 'next' do 'front'.
   * O 'next' do último nó do 'front' sempre será o mesmo do 'rear' .
   * O 'rear' tem que apontar para o novo nó criado 'newNode', com 'next' igual a 'None'.
   * O 'front' sempre terá um encadeamento a mais que o 'rear'.
  */
  
  def enqueue(element: A): Unit = {
    val newNode: Node = Node(element)
    isEmpty match
        case true => front = Some(newNode)
        case _: Boolean => rear.get.next = Some(newNode)
    rear = Some(newNode)
    size += 1
  }

  def dequeue(): Option[A] = {
    isEmpty match
        case true =>
            println("Queue is empty. Cannot dequeue.")
            None
        case _: Boolean =>
            val removedEl = front.get.element
            front = front.get.next
            size -= 1
            if isEmpty then rear = None
            Some(removedEl)  
  }

  def getFront(): Option[A] = {
    if isEmpty then
        println("Queue is empty. Cannot dequeue.")
        None
    Some(front.get.element)
  }

  def getSize: Int = size
  def isEmpty: Boolean = size == 0
  
  override def toString(): String = {
    var frontSnapshot = front
    var result: String = "Queue("
    while frontSnapshot.isDefined do
        if !frontSnapshot.get.next.isDefined then
            result += s"${frontSnapshot.get.element}"    
        else
            result += s"${frontSnapshot.get.element}, "
        frontSnapshot = frontSnapshot.get.next
    result += ")"
    result
  }

}