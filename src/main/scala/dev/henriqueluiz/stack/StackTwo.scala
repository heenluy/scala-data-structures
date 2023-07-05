package dev.henriqueluiz.stack

import scala.reflect.ClassTag

/*
*
* Os métodos são iguais, porém retirei o método `Array.copy`.
* 
*/

class StackTwo[T: ClassTag] private (
    private var items: Array[T],
    private var size: Int ):

    def push(item: T): StackTwo[T] =
        val newEls = new Array[T](size + 1)
        
        for i <- 0 until items.length do
            newEls(i) = items(i)

        newEls(size) = item
        items = newEls
        size += 1
        this

    def pop(): Option[(T, StackTwo[T])] =
        if size > 0 then
            val newEls = new Array[T](size - 1)
            val poppedEl = items(size - 1)

            for i <- 0 until size - 1 do
                newEls(i) = items(i)
            
            items = newEls
            size -= 1
            Some((poppedEl, this))
        else
            None


    def top(): Option[T] =
        if size > 0 then
            Some(items(size - 1))
        else
            None

    def isEmpty(): Boolean =
        size == 0

    override def toString(): String =
        items.reverse.mkString("Stack(", ", ", ")")

object StackTwo:
    def empty[T: ClassTag]: StackTwo[T] = 
        new StackTwo[T](new Array[T](0), 0)

