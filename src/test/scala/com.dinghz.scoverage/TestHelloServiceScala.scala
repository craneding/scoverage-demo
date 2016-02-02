package com.dinghz.scoverage

import org.junit.Assert._
import org.junit.Test

/**
  * @author craneding
  * @date 16/2/2
  */
class TestHelloServiceScala {

  @Test
  def testSayHello() {
    val service = new HelloServiceScalaImpl()

    val msg = service.sayHello("ding")

    assertEquals(msg, "hello ding")
  }

}
