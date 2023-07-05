package dev.henriqueluiz.stack



class StackZero[A] private (private var elements: List[A]):
    
    /*
        * Adiciona um no item T a lista de elementos.
        * Cria uma Stack passando essa lista como argumento.
    */
    def push(item: A): StackZero[A] = 
        elements = item :: elements
        this

    /*
        * Faz a operação 'matching' nos elementos da pilha.
        * Caso esteja vazia, retorna null (None)
        * Caso tenha algo, remove o último da pilha
        * 'head' é o primeiro item, 'tail' são todos os itens sem o primeiro.
    */
    def pop(): Option[(A, StackZero[A])] = elements match
        case Nil => None
        case head :: tail =>
            elements = elements.drop(1)
            Some((head, this))

    /*
        * Pega o elemento que está no topo.
    */
    def top(): Option[A] = elements.headOption

    /*
        * Verifica se está vazia.
    */
    def isEmpty: Boolean = elements.isEmpty

    /*
        * Retorna o tamanho da Pilha.
    */
    def size: Int = elements.length

    override def toString(): String =
        elements.mkString("Stack(", ", ", ")")

object StackZero:
    /*
        * Com esse companion object eu posso criar uma instância vazia.
        * É parecido como um método estático que tem acesso aos campos da classe.
    */
    def empty[A]: StackZero[A] = new StackZero[A](Nil)

    /*
        * Esse pode criar uma pilha com vários elementos.
        * Exemplo: Stack.apply[Int](1, 2, 3)
    */
    def apply[A](items: A*) = new StackZero[A](items.toList)
end StackZero