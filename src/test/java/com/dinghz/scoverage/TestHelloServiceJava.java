package com.dinghz.scoverage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author craneding
 * @date 16/2/2
 */
public class TestHelloServiceJava {

    @Test
    public void testSayHello() {
        HelloService service = new HelloServiceJavaImpl();

        String msg = service.sayHello("ding");

        assertEquals(msg, "hello ding");
    }

}
