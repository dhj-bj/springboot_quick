package com.example.demo;

/**
 * @author: DHJ
 * @create: 2019/12/20 9:50
 * Description:
 */
public class Demo2 {

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        String a = Demo1.NAME;
        String aa = "aaa";
        fun(aa);
        aa = "bbb";
        fun(aa);

    }

    private static void fun(String aa) {
        System.out.println(aa);
    }

}
