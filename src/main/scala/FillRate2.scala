package Exercise

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Column, DataFrame, Row, SparkSession}
import org.apache.spark.sql.functions.{col, count, format_number, length, lower, trim, when}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

import scala.collection.mutable.Seq

object FillRate2 extends App {
    val sparkConf = new SparkConf().setMaster("local[2]").set("spark.executor.memory", "1g")
    val spark = SparkSession.builder().config(sparkConf).appName("FillRateApp").getOrCreate()
    println("Spark Session Created - " + spark)

    val fileName1 = "/Users/a126551/Downloads/employees.csv"
    val fileName2 = "/Users/a126551/Documents/SampleData/bryantahb-crime-in-atlanta-2009-2017/data/atlcrime.csv"
    val df = spark.read.option("header", value = true).csv(fileName2)
    val totCount = df.count()

    val statsSchema = StructType(Seq(
        StructField("colName", StringType, nullable = false),
        StructField("cnt", StringType, nullable = false),
        StructField("distCnt", StringType, nullable = false)
    ))

    def findNonNullCount(columns: Array[String]): Array[Column] = {
        columns.map(c => {
            count(when(col(c).isNotNull, c)).alias(c)
        })
    }

//    def findNonNullPercValue(columns: Array[String]): Array[Column] = {
//        columns.map(c => {
//            format_number((col(c) / totCount) * 100, 2).alias(c)
//        })
//    }

    def findDistinctCount(df: DataFrame): DataFrame = {
        val distList = df.columns.foldLeft(List[Row]()) {
            (rowList, colName) => {
                // filtering not null & non empty values
                val tempDf = df.filter(length(trim(col(colName))) > 0 && col(colName).isNotNull && lower(trim(col(colName))) != "null")
                // pulling count and dist count
                val cnt = tempDf.select(trim(col(colName))).count().toString()
                val distCnt = tempDf.select(trim(col(colName))).distinct().count().toString()

                // collecting stats into a list
                rowList :+ Row(colName, cnt, distCnt)
            }
        }
        //converting stats list to dataframe
        val rdd = spark.sparkContext.parallelize(distList)
        val statsDf = spark.createDataFrame(rdd, statsSchema)

        statsDf
    }

    val notNullVal = df.select(findNonNullCount(df.columns):_*)
    notNullVal.show()
//    val perVal = notNullVal.select(findNonNullPercValue(notNullVal.columns):_*)
    //val distVal = findDistinctCount(df)

//    val op = notNullVal.union(perVal)
//    notNullVal.show()
//    //distVal.show()
//    //perVal.show()
//    op.show()
}
