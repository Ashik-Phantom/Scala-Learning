package Chapter7

object imperativeStyleCode extends App{

    println(multiTable)

    def makeRowsq(r:Int) =
        for(c <- 1 to 10) yield{
        val prod = (r * c).toString
        val padd = " " * (4 - prod.length)
            padd + prod
    }

    def makeRow(r:Int) = makeRowsq(r).mkString

    def multiTable() = {
        val table =
            for(r <- 1 to 10)
                yield makeRow(r)
        table.mkString("\n")
    }



}
