/**
  * Scala函数
  * 无参函数、局部函数、默认参数函数、变长参数函数、匿名函数、高阶函数、递归函数
  */
object p4 {
  def main(args: Array[String]): Unit = {

    def max(x:Int,y:Int):Int={
      if(x > y){
        x
      } else {
        y
      }
    }

    val m: Int = max(5,7)

    println(m)

    // 无参函数
    println("==============无参函数==============")
    def f1(): Unit ={
      println("无参函数F1")
    }
    f1()
    f1

    def f2{
      println("无参函数F2")
    }
    f2

    //局部函数
    println("==============局部函数==============")
    def f3 = {
      println("进入函数F3")
      f4()
      def f4()= {
        println("局部函数---进入函数F4")
      }
    }

    f3

    //默认参数的一个函数
    println("==============默认参数的一个函数==============")
    def sayName(name:String = "小明",say:String = "Hi"): Unit ={
      println(s"我叫：${name}")
      println(s"$say， $name")
    }

    sayName(say="Hello",name =  "张三")

    // 变长参数 ：可变长度参数，Scala允许指名函数的最后一个参数是可以重复的,
    // 多个参数必须定义到参数列表的最后，只能有一个变长参数
    println("===============变长参数==================")
    def printCources(c:String*): Unit ={
      c.foreach(cs=>{
        println(s"变长参数:$cs")
      })
    }

    printCources("数学","英语")

    def printCources1(name:String,age:Int,cours:String*): Unit ={
      cours.foreach(co => {
        println(s"name=$name , age=$age ,cours:$co")
      })
    }

    val couArr = Array("理综","英语","数学","语文")
    //cous:_* 打印数组的每个元素，表示传递的是数组的每一个，并不是整个数组
    printCources1("张三",18,couArr:_*)

    // 函数复制给变量  "函数名称 + 空格 + _"
    // 变长参数是一个集合 funcRes: (String, Int, Seq[String])
    println("===============函数复制给变量==================")
    val funcRes: (String, Int, Seq[String]) => Unit = printCources1 _

    funcRes("函数给变量",20,couArr)

    //匿名函数  格式：（参数列表） => {函数体}
    // var funcRes = (x:Int,y:String) = > {println("匿名函数")}
    println("===============匿名函数==================")
    val res = (x:Int,y:Int) => {
      if (x > y){
        println(s"${x} 大于或等于 ${y}")
      } else {
        println(s"${x} 小于 ${y}")
      }
    }

    res(1,6)


    //高阶函数 直接将某个函数作为参数传入其他函数，接收其他函数作为参数的函数就称之为高阶函数
    // 定义一个高阶函数
    println("===============高阶函数==================")
    def greeting(name:String,func:(String) => Unit): Unit ={
      func(name)
    }

    def sayHello(names:String): Unit ={
      println(s"Hello ${names}")
    }
    greeting("Scala",sayHello)
    greeting("Java",(a:String) => {println(s"a:${a}")})
    // 高阶函数简化写法
    println("===============高阶函数简化写法==================")
    greeting("C++",(a:String) => println(s"${a}"))
    greeting("web",(a) => println(s"${a}"))
    greeting("Html",a => println(s"${a}"))
    greeting("jsp",println(_))


    def opera(a:Int,b:Int,funcs:(Int,Int) => Int):Unit={
      println("Func=" + funcs(a,b))
    }

    opera(12,66,(x:Int,y:Int) => {x + y})
    opera(66,77,_+_)

    def operas(aa:Int,bb:Int,func:(Int,Int) => Int)={
      println(func(aa,bb))
    }

    operas(6,6,(xx:Int,yy:Int) => {6*6})
    operas(6,6,_*_)



    // 递归函数
    println("===============递归函数==================")
    def rescurFunc(n:Int): Int ={
      if(n<=1) 1 else n * rescurFunc(n-1)
    }

    println(rescurFunc(6))


    // 高阶函数之Map
    println("===============高阶函数之Map==================")
    val resMap: Array[Int] = Array(1,2,3,4,5).map(2 * _)
    //等价于
    val resmap = Array(1,2,3,4,5).map((a:Int) => {2 * a})
    println(resmap.mkString("_"))

  }
}
