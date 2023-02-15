package Chapter15

sealed abstract class Expr
case class Var(name : String) extends Expr
case class Number(num : Double) extends Expr

case class UnOp( operator : String, args : Expr) extends Expr
case class BinOp(operator : String, left: Expr, right : Expr) extends Expr

class ExprFormatter {
    private val opGroups = Array(
        Set("|", "||"),
        Set("&", "&&"),
        Set("ˆ"),
        Set("==", "!="),
        Set("<", "<=", ">", ">="),
        Set("+", "-"),
        Set("*", "%")
    )

    val precedence: Map[String, Int] = {
        val assocs =
            for {
                i <- 0 until opGroups.length
                op <- opGroups(i)
            } yield op -> i

        println(assocs)
        Map() ++ assocs
    }
}
    object Express extends App{

    val f = new ExprFormatter
    println(f.precedence)

}
