package Chapter3

object BasicList {
    def main(args: Array[String]): Unit = {

        initiateList1
        initiateList2
        listConcatination
        listFunctions

    }

    def initiateList1(): Unit = {
        val emptyList = Nil
        val emptyList2 = List()  // empty list

        val li = List(1, 2, 3)
        for (i <- li) {
            println(i)
        }
    }

    def initiateList2(): Unit = {
        val li = 1 :: 2 :: 3 :: 4 :: Nil  // creates a list of 1,2,3,4
        for (i <- li) {
            println(i)
        }
    }

    def listConcatination(): Unit = {
        var l1 = List(1,2)
        var l2 = List(3,4)
        var l3 = List(1,4)

        val l12 = l1 ::: l2     // l1 + l2
        val l23 = l2 ::: l3     // l2 + l3
        val L2 = 1 :: l2        // 1 + l2

        println(l12, l23, L2)
    }

    def listFunctions(): Unit = {
        var l1 = List("Cool", "tools", "rule", "book", "is", "a")

        println(l1)
        println(l1(4))  // Returns the element at index 4

        println(l1.count(i => i.length > 3)) // counts no of string of length > 3

        println(l1.drop(2))  // returns list without its left most 2 element
        println(l1.dropRight(2)) // returns list without its right most 2 element

        println(l1.exists(i => i == "tools")) // checks if "tools" exists returns t or f

        println(l1.filter(i => i.length <= 2))   // filters the list and return

        println(l1.forall(i => i == "a"))
        println(l1.forall(i => i.endsWith("e")))

        println(l1.foreach(i => print(i + " ")))
        println(l1.foreach(print))

        println(l1.head)
        println(l1.last)
        println(l1.tail)
        println(l1.init)  // everything except last
        println(l1.length)
        println(l1.empty.isEmpty)
        println(l1.isEmpty)

        println(l1.map(i => i + "!"))

        println(l1.mkString)
        println(l1.mkString(","))
        println(l1.mkString("|", "-" , "|"))

        println(l1.sorted)
        println(l1.sortWith((s, t) =>
            s.charAt(0).toLower < t.charAt(0).toLower))

    }
}
