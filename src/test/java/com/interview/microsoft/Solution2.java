package com.interview.microsoft;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: chenyutao
 * @date: 2022/1/19 10:17 下午
 */
public class Solution2 {

    @Test
    public void test() {
        int r = solution(2, 3, 3, 2);
        System.out.println(r);
    }

    /**
     * 00:00 23:59
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        Set<String> result = new HashSet<>();
        for (int i = 0; i <= 3; i++) {
            Integer[] nums = new Integer[4];
            nums[i]=A;
            if(!tmpCheck(A,i)){
                continue;
            }
            for (int j = 0; j <= 3; j++) {
                Integer[] num2 = copyArr(nums);
                if(num2[j]==null){
                    num2[j]=B;
                }else {
                    continue;
                }
                if(!tmpCheck(B,j)){
                    continue;
                }
                for (int k = 0; k <= 3; k++) {
                    Integer[] num3 = copyArr(num2);
                    if(num3[k]==null){
                        num3[k]=C;
                    }else {
                        continue;
                    }
                    if(!tmpCheck(C,k)){
                        continue;
                    }
                    for (int l = 0; l <= 3; l++) {
                        Integer[] num4 = copyArr(num3);
                        if(num4[l]==null){
                            num4[l]=D;
                        }else {
                            continue;
                        }
                        if(!tmpCheck(D,l)){
                            continue;
                        }
                        if(check(num4)){
                            StringBuilder hhh = new StringBuilder();
                            for (Integer num : num4) {
                                hhh.append(num);
                            }
                            result.add(hhh.toString());
                        }
                    }
                }
            }

        }
        return result.size();
    }

    private Integer[] copyArr(Integer[] arr){
        Integer[] tmp = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i]=arr[i];
        }
        return tmp;
    }

    private boolean tmpCheck(int value,int position){
        if(position==0 && value>2){
            return false;
        }
        if(position==2 && value>5){
            return false;
        }
        return true;
    }

    private boolean check(Integer[] nums){
        int v1 = nums[0]*10+nums[1];
        if(v1>23){
            return false;
        }
        int v2 = nums[2]*10+nums[3];
        if(v2>59){
            return false;
        }
        return true;
    }

}
