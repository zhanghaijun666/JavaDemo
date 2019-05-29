package com.demo;

import java.util.Arrays;
import java.util.Scanner;

/*
    数组之和为用户输入的定数，数组中的相邻的数字相差1
    求数组
 */
public class Demo5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        addTotal(total);
    }

    public static void addTotal(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            sum = i;
            for (int j = i + 1; j <= num; j++) {
                sum = sum + j;
                if (sum == num) {
                    int[] arr = new int[j - i + 1];
                    int k = i;
                    for (int n = 0; n < j - k + 1; n++, i++) {
                        arr[n] = i;
                    }
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }
}
