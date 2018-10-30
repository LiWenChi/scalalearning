package introduction

import scala.collection.mutable.ArrayBuffer

/**
  * 数组、元祖相关练习
  */
//元组 Tuple  元组里面可以是Scala里面的任意有效类型
//最小的单元是一元组（但一般不用），最常用的是二元组，最多允许22元组，
//元组中的类型是用val修饰，不可重新赋值，但是可以改变赋值对象中的属性或变量
//元组底层对应的是Tumle 类型的class
object p2 {
  def main(args: Array[String]) {
    //数组的声明和赋值
    var book:Array[String] = new Array[String](3)
    book(0) = "hadoop"
    book(1) = "hive"
    book(2) = "hbase"
    val s1 = book.mkString(" ")
    println(s1)


    //定长数组，不可变数组
    //数组的定义
    val arr: Array[Int] = Array(1,2,3,4,5,6)
    //定义一个长度为5的数组
    val arr1 = new Array[Int](5)

    println(s"arr:${arr.mkString(",")}")
    println(s"arr1:${arr1.mkString(",")}")

    // 数组和Java一样 索引从0开始
    println(s"数组的第一个元素是：${arr(0)}")

    // 循环遍历数组
    for(a <- arr){
      println(s"数组的每一个元素是：$a")
    }

    // 变长数组 -- 长度可以改变ArrayBuffer
    val arrbu = ArrayBuffer[Int]()

    // 添加数组元素用+=  添加一个定长数组 用++=
    arrbu += 12
    arrbu += 12
    arrbu += (1,2,3,4,5,6,7,8,9)
    arrbu ++= Array(11,22,33,44,55,66,66,66,22)  //添加一个定长的数组到一个变长的数组中

    // 添加元素到指定位置,从第0个位置开始计算
    arrbu.insert(2,666)

    println(arrbu.mkString(","))
    //删除数组的元素
    arrbu.remove(1)
    arrbu.remove(1,6)   // 删除索引为1~6 的元素
    arrbu -= 55 //删除指定元素
    arrbu -= 66 //重复数据只能删一次，如果数据不存在，就不进行任何操作
    arrbu -=(66,22,11)
    println(arrbu.mkString(","))

    //  更新 是基于索引的
    arrbu(5) = 10   //更新替换指定位置的元素
    println(arrbu.mkString(","))

    // 获取值
    println(arrbu(6))
    val arr2 = arrbu.toArray    //不可变数组
    val arr3 = arrbu.toBuffer   //可变数组

    // 数组强转
    val arr4: Array[Any] = Array(1,"scala",false)
    val ints: Int = arr4(0).asInstanceOf[Int]
    val strs: String = arr4(1).asInstanceOf[String]
    val bools: Boolean = arr4(2).asInstanceOf[Boolean]


    //元组 Tuple  元组里面可以是Scala里面的任意有效类型
    // 最小的单元是一元组（但一般不用），最常用的是二元组，最多允许22元组，
    // 元组中的类型是用val修饰，不可重新赋值，但是可以改变赋值对象中的属性或变量
    // 元组底层对应的是Tumle 类型的class

    println("===元组===")
    // 一元组
    val tup: Tuple1[Int] = Tuple1(2)
    println(tup._1)
    // 二元组
    val tup2: (String, Int) = Tuple2("1",2)
    println(tup2._1 + "," + tup2._2)

    val tup3 = tup2.swap    // swap 二元组数组交换位置
    println(tup3._1 + "," + tup3._2)


    // 元组可以嵌套进行 (元组可以放到数组里 数组也可放到元组里)
    val tup4 = Tuple3(("java","html",("redis","scala","C++")),("spring","mybatis"),"6")

    println(tup4._1._3._2)

  }
}
