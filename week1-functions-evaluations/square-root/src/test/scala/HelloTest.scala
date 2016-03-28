import org.scalatest.FunSuite

/**
  * Created by jiateng on 3/28/16.
  */
class HelloTest extends FunSuite {
  test("sayHello method works correctly") {
    val hello = new Hello
    assert(hello.sayHello("Scala") == "Hello, Scala!")
  }
}
