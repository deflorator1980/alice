import org.apache.spark
import org.apache.spark.{SparkConf, SparkContext}

object Alice {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("My App")
//    conf.set("spark.hadoop.fs.s3a.endpoint", "s3.us-east-2.amazonaws.com")
//    conf.set("spark.hadoop.fs.s3a.access.key", "AKIAI7OFWZJSIDEIHDJA")
//    conf.set("spark.hadoop.fs.s3a.secret.key", "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")
    val sc = new SparkContext(conf)
    sc.hadoopConfiguration.set("spark.hadoop.fs.s3a.endpoint", "s3.us-east-2.amazonaws.com")
    sc.hadoopConfiguration.set("spark.hadoop.fs.s3a.access.key", "AKIAI7OFWZJSIDEIHDJA")
    sc.hadoopConfiguration.set("spark.hadoop.fs.s3a.secret.key", "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")
    //        val input = sc.textFile("Alice.txt")

    val input = sc.textFile("s3a://wave15/Alice.txt")
    val words = input.flatMap(line => line.split(" "))
    val start = System.nanoTime
    val count = words.filter(w => w.size > 12).count
    val stop = System.nanoTime
    println(count)
    println("Time diff = " + (stop - start))
  }
}
