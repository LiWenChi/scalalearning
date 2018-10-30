package introduction

import scala.util.control.Breaks

/**
  * Scala入门：判断，循环，模拟java break， continue 9*9 乘法表
  */
object p1 {
  def main(args: Array[String]): Unit = {
    //简易数组
    val arr: Range.Inclusive = 0 to 10 //是一个闭区间
    val arr1: Range = 0.until(20) // 是一个半闭半开区间
    val arr2: Range.Inclusive = 0 to(10,2)  // 到10结束，步长为2
    val arr3: Range = Range(0,10) //等价于until


    println(arr)
    println(s"arr1:${arr1}")
    println(s"arr2:${arr2}")
    println(s"arr3:${arr3}")


    val len = arr.length
    println(len)

    var i = 0
    //break操作
    val loop = Breaks
    loop.breakable(
      while (i < len){
        println(s"第${i}个元素是${arr(i)}")
        if(i == 3){
          loop.break()  // 相当于java中的break
        }
        i += 1
      }
    )

    val arrays: Array[Int] = (2 to 10).toArray
    // for循环的守护模式
    for(array <- arrays if array < 5){
      println(array)
    }

    // 用for循环实现break 和 continue
    println("模拟break循环")
    for(array <- arrays if array <= 5){
      println(array)
    }

    println("模拟continue循环")
    for(array <- arrays if array != 5){
      println(array)
    }

    println("9*9乘法表")
    for(i <- 1 to 10){
      for(j <- 1 to i){
        println(s"$j * $i = ${i*j}")
      }
      println()
    }

    //
    println("两个for循环写在一起，代码块可以用一个{}")
    for(i <- 1 to 9;j <- 1 to i){
      println(s"${j} * ${i} = ${i*j}")
      if(j == i) println()
    }

    for{
      i <- 1 to 9 //第一层for循环
      j <- 1 to i //第二层for循环
    }{
      println(s"$i * $j = ${i*j}")
      if(i == j) println()
    }

    //for循环中可以绑定临时变量
    println("for循环中可以绑定临时变量")
    val names = Array("hadoop","hdfs","yarn","","hive")
    for {name <- names
         nameTem = name.trim // 临时变量是val 是不可被修改的,nameTem是val类型的
         if !nameTem.isEmpty}{
      println(name)
    }

    //关键字 yield 生成一个新的集合，基于现有的集合生成一个新的集合 叫做：for循环的推导式
    println("关键字 yield 生成一个新的集合，基于现有的集合生成一个新的集合 叫做：for循环的推导式")
    val array1: Array[Int] = (2 to 10).toArray

    val newar1: Array[Int] = for(ar1 <- array1) yield {
      ar1 * 2
    }

    println(array1.mkString("<","-",">"))
    println(newar1.mkString("<",",",">"))





  }
}
