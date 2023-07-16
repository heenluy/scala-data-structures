package dev.henriqueluiz.stack

import scala.reflect.ClassTag

class StackTest[T: ClassTag] private (
    private var elements: Array[T],
    private var size: Int
    ):
    
    def push(element: T): StackTest[T] =
        val arr = new Array[T](size + 1)

        for i <- 0 until elements.length do
            arr(i) = elements(i)
        
        arr(size) = element
        elements = arr
        size += 1
        this
    end push

    def pop(): Option[(T, StackTest[T])] =
        if size > 0 then
            val arr = new Array[T](size - 1)
            val popped = elements(size - 1)

            for i <- 0 until size - 1 do
                arr(i) = elements(i)

            elements = arr
            size -= 1
            Some((popped, this))
        
        else None
    end pop

    def top(): Option[T] =
        if size > 0 then Some(elements(size - 1)) else None
    end top

    def isEmpty(): Boolean =
        size == 0
    end isEmpty

    override def toString(): String =
        elements.reverse.mkString("Stack(", ", ", ")")

object StackTest:
    def empty[T: ClassTag]: StackTest[T] =
        new StackTest[T](new Array[T](0), 0)

    def apply[T: ClassTag](elements: T*): StackTest[T] =
        new StackTest[T](elements.toArray, elements.length)
end StackTest



        
