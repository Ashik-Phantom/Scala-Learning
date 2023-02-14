package Chapter7

object ExceptionHandling extends App{

    throwsExample
    tryCatchEx
    tryCatchFinallyEx

 def throwsExample(): Unit = {
     var n = 10
     // var n = 11
     val half =
         if (n % 2 == 0)
             n / 2
         else
             throw new RuntimeException("n must be even")

     println(half)
 }

    def tryCatchEx(): Unit = {
        try {
            var a = 1 / 0
            println(a)
        }catch{
            case ex : Exception => println("Exception")
        }
    }

    def tryCatchFinallyEx(): Unit = {
        try {
            var a = 1 / 0
            println(a)
        } catch {
            case ex: Exception => println("Exception")
        }
        finally {
            println("Finally executed")
        }
    }

    def matchExpression(): Unit = {
        val age = 20
        age match {
            case 20 => {
                println(age + " is 20")
            }
            case 10 => println(age + " is 10")
            case _ => println(age + " too high")
        }
        val result = age match {
            case 20 => {
                age + " is 20"
            }
            case 10 => age
            case _ => "default"
        }

        println("Result " + result)

        val i = 4
        i match {
            case 1 | 2 | 3 | 4 | 5 => println("lesser than 6")
        }
    }
}
