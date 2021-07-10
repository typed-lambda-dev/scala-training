package spark

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object SparkIntro {
  //Yarn / Mesos manage clusters

  def main(args: Array[String]): Unit = {
    lazy val spark: SparkSession = SparkSession.builder
      .master("jdbc:url")
      .appName("spark-training")
      .getOrCreate
    import spark.implicits._
    spark.sparkContext.setLogLevel("OFF")
    val myRange: DataFrame = spark.range(1000).toDF("number") // table with column number
    //Datasets internally -> Dataframes
//    myRange.show(50)
    // transformation and action
    val where = myRange.where("number % 2 = 0")
//    println(where)
//    where.show()

//    myRange.printSchema()
    //    myRange.show(50)
//    println(myRange.where("number % 2 = 0").collectAsList())
    val flightData2015 = spark.read.option("inferSchema", "true")
      .option("header", "true")
      .csv("data/flight-data/csv/2015-summary.csv")
//    flightData2015.printSchema()
//    println(flightData2015.count())
//    println(flightData2015.take(3).mkString(",")) // select * from flight_data limit 3;
//    println(flightData2015.sort("count").explain())
    flightData2015.createOrReplaceTempView("flight_data_2015") // select * from flight_data_2015
//    println(flightData2015.columns.mkString(", "))
//    flightData2015.show(20)
//
//
    val sqlWay = spark.sql("""SELECT DEST_COUNTRY_NAME, count(1) FROM flight_data_2015 GROUP BY DEST_COUNTRY_NAME;""")
//
//    sqlWay.explain
//    sqlWay.show()
//
//    flightData2015.select("DEST_COUNTRY_NAME").show(2)
//
//    val dataFrameWay = flightData2015
//      .groupBy('DEST_COUNTRY_NAME)
//      .count()
//
//    dataFrameWay.explain()
//    dataFrameWay.show()
//
//    flightData2015.select(max("count")).take(1)
//
    val maxSql = spark.sql(
      """
                  SELECT DEST_COUNTRY_NAME, sum(count) as destination_total
                  FROM flight_data_2015
                  GROUP BY DEST_COUNTRY_NAME
                  ORDER BY sum(count) DESC
                """)

    println(maxSql.collectAsList())
//
//    val maxDFSql = flightData2015.groupBy("DEST_COUNTRY_NAME")
//      .sum("count")
//      .withColumnRenamed("sum(count)", "destination_total")
//      .sort(desc("destination_total"))
//      .limit(5)
//
//    maxDFSql.col("DEST_COUNTRY_NAME")
//    maxDFSql.show()
  }

}
