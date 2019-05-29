package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
    给定整数n，取若干个1到n的整数可求和等于整数m，编程求出所有组合的个数。
    比如当n=6，m=8时，有四种组合：[2,6], [3,5], [1,2,5], [1,3,4]。
    限定n和m小于120 
    输入描述:
    整数n和m

    输出描述:
    求和等于m的所有组合的个数。
    输入例子1:
    6 8
    输出例子1:
    4
 */
public class Demo6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        int m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        List<List<Integer>> l = combinationSum2(a, m);
        System.out.println(l.size());
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 1);
        return list;
    }

    public static void backtrack(List<List<Integer>> list, ArrayList<Integer> arrayList, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(arrayList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                System.out.println(arrayList.size() + "---------------");
                arrayList.add(nums[i]);
                backtrack(list, arrayList, nums, target - nums[i], i + 1);
                arrayList.remove(arrayList.size() - 1);

            }
        }
    }

}
