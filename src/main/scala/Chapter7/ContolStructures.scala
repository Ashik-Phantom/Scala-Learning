package Chapter7

object ContolStructures extends App{

    //println(IfExpression(args: Array[String]))
    //println(gcdloop(10,5))
    //println(gcdRecursion(10,5))
    //whileLoop
    //listFilesInDir
    forExpression
    println(forYeildEx1)
    println(forYeildEx2)
    nestedForLoop



    def IfExpression(args : Array[String]): String = {
        if (!args.isEmpty) args(0)
        else "default.txt"
    }

    def gcdloop(x : Int, y: Int): Int = {
        var a = x
        var b = y
        while(a!=0){
            val temp = a
            a = b%a
            b = temp
        }
        return b
    }

    def gcdRecursion(x: Long, y: Long): Long =
        if (y == 0) x else gcdRecursion(y, x % y)

    def whileLoop(): Unit = {
        var x = 0
        while (x < 10) {
            println(x)
            x += 1
        }

        var y = 0;
        do {
            println(y)
            y += 1
        } while (y < 10)
    }

    def listFilesInDir(): Unit = {
        val filesHere = (new java.io.File(".")).listFiles
        for (file <- filesHere)
            println(file)
    }

    def forExpression(): Unit = {
        for (i <- 1 to 4)
            println("Iteration " + i)

        for(i <- 1 until 4)
            println("Iteration " + i)

        for(i <- 1 to 10 if i % 2 == 0)
            println(i)
    }

    def forYeildEx1() = for {
        i <- 1 to 10
        if(i%2==0)
    } yield i

    def forYeildEx2() = for {
        i <- 1 to 10
        if (i % 2 == 0);
        if(i>5)
    } yield i

    def nestedForLoop(): Unit = {
        var arr = Array((1,2,3),(4,5,6),(7,8,9))
        for{
            i <- 1 to 2
            if i > 1
            j <- 1 to 5
            if j > 3
        } println(i, j)

        for (i <- 1 to 2; j <- 1 to 2) {
            println(i, j)
        }
    }


}
