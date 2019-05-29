package com.string;

import java.util.Arrays;

/**
 * @author zhanghaijun
 */
public class NewString {

    public static void main(String[] args) {
        String a = "JAVA";
        String b = "JAVA";
        String c = new String("JAVA");
        String d = "JA";
        String e = "VA";
        String f = "JA" + "VA";
        String g = d + e;
        String h = c;

        System.out.println("a+b:" + (a == b) + "-" + a.equals(b));
        System.out.println("a+c:" + (a == c) + "-" + a.equals(c));
        System.out.println("a+f:" + (a == f) + "-" + a.equals(f));
        System.out.println("a+g:" + (a == g) + "-" + a.equals(f));
        System.out.println("c+f:" + (c == f) + "-" + c.equals(f));
        System.out.println("c+g:" + (c == g) + "-" + c.equals(g));
        System.out.println("c+h:" + (c == h) + "-" + c.equals(h));

        //test();
    }

    private static void test() {
        int a = 0;
        int b[] = new int[5];
        int c = 3;
        b[a] = a = c;

        //最终a=?, b[0]还是b[3]被赋值呢？
        System.out.println(a + Arrays.toString(b));

    }

}
