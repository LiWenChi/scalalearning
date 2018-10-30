package introduction

import java.io.{FileNotFoundException, FileReader, IOException}

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
