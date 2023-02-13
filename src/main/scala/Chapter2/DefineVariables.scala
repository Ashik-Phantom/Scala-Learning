package Chapter2

object DefineVariables {
    def main(args: Array[String]) {
        val msg = "Hello, world!" // immutable
        var greet = "Hello, world!" //mutable
        greet = "Hello"
        // msg = "Hello" // error

        var num: Int = 10
        var flo: Float = 10.0f
        var dou: Double = 10.0
        var str: String = "Example string"
        var byt: Byte = 1

        println("Hello")
        println(num, flo, dou, str, byt)
    }
}
