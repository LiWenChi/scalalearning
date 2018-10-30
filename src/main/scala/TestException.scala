import java.io.FileReader
import java.io.IOException
import java.io.FileNotFoundException

/* 异常的捕获 */
object TestException {
  def main(args: Array[String]) {
    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException =>{
        println("Missing file exception")
      }
      case ex: IOException => {
        println("IO Exception")
      }
    }
  }
}
