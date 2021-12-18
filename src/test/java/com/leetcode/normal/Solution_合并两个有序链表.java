package com.leetcode.normal;

import com.leetcode.ListNode;
import org.junit.Test;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author: chenyutao
 * @date: 2021/12/7 11:20 下午
 */
public class Solution_合并两个有序链表 {

    @Test
    public void test1() {
        String list1 = "[1,2,4]";
        String list2 = "[1,3,4]";
        ListNode head1 = ListNode.convertStrToList(list1);
        ListNode head2 = ListNode.convertStrToList(list2);
        ListNode result = mergeTwoLists(head1, head2);
        ListNode.printList(result);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1= list1;
        ListNode head2= list2;
        if(head1==null&& head2==null){
            return null;
        }
        if(head1!=null&& head2==null){
            return head1;
        }
        if(head1==null&& head2!=null){
            return head2;
        }
        ListNode head3;
        ListNode curr;
        if(head1.val<=head2.val){
            head3 = head1;
            head1 = head1.next;
        }else {
            head3 = head2;
            head2 = head2.next;
        }
        curr= head3;

        while (head1 != null || head2 != null) {
            if(head1!=null&& head2==null){
                curr.next = head1;
                head1 = head1.next;
            }
            else if(head1 == null){
                curr.next = head2;
                head2 = head2.next;
            }
            else if(head1.val<=head2.val){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        return head3;
    }


}
