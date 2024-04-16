package myexoweek1

import java.nio.file.{Paths, Files}
import munit.FunSuite
import sparkSession.Session.spark as spk
import org.apache.spark.sql.SparkSession

class MyExoWeek1Suite extends munit.FunSuite:

  var spark: SparkSession = _

  override def beforeAll(): Unit =
    super.beforeAll()
    spark = spk

  override def afterAll(): Unit =
    if (spark != null) then spark.stop() else super.afterAll()

  test("my first test") {
    val textPath: String = "src/main/resources/Week1-3_latency.txt"
    if (Files.exists(Paths.get(textPath)))
      println(s"File exists at path: $textPath")
      val rdd = spark.sparkContext.textFile(textPath)
      val wordCount: Long = rdd.filter(t => t == " ").count()
      println(s"File contains: $wordCount words")
    else
      println(s"File does not exist at path: $textPath")
  }
