package Chapter2

object DefineFunction {
    def main(args: Array[String]): Unit = {
        println(max1(10,20))
        println(max2(10,20))
        greet()
    }

    def max1(x:Int, y:Int): Int = {
        if(x>y) x else y
    }
    def max2(x: Int, y: Int) = if (x > y) x else y

    def greet() = println("Hello, world!")

}
