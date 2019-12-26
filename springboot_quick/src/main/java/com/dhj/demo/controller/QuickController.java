package com.dhj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DHJ
 * @create: 2019/12/10 10:50
 * Description:
 */
@RestController
public class QuickController {

    @RequestMapping("quickString")
    public String quickString(){
        return "Hello SpringBoot 我胡汉三又又又又回来了。";
    }


}
