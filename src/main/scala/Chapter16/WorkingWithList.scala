package Chapter16

object WorkingWithList extends App{

    val nums: List[Int] = List(1, 2, 3, 4)
    val fruit: List[String] = List("apples", "oranges", "pears")
    val diag3: List[List[Int]] =
        List(
            List(1, 0, 0),
            List(0, 1, 0),
            List(0, 0, 1)
        )
    val empty: List[Nothing] = List()

    listOperations
    //constructList2
    println()
    mergeList
    println()
    println(rev(nums))


    def listOperations(): Unit = {
        println(diag3)
        println(fruit.tail.tail.head)
        println(insert(10,nums))
        println(nums.last)
        println(nums.head)
        println(nums.tail)
        println(nums.init)
        println(nums take 2)
        println(nums drop 2)
        println(nums splitAt 2)
        println(nums apply 2)
        println(nums.indices)
        println(nums zip List(1,2,3,4))
        println(nums.toString())
        println(nums.mkString(","))
        println(nums.mkString("|",",","|"))
        println(nums map (_ + 1))
        println(fruit map (_.length))
        println(fruit map (_.toList.reverse.mkString))
        println(fruit flatMap (_.toList))
        var sum =0
        nums foreach (sum+=_)
        println(sum)
        println(nums filter (_ % 2 == 0))
        println(nums find (_ % 2 == 0))




    }
    def constructList2(): Unit = {
        val fruit = "apples" :: "oranges" :: "pears" :: Nil
        val nums = 1 :: 2 :: 3 :: 4 :: Nil
        val diag3 = (1 :: 0 :: 0 :: Nil) ::
            (0 :: 1 :: 0 :: Nil) ::
            (0 :: 0 :: 1 :: Nil) :: Nil
        val empty = Nil

        println(diag3)
    }

    def isort(xs: List[Int]): List[Int] =
        if (xs.isEmpty) Nil
        else insert(xs.head, isort(xs.tail))

    def insert(x: Int, xs: List[Int]): List[Int] =
        if (xs.isEmpty || x <= xs.head) x :: xs
        else xs.head :: insert(x, xs.tail)

    def mergeList(): Unit = {
        var a = List(1,2)
        var b = List(3,4)
        println(a ::: b)
        println(1 :: b)
    }

    def rev[T](xs: List[T]): List[T] = xs match {
        case List() => xs
        case x :: xs1 => rev(xs1) ::: List(x)
    }


}
