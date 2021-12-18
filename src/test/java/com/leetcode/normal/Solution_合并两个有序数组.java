package com.leetcode.normal;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author: chenyutao
 * @date: 2021/12/8 9:45 下午
 */
public class Solution_合并两个有序数组 {
    @Test
    public void test() {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        int len1 = 3;
        int len2 = 3;
        merge(num1, len1, num2, len2);
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]);
            System.out.print(" ");
        }
    }

    /**
     * 30分钟，非最简，--2021.12.08
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < n; ) {
            int val2 = nums2[i];
            int val1 = nums1[j];
            if (j>=(m+i) || val1 > val2) {
                insert(nums2[i], nums1, j);
                i++;
            }
            j++;
            if(j==(m+n)){
                break;
            }
        }
    }

    private void insert(int val, int[] arr, int index) {
        int i = arr.length - 1;
        while (i != index) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[index] = val;
    }
}
