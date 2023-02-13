package Chapter3

import scala.collection.mutable.Set //  to make set mutable
object BasicSets {
    def main(args: Array[String]): Unit = {

        initiateSets
    }

    def initiateSets(): Unit = {
        var s1 = Set(5,4,3,7,1,3,5,4,7,7,1)
        println(s1)

        s1+=10
        println(s1)
    }


}
