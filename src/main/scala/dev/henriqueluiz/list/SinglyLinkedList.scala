package dev.henriqueluiz.list

/*
    LISTA ENCADEADA (SINGLY)
    - - - - - - - - 

    * Valor do elemento (ou dado):
        - Cada nó em uma lista encadeada armazena um valor de elemento específico.
    
    * Ponteiro para o próximo nó:
        - Além do valor do elemento, cada nó contém um ponteiro que aponta para o próximo nó na sequência.
    
    * Nó final (ou nó sentinela):
        - O último nó na lista encadeada tem um ponteiro especial que geralmente aponta para um valor nulo (null), indicando o final da lista.
        - Esse nó final é chamado de "nó sentinela" e é útil para sinalizar o término da lista durante as operações de iteração. 
*/

class SinglyLinkedList[T]:
    class Node(var data: T, var next: Option[Node] = None)

    private var _head: Option[Node] = None

    /*
        * Método que insere valor.
    */

    def add(data: T): Unit =
        var node: Node = Node(data)
        
        if _head.isEmpty then
            _head = Some(node)
            // Ou seja, agora a minha lista contém um elemento.
        else
            var current = _head
            while
                current.get.next.isDefined
            do
                current = current.get.next
            // Agora o nó atual é IGUAL ao seu próximo
            // E o próximo nó está como NULL, agora.
            // - - - - - - - - - - - - - - - - - 
            current.get.next = Some(node)
            // O próximo nó passa a ser o NOVO NÓ


    override def toString(): String =
        var currentNode = _head
        var elements: List[T] = Nil

        while
            currentNode.isDefined
        do
            elements = elements:+ currentNode.get.data
            currentNode = currentNode.get.next
        
        s"${elements.toString()}"
/*
    MÉTODOS PRINCIPAIS
    - - - - - - - - -
    1. Inserir valor no início
    2. Inserir valor no fim
    3. Inserir valor em uma posição específica
    4. Remover valor no início
    5. Remover valor no fim
    6. Remover valor em uma posição específica
    7. Buscar valor específico
    8. Verificar tamanho da lista
    9. Verificar se a lista está vazia
*/
