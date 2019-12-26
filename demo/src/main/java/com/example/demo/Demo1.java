package com.example.demo;

/**
 * @author: DHJ
 * @create: 2019/12/17 16:01
 * Description:
 */
public class Demo1 {
    static String NAME = "sss";
    public static void main(String[] args) {
        method();
        int i = 1/0;
        new Demo1().getStr(0, "");

    }

    private static void method() {
        String goods_short_code = "000" == null ? ""
                : "000".substring(
                "000".length() - 4,
                "000".length());
        System.out.println(goods_short_code);
    }

    public Integer getStr(int i, String a){
        return 0;
    }
}
