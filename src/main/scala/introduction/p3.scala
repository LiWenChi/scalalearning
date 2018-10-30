package introduction



import scala.collection.mutable
import scala.collection.mutable.ListBuffer


/**
  * List集合及基本操作、List集合常用方法、Set 集合
  */
//Scala List：List的特征是其元素以线性方式存储，集合中可以存放重复对象。
//Scala Set：Set是最简单的一种集合。集合中的对象不按特定的方式排序，并且没有重复对象。
//Scala Map：Map 是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。
//Scala Option：  Option[T] 表示有可能包含值的容器，也可能不包含值。
//Scala 元组：元组是不同类型的值的集合   元组在上面已经定义了
//
//注：Scala程序使用Option非常频繁，在Java中使用null来表示空值，程序需要关心那些变量可能
//是null,代码中很多地方都要添加null关键字检测，不然很容易出现NullPointException。但一但
//出现，很难查出为什么出现NullPointerException。Scala的Option类型可以避免这种情况，因此
//Scala应用推荐使用Option类型来代表一些可选值。使用Option类型，就可以清晰的看出这种类型的
//值可能为None。

object p3 {

  def main(args: Array[String]): Unit = {
    // List集合
    // 不可变集合
    val list: List[Int]  = List(1,2,3,4,5,6)

    // 获取元素
    println("===============获取元素===================")
    println(s"获取数组的第一个元素：${list(0)}")
    println(s"获取数组的头部元素：${list.head}")
    println(s"获取数组除去头部之外的所有元素：${list.tail}")
    println(s"获取数组的尾部元素：${list.last}")
    println(s"获取数组除去尾部之外的元素：${list.init}")

    // 拼接元素
    println("===============拼接元素===================")
    // 都是从头部插入
    val list1: List[Int] = 10::list
    println(list1.mkString(","))
    val list2: List[Int] = 10::20::30::40::50::60::Nil     // 左链接 Nil代表一个空集合
    println(list2.mkString(","))
    val list3: List[Int] = Nil.::(100).::(200).::(300).::(400).::((500)).::(600)   // 右连接
    println(list3.mkString(","))

    // list里面元素不能被更新
    //list(0) = 100     报错
    //println(list(0))  Error:(25, 9) value update is not a member of List[Int] list(0) = 100


    // 构建可变的List
    println("===============构建可变的List===================")
    val list4: ListBuffer[Int] = ListBuffer(0,1,2,3,4,5,6,7)

    // 添加元素
    list4 += 8
    list4 += 9
    // ++=用于添加集合和数组
    list4 ++= Array(10,11,12)
    list4 ++= List(13,14,15,16)

    // 更新指定位置元素
    list4(0) = 100

    // 指定位置添加元素，下标从0开始
    list4.insert(1,666)

    println("------------遍历list4------------------")
    for(a <- list4){
      println(a)
    }

    println("------------------------------")

    // 删除元素
    println("===============删除元素===================")
    list4 -= 100
    list4 --= List(11,666,13)

    println(list4.mkString(","))

    // 删除指定位置元素
    val resRm = list4.remove(0)
    println(s"返回删除的元素：${resRm}")
    println(list4.mkString(","))

    // 可变集合转换成不可变集合
    list4.toList
    list4.toSet

    //使用java集合
    import java.util
    val listJava = new util.ArrayList[String]()
    listJava.add(0,"zz")

    //java List转换成Scala List  需要引入scala.collection.JavaConverters._ 包
    import scala.collection.JavaConverters._
    val scalaList =listJava.asScala
    //Scala List 转换成 java List
    val listJava1 = scalaList.asJava

    // List集合常用方法
    println("===============list 反转===================")
    val list5 = List(1,2,3,4,5,6)
    //list 反转
    println(list5.reverse)

    // 拉链操作 两组集合转换成 一个二元组 zip:以最少的元素为准  zipAll:不够可以补充
    println("===============拉链操作===================")
    println(list5.zip(List(7,8,9)))
    println(list5.zip(List(10,11,12,13,14,15,16)))
    println(list5.zipAll(List(20,21),-1,-2))

    //数组 List 互相转换
    println("===============数组 List 互相转换===================")
    val list6: List[Int] = (0 to 6).toList
    println(list6)
    val arr: Array[Int] = list6.toArray
    println(arr)
    val str: String = list6.toString()
    println(str)

    // foreach 没有返回值所以一般用于打印输出
    println("===============foreach===================")
    list6.foreach(v => {
      print(v)
    })
    println()
    //可简化为
    list6.foreach(print)
    println()

    // map对集合的每个元素处理，map是有返回值的
    println("===============map===================")
    print(list6.map(2 * _))
    println()
    val mapList: List[Unit] = list6.map(v => {
      print(2 * v)
    })
    println()

    val mapList1: List[List[Int]] = list6.map(v => {
      (1 to v).toList
    })

    mapList1.foreach(println)

    println("===============flatmap操作===================")

    //flatMap对集合中每个元素的处理 使用给定函数 返回一个新的集合
    // flatMap在map的基础上进行了一次扁平化的操作
    // 如上面的操作 map返回的是一个list，flatMap是把map返回的每个list里面的数据结合起来做一个大的list
    val flatMapList: List[Int] = list6.flatMap(v => {
      (1 to v).toList
    })

    flatMapList.foreach(println)

    // filter 数据过滤   filter
    println("===============filter 数据过滤===================")
    val fter: List[Int] = list6.filter(v => v % 2 == 0)     //返回偶数 对集合中对2求余等于0的返回
    fter.foreach(println)

    val fter1: List[Int] = list6.filterNot(v => v % 2 == 0)  // filterNot与filter相反

    //reduce 数据聚合
    println("===============reduce 数据聚合===================")
    val reduce: Int = list6.reduce((a:Int, b:Int) => {
      // a 是 list里面的head元素，是上一个数据处理的临时聚合值
      // b是集合里面的元素
      println(s"a=${a}    b=$b")
      a + b
    })

    println(s"reduce=$reduce")

    // fold 和 reduce 功能差不多，区别是flod可以给定一个初始值
    // a 是 list里面的head元素，是上一个数据处理的临时聚合值
    // b是集合里面的元素
    // fold 指定a和b必须是同一类型的
    println("===============fold 数据聚合===================")
    val fold = list6.fold(10)((a:Int,b:Int) => {
      println(s"a=${a}    b=$b")
      a + b
    })

    println(fold)

    list6.foldLeft("")((a,b) => {  // 执行过程从左往右
      println(s"a=${a}    b=$b")
      a + b
    })

    // a 是集合里面的元素
    // b 是 list里面的head元素，是上一个数据处理的临时聚合值
    list6.foldRight("")((a,b) => {  // 执行过程从右往左
      println(s"a=${a}    b=$b")
      a + b
    })

    println("===============排序===================")
    val list7 = List(6,3,1,2,4,5,0,8)
    // 排序默认是升序排序
    println(list7.sorted)

    val list8: List[Int] = List(1,2,3,4,5,6,7,8,9,10,11,12)
    // 根据指定函数的返回值进行排序
    println(list8.sortBy(v => {v.toString}))
    println(list8.sortBy(v => v % 4))

    //groupBy返回一个map集合
    println(list8.groupBy(v => v % 4))



    /****              Set 集合           ****/
    println("===============Set 集合===================")
    println("===============Set 集合===================")
    println("===============Set 集合===================")
    // Set集合 元素是不重复的，并且元素是无序的
    // 不可变的Set
    val set1: Set[Int] = Set(1,2,3,4,5,6,6,1,3,6)
    println(set1.toString())

    //添加一个新的集合（set1 + 12） ==> 是构建一个新的Set集合，原来的集合是不变
    val set2: Set[Int] = set1 + 12
    println(set2.toString())

    val set3 = set1 ++ Set(7,8,9)
    println(set3.toString())

    val set4 = set3 - 8     // 是构建一个新的Set集合，原来的集合是不变
    println(set4.toString())

    // map 高阶函数和 list 是差不多的，区别是Set会去重
    println("===============Set的map操作===================")
    val set5 = set4.map(v => v * 2)
    println(set5.toString())

    // 访问
    println("===============元素是否存在于Set中===================")
    val set6 = set5(8)
    println(s"8这个元素是否存在集合中:${set6.toString()}")


    // 可以对集合set1进行去重  先转换成set在转换成list  但是顺序会被打乱
    println("===============集合去重===================")
    val listSet = List(1,1,2,2,3,3,4,4,5,5,6,6,6)
    println(listSet.toList.toSet)

    // 可变的Set集合 immutable 不可变的 mutable  可变的
    println("===============可变的Set集合===================")
    val mutleSet = mutable.Set[Int]()

    mutleSet += 12
    mutleSet += 16
    mutleSet += (17,18,19)
    mutleSet ++= Array(6,7,8)
    println(mutleSet.toString())
    /*mutleSet -= 12
    mutleSet -= 16
    mutleSet -= (17,18,19)
    mutleSet --= Array(6,7,8)*/

    mutleSet(0) = true //set 集合添加一个元素
    mutleSet(12) = false //set 集合删除一个元素
    println(mutleSet.toString())

    //mutleSet.toMap // 要求set集合是一个二元组



    println("===============Map===================")
    println("===============Map===================")
    // Map 是一个键值对的集合
    // 不可变的Map
    val tst: (String, Int) = "a" -> 1
    val map1: Map[String, Int] = Map("a" -> 1,"b" -> 2,"b" -> 2)
    val map2 = Map(("a",1),("b",1),("c",1))

    println(map1.get("a"))  //Some(1)
    println(map1.get("c"))  //None
    println(map1("a"))
    //getOrElse 如果存在则返回存在的值 如果不存在则返回设置的默认值
    println(map1.getOrElse("a",100))
    println(map1.getOrElse("c",100))

    // 可变的map   默认类型Nothing
    println("===============可变的map===================")
    val meMap: mutable.Map[Nothing, Nothing] = mutable.Map()
    val map3: mutable.Map[String, Int] = mutable.Map()

    // 添加元素
    map3 += "d" -> 1
    map3 += "e" -> 2
    map3 += "f" -> 3
    map3 += "f" -> 6
    map3 ++= map1

    // 删除元素是基于key去删除
    map3 -= "a"

    map3("c") = 7

    println(map3.toString())

    // map遍历
    println("===============map遍历===================")
    for (m <- map3){
      println(s"key=${m._1}   value=${m._2}")
    }
    for((key,vale) <- map3){
      println(key + "," + vale)
    }
    map3.map(r => {
      println(r._1 + "-" + r._2)
    })

  }

}
