package com.dhj.demo.controller;

import com.dhj.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: DHJ
 * @create: 2019/12/10 16:56
 * Description:
 */
@RestController
public class GetApplications {

//    @Value("${name}")
    @Value("${person.student.name}")
    private String name;

    @Value("${person.student.age}")
    private int age;

    @RequestMapping("getApplication")
    public String getApplication(){
        return "name:"+ name;
    }

    @RequestMapping("getPerson")
    public String getPerson(){
        return "PERSON:"+ age;
    }
}
