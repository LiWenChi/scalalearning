/**
  * scala变量申明
  * 如果在没有指明数据类型的情况下声明变量或常量必须要给出其初始值，否则将会报错
  */
object VarDeclaration {
  val name1: String = "string"
  var name2: String = "scala"
  val num1: Int = 12
  val num2: Int = 17

  def main(args: Array[String]): Unit = {
    //表达式
    val test1: Int = {
      println("aaa")
      val r = {
        println("bbb")
        100
      }
      r
    }

    println ("test1="+test1)

    var name = "aa"

    println("name:" + name)

    println(s"name , ${name}")

    //多行字符串用三个双引号表示分隔符，格式为：""" ..."""
    var str =
      """
        |a
        |b
        |c
        |d
      """.stripMargin
    println(str)


    val num = 6

    val res = if(num<5){
      println("小于五")
      "a"
    } else if(num > 10){
      println("大于10")
      "b"
    } else {
      println("5 和 10 之间")
      "c"
    }

    val res1 = if(num > 5 ) 0 else 1
    println(s"res1:${res1}")



  }

}
