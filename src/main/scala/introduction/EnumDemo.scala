package introduction

/*
  scala 枚举
  枚举：scala不支持enum关键字，通过继承Enumeration类实现枚举
 */
object EnumDemo extends Enumeration {

  def main(args: Array[String]): Unit = {
    type EnumDemo = Value   //type关键字：类型的别名

    val FIRST,SECOND = Value
    val THIRD = Value(10)   //ID 为 10
    val FIVE = Value("abc") // Name 为 abc

    println(THIRD.id)
    println(FIVE.id)
    println(FIVE)
  }

}
