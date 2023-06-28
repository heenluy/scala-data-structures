package dev.henriqueluiz

@main def main() =
    val myList = SinglyLinkedList[String]()
    myList.add("Hello")
    myList.add("List")
    myList.add("From")
    myList.add("Scala 3")
    println(myList.toString())
