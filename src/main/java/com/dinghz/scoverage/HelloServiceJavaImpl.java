package com.dinghz.scoverage;

/**
 * @author craneding
 * @date 16/2/2
 */
public class HelloServiceJavaImpl implements HelloService {

    public String sayHello(String name) {
        if (name == null)
            return "you name?";

        switch (name) {
            case "ding":
                return "hello " + name;
            case "craneding":
                return "Hello " + name + "!";
            default:
                return "you name?";
        }
    }

    public void notCovered() {

    }
}
