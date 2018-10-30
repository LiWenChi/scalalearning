trait A {
  def h()
}

trait B

trait C {
  var b : Int
  val c : Double
  def f()

  val abc = "123"

  def g(name:String): Unit ={
    println(s"invoke trait C : ${name}")
  }
}

trait D extends A {
  override def h(): Unit = {
    println("invoke D h")
  }
}

class F extends  C {
  override var b: Int = 10
  override val c: Double = 1.68

  override def f(): Unit = {
    println("invoke F ")
  }
}

// 多个继承
trait MD extends A with B with  C{
  override def h(): Unit = {
    println("invoke D h")
  }
}

object  M{
  def main(args: Array[String]): Unit = {
    val f = new F
    println(f.b)
    println(f.c)
    println("--:"+f.f())
    println(f.abc)
    println(f.g(" TRAIT"))

  }
}
