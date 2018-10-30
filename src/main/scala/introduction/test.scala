package introduction

/**
  * Created by Administrator on 2018/10/30.
  */
object test {

  def main(args: Array[String]): Unit = {
    /* val person = new Person()
     person.name = "jeffrey"
     person.age = 18
     person.eat()
     */
    val person = new Person("haixia",18)

    println(person.eat())

    /*
    伴生类和伴生对象
    定义：如果在一个scala文件中，分别存在一个class和一个object，而且class和object的名称完全一样，那么称这
个class为object的伴生类，object称为class的半生对象
    作用：伴生类和伴生对象之间可以相互访问私有属性和方法
    */
    person.prints1()    //半生对象和半生类

    /*
     apply 方法
        定义在object中：表示提供一种快捷的对象创建方式，创建的对象就是apply方法返回的数据类型，创建对象的调用方式
就是object名称+apply函数的参数列表
        定义在class中，表示提供一种快捷的数据获取方式，类似list集合数据获取方式 eg:list(0)
     */
    // 调用object中
    val v: Person = Person("张无忌",16)
    println("-----name:" + v.name)
    println("-----age:" + v.age)
    // 调用class中
    println(person.apply("张三丰"))


    /*
      update 方法
      只能定义在class中，标识提供一种便捷的数据更新/插入的方法，类似数组的更新 eg:arr(0) = 100
      update函数中参数至少两个，参数列表的最后一个参数在调用的时候写在等号后面，其他的写在等号前面
      */

    person("张三丰") = 100
    println(person.name + "------------" + person.age)


    /*case class */

    //val stu = new Student("zhangsan",16)
    //    val stu1 = Student("xiaoma",12)
    //
    //    println(stu1.name)


    /*
    scala泛型
    基本和Java一样，区别在于：Java使用<>表示泛型，scala使用[]表示泛型
            泛型可以出现在class名称后面以及方法名称后面
    class Student[T]
    def add[T](t:T)
    上下界：
    [A1 >: A] : 表示A是A1的下界，也就是A是A1的子类
            [A1 <: A] : 表示A是A1的上界，也就是A是A1的父类
    协变/逆变：
    [+T] : 协变，如果有一个类C定义为C[T],而且A是B的父类，那么C[A]是C[B]的父类
            [-T] : 逆变，如果有一个类C定义为C[T],而且A是B的父类，那么C[B]是C[A]的父类
            [T] : 正常定义，如果有一个类C定义为C[T],而且A是B的父类，那么C[A]和C[B]之间没有关系
    */


    /*
    隐式转换
    注意：隐式转换函数只能转换一次
    隐式转换函数
    将一个对象通过定义的隐式转换函数转换成为另一个对象，主要在于某一个对象在调用某个方法的时候，
    该对象实际上没有该方法，可以通过隐式转换将该对象转换为具有该方法的其他对象（隐式转换函数在当前作用域中存在）
    隐式转换对象
    在函数的定义过程中，可以给定默认的输入参数，而且可以指定默认的参数是隐式转换对象，当该API被调用的时候，
    会自动的从当前作用域中获取该隐式转换对象，比如List集合排序的时候，使用的排序器就是一个隐式转换对象
    核心：定义隐式转换函数，即 implicit conversion function，用implicit修饰函数或者方法
    scala默认会使用两种隐式转换
    -1. 源类型，或者目标类型的伴生对象内的隐式转换函数
    -2. 当前程序作用域内的可以用唯一标识符表示的隐式转换函数
    */
    implicit def boolean2String(flag:Boolean):String = flag.toString
    val str: String = true

    implicit def int2String(flag:Int): String = flag.toString
    val a:String = 666

    a.trim()

  }
}
