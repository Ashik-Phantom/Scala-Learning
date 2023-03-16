package FillRate

import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{col, collect_set, count, countDistinct, format_number}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Column, DataFrame, Row, SparkSession}

import java.text.NumberFormat
import scala.collection.mutable.ListBuffer

object FillRate_new extends App {

    val sparkConf = new SparkConf().setMaster("local[2]").set("spark.executor.memory", "1g")
    val spark = SparkSession.builder().config(sparkConf).appName("FillRateApp").getOrCreate()
    println("Spark Session Created - " + spark)

    val fileName1 = "/Users/a126551/Downloads/employees.csv"
    val fileName2 = "/Users/a126551/Documents/SampleData/bryantahb-crime-in-atlanta-2009-2017/data/atlcrime.csv"
    val df = spark.read.option("header", value = true).csv(fileName2)
    df.createOrReplaceTempView("myTable")
    val totCount = df.count()

    //getNonNullCountList(df)
    getNonNullDistinctCount(df)
    getNonNullDistinctCounttoDF(df)
//    val countDf = fillRateCount(df)
//    countDf.show()
//    fillRateDistCount(df)
//    val percDf = fillRateCountPercent(df)

//    val op = countDf.union(percDf)
//    op.show()

    // rishi's code
    def fillRateCount(df : DataFrame): DataFrame ={
        val colArray = df.columns

        val sb : StringBuilder = StringBuilder.newBuilder

        sb.append("select ")

        colArray.foreach(x => {
            sb.append("sum(case when coalesce(trim(string(" + x + ")),'') <> '' then 1 else 0 end) as " + x + ",")
        })

        sb.deleteCharAt(sb.length - 1)
        sb.append(" from myTable")

        println(sb.toString())

        val result = spark.sql(sb.toString())

        //result.show()
        val fillratecount =  result.collect.map(_.asInstanceOf[Long])
        fillratecount.foreach(println)

        result
    }

    def fillRateCountPercent(df:DataFrame): DataFrame = {
        // getting fill rate count before finding percentage
        val nonNullCount = fillRateCount(df)

        val perVal = nonNullCount.select(findNonNullPercValue(nonNullCount.columns):_*)

        def findNonNullPercValue(columns: Array[String]): Array[Column] = {
            columns.map(c => {
                format_number((col(c) / totCount) * 100, 4).alias(c)
            })
        }
        //perVal.show()
        perVal
    }

    def getNonNullCountList(df : DataFrame): List[Long] = {
        val columnName = df.columns

        // generates expression of Column such as
        //        count(lat) AS `lat_count`
        //        count(long) AS `long_count`
        //        count(location_2) AS `location_2_count`
        // @returns Array[Column]
        val countExpr = columnName.map(c => count(col(c)).alias(s"${c}_count"))  // array of columns
        val nonNullCount = df.agg(countExpr.head, countExpr.tail:_*)  // gets output as DF
        //nonNullCount.show
        val op = nonNullCount.head.toSeq.map(_.asInstanceOf[Long]).toList
        //op.foreach(println)
        op
    }

    def getNonNullDistinctCount(df : DataFrame): List[Long] = {
        val columnName = df.columns
        val distinctNonNull = columnName.map(c => {
            // generates expression such as
            //  collect_set(neighborhood) AS `neighborhood_distinct_non_empty`
            //  collect_set(long) AS `long_distinct_non_empty`
            //  collect_set(location_2) AS `location_2_distinct_non_empty`
            //@returns Column
            val expr = collect_set(col(c)).as(s"${c}_distinct_non_empty")
            //println(expr)
            df.select(expr).head.getAs[Seq[Any]](0).count(_ != null)
        })
        val distinctCountList = distinctNonNull.toList.map(_.asInstanceOf[Long])

        distinctCountList.foreach(println)
        distinctCountList
    }

    def getNonNullDistinctCounttoDF(df : DataFrame): DataFrame = {
        val columnName = df.columns
        val distinctNonNull = columnName.map(c => {
            // generates expression such as
            //  collect_set(neighborhood) AS `neighborhood_distinct_non_empty`
            //  collect_set(long) AS `long_distinct_non_empty`
            //  collect_set(location_2) AS `location_2_distinct_non_empty`
            //@returns Column
            val expr = collect_set(col(c)).as(s"${c}_distinct_non_empty")
            df.select(expr).head.getAs[Seq[Any]](0).count(_ != null)
        })
        val rdd = spark.sparkContext.parallelize(Seq(Row.fromSeq(distinctNonNull)))
        val schema = StructType(columnName.map(i => StructField(i, IntegerType, nullable=false)))
        val opDf = spark.createDataFrame(rdd, schema)
        opDf.show
        opDf
    }
}
