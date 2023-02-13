package Chapter6

class Rational(n:Int, d:Int) {
    require(d!=0)

    private[this] val g = gcd(n.abs,d.abs)
    val nu : Int = n/g
    val de : Int = d/g
    override def toString: String = "Rational: " + nu + "/" + de

    // auxiliary constructor
    def this(n : Int) = this(n, 1)

    def add(that : Rational) : Rational =
        new Rational((nu * that.de) + (de * that.nu) , (de * that.de))

    def lessThan(that : Rational) =
        this.nu * that.de < that.nu * this.de

    def greaterThan(that: Rational) =
        this.nu * that.de > that.nu * this.de

    def max(that : Rational) = if(this.greaterThan(that)) this else that

    private[this] def gcd(a : Int, b: Int): Int = if(b == 0) a else gcd(b, a%b)

    // defining operators
    def + (that:Rational) : Rational =
        new Rational((nu * that.de) + (de * that.nu) , (de * that.de))

    def + (that : Int) : Rational = new Rational(nu + that * de, de)

    def -(that: Rational): Rational =
        new Rational((nu * that.de) - (de * that.nu), (de * that.de))

    def -(that: Int): Rational = new Rational(nu - that * de, de)

    def /(that: Rational): Rational =
        new Rational(nu * that.de, de * that.de)

    def /(that: Int): Rational =
        new Rational(nu, de * that)
    def * (that:Rational) : Rational =
        new Rational(nu * that.nu , de * that.de)

    def *(that: Int): Rational =
        new Rational(nu * that, de)

}

object  Rational extends App{
    val ra1 = new Rational(1,2)
    val ra2 = new Rational(2,3)
    val ra3 = new Rational(5)

    println(ra1)
    println(ra2)
    println(ra3)
    println()
    println(ra1 add ra2)
    println(ra1 lessThan ra2)
    println(ra1 greaterThan ra2)
    println(ra1 max ra2)
    println()

    println(ra1 + ra2)
    println(ra1 + 2)

    println(ra1 * ra2)
    println(ra1 * 2)

    println(ra1 - ra2)
    println(ra1 - 2)

    println(ra1 / 2)
    println(ra1 / ra2)

}