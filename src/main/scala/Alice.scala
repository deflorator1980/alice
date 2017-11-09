import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object StandAlone {
  def main(args: Array[String]) {
        val conf = new SparkConf().setAppName("My App");
        val sc = new SparkContext(conf);
        val input = sc.textFile("Alice.txt")
//        val input = sc.textFile("rnd.txt")
        val hz = input.flatMap(line => line.split(" "))
        val start = System.nanoTime
        val x = hz.filter(w => w.size > 12).count
        val stop = System.nanoTime
        println(x)
        println("Time diff = " + (stop - start))
  }
}
