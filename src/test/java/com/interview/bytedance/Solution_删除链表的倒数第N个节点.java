package com.interview.bytedance;

import com.leetcode.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第n个节点
 */
public class Solution_删除链表的倒数第N个节点 {

    String input = "[1,2,3,4,5]";
    int delIndex = 2; 

    @Test
    public void test() {
        ListNode listNode = ListNode.convertStrToList(input);
        ListNode.printList(listNode);
        ListNode result = removeNthFromEnd(listNode, delIndex);
        ListNode.printList(result);
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int loopIndex = 0;
        ListNode nodeToDel = null;
        ListNode nodeFrontOfDel = head;
        while (curr!=null){
            loopIndex++;
            if(loopIndex==n){
                nodeToDel = head;
            }
            if(loopIndex==n+1){
                nodeFrontOfDel = head;
                nodeToDel = nodeFrontOfDel.next;
            }
            if(loopIndex>n+1){
                nodeFrontOfDel = nodeFrontOfDel.next;
                nodeToDel = nodeFrontOfDel.next;
            }
            curr = curr.next;
        }
        if(nodeToDel==null){
            return head;
        }
        if(nodeToDel==head){
            return nodeToDel.next;
        }
        nodeFrontOfDel.next = nodeToDel.next;
        return head;
    }

}
