package Chapter5

object OperatorsAndMethods extends App {
    val sum1 = 1+ 2
    // also
    val sum2 = 1.+(2)

    println(sum1,sum2)

    val s = "Hello world"
    println(s indexOf 'H' )

    println(s.indexOf('o',5))   // s.indexOf('value',"where to start looking")
    // in this case second 'o' cuz first o index is lesser than 5

    var d1 = -2
    // or
    var d2 = (2).unary_-  // unary of negative

    println(s.toLowerCase)
    println(s.toUpperCase)

    // arithmetic
    println(1+3)
    println(5-2)
    println('b' - 'a')
    println(2L * 3L)
    println(11 / 4)
    println( 11 % 4)
    println(1 + -3)

    println()
    // logical
    println(1>2)
    println(1>2)
    println(1==1)
    println('a'>'A')
    println(!true)
    println(true)

    println()
    println(true && true)
    println(false && true)
    println(false && false)
    println(true || false)

    println()

    //bitwise
    println(1 & 2) //0  and
    println(1 | 2) //3  or
    println(1 ^ 3) // 2  xor
    println(~1)  // -2 not

    println(-1 >> 31)  //-1 shift right
    println(-1 >>> 31) //1 unsigned shift right
    println(1<<2)  // 4 shift left


    println(0 max 5)
    println(0 min 5)
    println(0 to 10)
    println("helloworld".capitalize)
    println(-2.7.abs)
    println(-2.9.round)
    println("helloworld" drop 2)

}
