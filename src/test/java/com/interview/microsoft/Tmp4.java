package com.interview.microsoft;

import org.junit.Test;

/**
 * @author: chenyutao
 * @date: 2022/1/26 2:21 下午
 */
public class Tmp4 {
    // 顺时针打印
//            1   2   3    4
//            5   6   7   8
//            9  10  11  12
//            13  14  15  16
//            17  18  19  20

    public void printAsRequest(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        int i = 0;
        int j = 0;
    }

    @Test
    public void test0() {
        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
//        System.out.println(nums[2][1]); //10
//        System.out.println(nums.length);// 5
//        System.out.println(nums[0].length); // 4

        print(0,0,nums,1);
    }


    public void print(int i, int j ,int[][] nums,int direction){
        // right
        if(direction==1){
            while (true){
                System.out.println(nums[i][j]);
                System.out.print(" ");
                nums[i][j]= 0;
                j++;
                if(j==nums[0].length){
                    j--;
                    print(++i,j,nums,2);
                    return;
                }
                else if(nums[i][j]==0 ){
                    j--;
                    i++;
                    if(nums[i][j]==0){
                        return;
                    }else {
                        print(i,j,nums,2);
                        return;
                    }
                }
            }
        }else
        // down
        if(direction ==2){
            while (true){
                System.out.println(nums[i][j]);
                System.out.print(" ");
                nums[i][j]= 0;
                i++;
                if(i==nums.length){
                    i--;
                    print(i,--j,nums,3);
                    return;
                }
                else if(nums[i][j]==0 ){
                    i--;
                    j--;
                    if(nums[i][j]==0){
                        return;
                    }else {
                        print(i,j,nums,3);
                        return;
                    }
                }
            }
        }else
        // left
        if(direction ==3){
            while (true){
                System.out.println(nums[i][j]);
                System.out.print(" ");
                nums[i][j]= 0;
                j--;
                if(j==-1){
                    j++;
                    print(--i,j,nums,4);
                    return;
                }
                else if(nums[i][j]==0 ){
                    j++;
                    i--;
                    if(nums[i][j]==0){
                        return;
                    }else {
                        print(i,j,nums,4);
                        return;
                    }
                }
            }
        }else
        // up
        if (direction==4){
            while (true){
                System.out.println(nums[i][j]);
                System.out.print(" ");
                nums[i][j]= 0;
                i--;
                if(i==-1){
                    i++;
                    print(i,++j,nums,1);
                    return;
                }
                else if(nums[i][j]==0 ){
                    i++;
                    j++;
                    if(nums[i][j]==0){
                        return;
                    }else {
                        print(i,j,nums,1);
                        return;
                    }
                }
            }
        }

    }

}
