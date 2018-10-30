//Person(name:String,age:Int) 是 主构造函数，会自动编译成属性
// 除了参数列表，函数体内包含可执行的代码
class Person(var name:String,var age:Int) {  // 半生类
  //属性的作用域默认为public
  /*var name:String = _
  var age:Int = _*/

  println("--------start----------")

  // 辅助构造函数
  def this(){
    this("hx",26)       //第一行调用主构造函数，必须写在第一行
    println("666")
  }
  // 辅助构造函数
  def this(age:Int){
    this()
    this.age = age
  }

  def eat() ={
    println(s"${name}已经${age}岁了，她正在吃东西……")
  }


  def prints1(): Unit ={
    println("我是半生类")
    Person.printlns()
  }


  def apply(name:String):String={
    println(s"invoke apply ${name}")
    this.name
  }

  def update (name:String,age:Int)={
    println(s"invoke update ")
    if(this.name == name){
      this.age = age
    }
  }


  println("--------end----------")
}

object Person { // 半生对象
private def printlns(): Unit ={
  println("我是半生对象")
}

  def apply(name:String,age:Int): Person = new Person(name,age)


}
