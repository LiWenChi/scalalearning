package introduction

/**
  * Scala常用方法大全
  */
object p5 {

  def main(args: Array[String]) {
    //flatten方法，可以把嵌套的结构展开.
    println("=================flatten方法==================")
    val list1 = List(1, 2)
    val list2 = List(3, 4)
    val list3= List(list1,list2)
    println(list3.flatten)

    // flatMap结合了map和flatten的功能。接收一个可以处理嵌套列表的函数，然后把返回结果连接起来。
    println("=================flatten方法==================")
    println(list3.flatMap(x => x.map(x => x*2)))

    //filter  滤除掉使函数返回false的元素
    println("=================filter方法==================")
    def isEven(i: Int):Boolean = i % 2 == 0
    val list4 = List(1,2,3,4)
    val list5 = list4.filter(isEven _)
    println(list5)

    // zip方法将两个集合结合在一起
    println("=================zip方法==================")
    val list6 = List('a','b','c')
    println(list6.zip(List(1,2,3)))

    //zipWithIndex 将元素和下标结合在一起
    println("=================zipWithIndex==================")
    println(List(2,3,4,5).zipWithIndex)

    //foreach和map相似，只不过它没有返回值，foreach只要是为了对参数进行作用。
    println("=================foreach==================")
    list3.foreach(x => println(x))

    //mkString 方法,scala通过mkString方法把一个集合转化为一个字符串
    println("=================mkString==================")
    val a = Array("apple", "banana", "cherry")
    println(a.mkString(","))
    println(a.mkString("[", ", ", "]"))
  }
}
