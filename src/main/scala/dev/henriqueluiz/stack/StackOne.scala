package dev.henriqueluiz.stack

import scala.reflect.ClassTag

/*
    * Uma 'Stack' sem a Collection List.
    * Será usado um array.
    * Precisa de um contador/inteiro para calcular o seu tamanho.
*/

/*
    * O ClassTag é usado para fornecer informações de tipo
        em tempo de execução para coleções genéricas.
    
    * Ele é necessário para criar arrays quando o tipo do elemento não
       é conhecido em tempo de compilação devido ao uso de tipos genéricos.
*/

class StackOne[T: ClassTag] private (
    private var items: Array[T],
    private var size: Int ):
    
    /*
     *   1. Um novo array é criado com o tamanho +1
     *   2. Todos os elemntos do array principal é copiado para o novo.
     *   3. O item 'T' é adicionado ao novo array na última posição.
     *   4. Uma nova pilha é criada com o novo array e o size +1
    */

    def push(item: T): StackOne[T] =
        val newEls = new Array[T](size + 1)
        Array.copy(items, 0, newEls, 0, size)
        newEls(size) = item
        items = newEls
        size += 1
        this


    /*
    * 1. Verifica se a pilha está vazia.
    * 2. Pega o item que está no topo da pilha.
    * 3. Cria um novo array com uma posição a menos.
    * 4. Copia todos, exceto o último item, para o novo array.
    * 5. Retorna uma tupla com o item removido e a nova pilha. 
    */

    def pop(): Option[(T, StackOne[T])] =
        if size > 0 then
            val popped = items(size - 1)
            val newEls = new Array[T](size - 1)
            Array.copy(items, 0, newEls, 0, size - 1)
            items = newEls
            size -= 1
            Some((popped, this))
        else
            None

    /*
    * Caso a pilha esteja com algum item, vai retornar o último.
    */

    def top(): Option[T] =
        if size > 0 then
            Some(items(size - 1))
        else
            None

    /*
    * Retorna 'true' ou 'false', dependendo do tamanho da pilha.   
    */

    def isEmpty(): Boolean =
        size == 0 
    
    override def toString(): String =
        items.reverse.mkString("Stack(", ", ", ")")

object StackOne:
    def empty[T: ClassTag]: StackOne[T] =
        new StackOne[T](new Array[T](0), 0)
    
    def apply[T: ClassTag](items: T*): StackOne[T] =
        new StackOne[T](items.toArray, items.length)

end StackOne
