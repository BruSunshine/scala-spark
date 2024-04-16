package sparkSession

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.{SparkSession, Dataset, Row, DataFrame}
//import org.apache.spark.sql.types._

object Session:

  val conf = new SparkConf().setAppName("sparkApp").setMaster("local[*]")

  lazy val spark: SparkSession =
    try
      SparkSession
        .builder()
        .config(conf)
        .config("spark.executor.memory", "1g")
        .config("spark.log.level", "WARN")
        .getOrCreate()
    catch
      case e: Exception =>
        val trace = e.printStackTrace()
        throw e

  // stopSparkSession() not currently in use
  def stopSparkSession(): Unit =
    spark.stop()

end Session