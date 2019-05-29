package com.demo;

import java.util.Arrays;
import java.util.Scanner;

/*
    数组之和为用户输入的定数，数组中的相邻的数字相差1
    求数组
 */
public class Demo5_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        getArray(total);
    }

    private static void getArray(int num) {
        int startNum = 1;
        int endNum = 2;
        while (endNum < num) {
            if (getSum(startNum, endNum) == num) {
                int[] arr = new int[endNum - startNum + 1];
                for (int i = 0; i < endNum - startNum + 1; i++) {
                    arr[i] = startNum + i;
                }
                System.out.println("得到数组：" + Arrays.toString(arr));
                startNum++;
                endNum = startNum;
            } else if (getSum(startNum, endNum) > num) {
                startNum++;
                endNum = startNum;
            }
            endNum++;
        }
    }

    private static int getSum(int startNum, int endNum) {
        if (startNum < endNum) {
            return endNum + getSum(startNum, endNum - 1);
        } else if (startNum == endNum) {
            return startNum;
        }
        return 0;
    }
}
