package Chapter4

class ClassesExample {
    private var sum = 0

    def add(a : Int): Unit = {
        sum += a
    }

    def checkSum(): Unit = {
        println(sum)
    }
}

object ClassesExample{
    def main(Args : Array[String]): Unit = {
        val obj1 = new ClassesExample
        val obj2 = new ClassesExample

        obj1.add(20)

        obj1.checkSum()
        obj2.checkSum()
    }
}
