package Chapter3

import scala.collection.mutable.Map //  to make map mutable
object BasicMap {
    def main(args : Array[String]): Unit = {
        val m1 = Map[Int, String]()
        m1 += (1->"a")
        m1 += (2->"b")
        println(m1)
        println(m1(1))
    }
}
