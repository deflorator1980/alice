import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object Alice {
  def main(args: Array[String]) {
        val conf = new SparkConf().setAppName("My App")
        val sc = new SparkContext(conf)
        val input = sc.textFile("Alice.txt")
        val words = input.flatMap(line => line.split(" "))
        val start = System.nanoTime
        val count = words.filter(w => w.size > 12).count
        val stop = System.nanoTime
        println(count)
        println("Time diff = " + (stop - start))
  }
}
