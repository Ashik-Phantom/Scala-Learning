package Chapter15

abstract class Expr1
case class Var1(name : String) extends Expr1
case class Num1(num : Double) extends Expr1
case class UnOp1(operator : String, arg : Expr1) extends Expr1
case class BinOp1(operator : String, arg1 : Expr1, arg2 : Expr1) extends Expr1


object ArithExp extends App{
    val v1 = Var1("x")
    val n1 = Num1(10.0)
    val bp1 = BinOp1("+", n1, v1)
    val bp2 = BinOp1("*", Num1(10), Num1(1))
    val up1 = UnOp1("-", UnOp1("-", Var1("x")))

    println(bp1)

    println(v1.name)
    println(n1.num)
    println(bp1.operator)

    println()

    println(simplifyTop(v1))
    println(simplifyTop(n1))
    println(simplifyTop(bp1))
    println(simplifyTop(bp2))
    println(simplifyTop(up1))

    println()

    println(displayExpression(bp1))
    println(displayExpression(up1))
    println(displayExpression(v1))
    println(displayExpression(bp2))


    def simplifyTop(expr: Expr1): Expr1 = expr match {
        case UnOp1("-", UnOp1("-", e)) => e // Double negation
        case BinOp1("+", e, Num1(0)) => e // Adding zero
        case BinOp1("*", e, Num1(1)) => e // Multiplying by one
        case _ => expr
    }

    def displayExpression(expr : Expr1)=
        expr match {
            case BinOp1(op, left, right) => expr + "is a binary operation"
            case UnOp1(op, args) => expr + "is a unary operator"
            case BinOp1(_,_,_) => "binary operator wth wildcards"
            case _ => "Un known"
        }

    def describe(e: Expr1): String = (e: @unchecked) match {
        case Num1(_) => "a number"
        case Var1(_) => "a variable"
        case _ => throw new RuntimeException
    }


}
