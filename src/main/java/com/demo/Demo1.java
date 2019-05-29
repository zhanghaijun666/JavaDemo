package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    1.给定一个字符串，请找出其中无重复字符的最长字符串的长度。
    例如:"abcabcbb",其无重复字符的最长字符串是"abc",其长度为3。
    "bbbbbbbb",其无重复字符的最长字符串为"b",其长度为1。
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(longOfSubstr(str));
    }

    public static int longOfSubstr(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        List<Character> list = new ArrayList<>();
        list.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (list.contains(str.charAt(i))) {
                int index = list.indexOf(str.charAt(i));
                list = list.subList(index + 1, list.size());
                list.add(str.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            } else {
                list.add(str.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }
}
