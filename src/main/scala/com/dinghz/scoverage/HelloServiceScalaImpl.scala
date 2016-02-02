package com.dinghz.scoverage

/**
  * @author craneding
  * @date 16/2/2
  */
class HelloServiceScalaImpl extends HelloService {

  override def sayHello(name: String): String = {
    name match {
      case "ding" =>
        "hello " + name
      case "craneding" =>
        "Hello " + name + "!"
      case _ =>
        "you name?"
    }
  }

  override def notCovered(): Unit = {
    println("not covered")
  }
}
