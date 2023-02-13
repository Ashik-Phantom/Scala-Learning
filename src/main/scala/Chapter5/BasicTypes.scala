package Chapter5

object BasicTypes extends App{

    val a : Byte = 8
    val b : Short = 16
    val c : Int = 32
    val d : Long = 64
    val e : Char = 'a'
    val f : String = "sequence of char"
    val g : Float = 10.0f
    val h : Double = 10.0
    val i : Boolean = true

    val hex = 0x5
    val hex2 = 0x00FF
    val hex3 = 0xcafebabe
    // hex if starts with 0x or 0X (0-9 and a-f)

    val lo = 10L
    // ends with l or L is Long

    val fl = 10.0f
    // ends with f is float else double  or with D

    val ch = 'A'
    //or
    val ch1 = '\u0041'  // A
    println(ch1)

    val backslash = '\\'
    val escape = "\\\"\'"

    println(backslash, escape)

    println(
        """hello
          |world
          |""".stripMargin)

}
