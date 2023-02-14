package Chapter8

object functionsEx extends App {

    private val someNumbers = List(-11, -10, -5, 0, 5, 10)
    firstClassFunction
    println()
    placeHolderSyntax
    println()
    partialFunction
    println()
    println(sum(1,2,3))
    println()
    repeatedParameter

    def firstClassFunction() {
        someNumbers.foreach((x: Int) => print(x + " "))
        println()
        println(someNumbers.filter((x: Int) => x > 0)) // or
        println(someNumbers.filter(x => x > 0))
    }

    def placeHolderSyntax(): Unit = {
        // val f = _ + _ ------------error
        val f = (_:Int) + (_:Int)
        println(f(1,2))
    }

    def partialFunction(): Unit = {
        someNumbers.foreach(print _)

        val sum = (a: Int, b: Int, c: Int) => a + b + c // fully applied function
        val parSum = sum(12, 10, _: Int) // apply the function partially
        val b = sum(1,_:Int,2)
        println()
        println(sum(12, 10, 20))
        println(parSum(30))
        println(b(10))
    }

    def sum(a: Int, b: Int, c: Int) = a + b + c

    def repeatedParameter(): Unit = {
        def echo(args : String*) = args.foreach(println)

        echo("hello", "World",  "sample", "string")
        echo(Array("What's", "up", "doc?") : _*)
        /* This notation tells the compiler to pass each element of arr
        as its own argument to echo,
        rather than all of it as a single argument.*/
    }

}
