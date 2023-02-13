package Chapter3

object BasicTuples {
    def main(args: Array[String]): Unit = {

        initiateTuples1
    }

    def initiateTuples1(): Unit = {
        var t1 = (1, 2, 3, "Hello" , 8.0, "a")
        var t2 = Tuple3(1, "2", 3)
        var t3 = Tuple1(1)

        println(t1, t2, t3)
        println(t1._4)
    }
}
