package com.dhj.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: DHJ
 * @create: 2019/12/10 17:02
 * Description:
 */
//@ConfigurationProperties(prefix = "person")
public class Person {
    private Student student;
    private String sex;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "student=" + student +
                ", sex='" + sex + '\'' +
                '}';
    }
}
