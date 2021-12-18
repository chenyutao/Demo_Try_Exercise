package com.leetcode.normal;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 寻找两个正序数组的中位数
 *
 * 提示： 要求时间复杂度 O(log (m+n))
 */
public class Solution_寻找2个正序数组的中位数 {

    @Test
    public void test() {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    /**
     * 汇总数组总元素数
     *  奇数个： 中位数 = (总位数+1) / 2;
     *  偶数个： 中位数 =  总位数/2 , 总位数/2 + 1
     *
     * todo 放弃，数组的边界判断，太复杂
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0){
            return 0;
        }
        if(nums1.length==0 ){
            return findMedianForOneSortedArrays(nums1);
        }
        if(nums2.length==0 ){
            return findMedianForOneSortedArrays(nums2);
        }
        return findMedianForTwoSortedArrays_2(nums1,nums2);
    }

    public double findMedianForOneSortedArrays(int[] nums) {
        if(nums.length%2==0){
            int i1 = nums.length/2;
            int i2 = i1-1;
            return (nums[i1]+nums[i2])* 1.0/2.0;
        }else {
            int i = (nums.length-1)/2;
            return nums[i];
        }
    }

    /**
     *  10.28 第2次尝试
     *  放弃，数组的边界判断，太复杂
     */
    public double findMedianForTwoSortedArrays_2(int[] nums1, int[] nums2) {
        int totalLength = nums1.length+nums2.length;
        int index = 0;
        int midIndex;
        boolean twoMidMark;
        if(totalLength%2==0){
            twoMidMark= true;
            midIndex = totalLength/2;
        }else {
            twoMidMark= false;
            midIndex = (totalLength-1)/2;
        }
        int i=0,j=0;
        int[] value = new int[2];
        while (index<=midIndex){
            if(nums1[i]<nums2[j]){
                value[index%2]=nums1[i];
                i++;
            }else {
                value[index%2]=nums2[j];
                j++;
            }
            index++;
        }
        if(twoMidMark){
            return (value[0]+value[1])*1.0/2.0;
        }else {
            return value[0];
        }
    }

    /**
     *  11.22 第3次尝试
     *  用折半查找法
     */
    public double findMedianForTwoSortedArrays_3(int[] nums1, int[] nums2){
        int lastStart1 = 0;
        int lastStart2 = 0;
        int lastEnd1 = nums1.length;
        int lastEnd2 = nums2.length;
        int index1 = (lastStart1 + lastEnd1) / 2;
        int index2 = (lastStart2 + lastEnd2) / 2;
        return 0L;
    }






}
