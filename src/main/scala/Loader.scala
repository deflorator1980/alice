import scala.io.Source
import sys.process._
import java.net.URL
import java.io.File
object Loader  extends  App {
//  def f(x: Int) = x + 3
//  def g(f: Int ⇒ Int, x: Int) = f(x) * f(x)
//  println(g(f, 7))

//  val html = Source.fromURL("https://s3.eu-central-1.amazonaws.com/webdefl/Alice.txt")
//  val s = html.mkString
//  println(s)

  new URL("https://s3.eu-central-1.amazonaws.com/webdefl/Alice.txt") #> new File("Output.txt") !!
}
