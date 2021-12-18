package com.leetcode.normal;

import com.leetcode.ListNode;
import org.junit.Test;

/**
 * 两数相加
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class Solution_两数相加 {

    int[] arr1 = new int[]{9,9,9,9,9,9,9};
    int[] arr2 = new int[]{9,9,9,9  };

    @Test
    public void test() {
        ListNode l1 = ListNode.convertArrToList(arr1);
        ListNode l2 = ListNode.convertArrToList(arr2);
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        ListNode.printList(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode();
        ListNode lastNode = startNode;
        ListNode tl1 = l1;
        ListNode tl2 = l2;
        int extra = 0;
        int v1;
        int v2;
        int tmpSum;
        int result;
        while (true){
            if(tl1==null){
                tl1 = new ListNode(0);
            }
            if(tl2==null){
                tl2 = new ListNode(0);
            }
             v1 = tl1.val;
             v2 = tl2.val;
             tmpSum = v1 + v2 + extra;
             result =  tmpSum%10;
            extra = tmpSum/10;
            ListNode tmpNode = new ListNode();
            lastNode.val = result;
            lastNode.next = tmpNode;
            if(tl1.next==null && tl2.next ==null && extra==0){
                lastNode.next = null;
                break;
            }
            // 转移
            lastNode = tmpNode;
            tl1 = tl1.next;
            tl2 = tl2.next;
        }
        return startNode;
    }

}
