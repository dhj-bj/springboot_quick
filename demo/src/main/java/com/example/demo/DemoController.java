package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DHJ
 * @create: 2019/12/10 14:44
 * Description:
 */
@RestController
public class DemoController {

    @RequestMapping("demoFirst")
    public String demoFirst() {
        return "Demo First hhh  sdf ";
    }

    @Test
    public void test() {
        System.out.println("Test");
    }
}
