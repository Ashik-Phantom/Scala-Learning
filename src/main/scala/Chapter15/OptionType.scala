package Chapter15

object OptionType extends App{
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    var f = capitals get "France"
    var i = capitals get "India"

    var a,b,c = (1,2,3)  //Defining multiple variables with one assignment.


    println(f)
    println(i)

    println(show(f))
    println(show(i))

    def show(x: Option[String]) = x match {
        case Some(s) => s
        case None => "?"
    }

}
