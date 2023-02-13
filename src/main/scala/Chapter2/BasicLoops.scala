package Chapter2

object BasicLoops {
    def main(args : Array[String]): Unit = {
        var i = 0
        var str = "Hello world !"
        while (i < str.length) {
            print(str(i))
            i += 1
        }

        for( i <- str){
            print(i)
        }
    }
}
