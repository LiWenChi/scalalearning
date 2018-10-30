/*
case class
Scala中的一种特殊的class，叫做 case class
case
class 就是class和object的一个整合，在变异的过程中会自动的生成class和object的相关代码，并且
在object中生成一个和class主构造函数通参数列表的apply方法，可以简化写object的过程.
---定义一个Student类
case class中默认的属性修饰符为public val，但是可以改变的，跟普通函数的定义是一样的，没有区别
case class中的属性最多允许为22个，跟元组中是一样的
一般比较常用于模式匹配
*/
case class Student (name:String,age:Int)

// 会默认生成object 的apply方法
object Student{
  //def apply(name: String, age: Int): Student = new Student(name, age)
}
