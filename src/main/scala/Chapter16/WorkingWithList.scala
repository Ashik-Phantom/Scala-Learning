package Chapter16

object WorkingWithList extends App{


    constructLists1
    //constructList2
    def constructLists1(): Unit = {
        val fruit: List[String] = List("apples", "oranges", "pears")
        val nums: List[Int] = List(1, 2, 3, 4)
        val diag3: List[List[Int]] =
            List(
                List(1, 0, 0),
                List(0, 1, 0),
                List(0, 0, 1)
            )
        val empty: List[Nothing] = List()

        println(diag3)
        println(fruit.tail.tail.head)
        println(insert(10,nums))

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
}
