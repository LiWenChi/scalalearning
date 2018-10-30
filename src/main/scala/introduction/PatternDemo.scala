package introduction

/**
  * 模式匹配
  * 在我们学过的java中switch case 只能对数值进行匹配
  * Scala中
  *     1.对值进行匹配
  *     2.对配型进行匹配
  *     3.对Array和List进行匹配
  *     4.对case class进行配置
  *     5.对有值或没值进行匹配
  *
  *  匹配的时候，是从上往下匹配的，所以限制条件比较严格的放在前面
  */
object PatternDemo {
  def main(args: Array[String]): Unit = {

    //1.对值进行匹配
    def f1(num:Int)={

      num match{
        case 1 => {
          println("num is 1")
        }
        case 2 =>{
          println("num is 2")
        }
        case _ =>{
          print("num is other^")
        }
      }
    }

    //2.对配型进行匹配
    def f2(v :Any) = {
      v match {
        case v:Int =>{
          println("is Int type")
        }
        case v:String =>{
          println("is String type")
        }
        case _ =>{
          println("is Other type")
        }
      }
    }

    // 3.对Array和List进行匹配
    def f3(list:List[Int]):Int ={
      list match {
        case Nil => 0
        case head :: Nil => head
        case head :: tail => head + f3(tail)
      }
    }

    //4.对case class进行配置
    def f4(student: Student):Unit = {
      student match {
        case Student("zhangsan",12) => println(1)
        case Student(_,12) => println(2)
        case Student("zhangsan",_) => println(3)
        case Student(_,_) => println(4)
      }
    }

    //5.对有值或没值进行匹配
    val map = Map("a"->1,"b"->2,"c"->3)

    println(map.get("a"))
    println(map("a"))

    val option: Option[Int] = map.get("c")

    println(s"option:${option}")

    option match {
      case Some(value) => println(s"Some value is :${value}")
      case None => println("None")
    }


  }

}
