lazy val spark = org.apache.spark.sql.SparkSession.builder
  .master("local")
  .appName("spark-training")
  .getOrCreate
//import spark.implicits._
