package Chapter3

object BasicArray {
    def main(args: Array[String]): Unit = {
        initiateArray1
        initiateArray2
        initiateArray3
        initiateArray4
    }

    def initiateArray1(): Unit = {
        val greet = new Array[String](3)
        greet(0) = "Hello"
        greet(1) = ", "
        greet(2) = "world!\n"
        for (i <- 0 to 2)
            print(greet(i))
    }
    def initiateArray2(): Unit = {
        val greet = new Array[String](3)
        greet.update(0, "Hello")
        greet.update(1, ", ")
        greet.update(2, "world!\n")
        for (i <- 0.to(2))
            print(greet.apply(i))
    }

    def initiateArray3(): Unit = {
        val numNames = Array("zero", "one", "two")
        for (i <- 0.to(2))
            println(numNames.apply(i))
    }

    def initiateArray4(): Unit = {
        val numNames = Array.apply("zero", "one", "two")
        for (i <- 0.to(2))
            println(numNames.apply(i))
    }
}
