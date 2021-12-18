package com.leetcode.normal;

import com.leetcode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author: chenyutao
 * @date: 2021/12/7 9:52 下午
 */
public class Solution_反转链表 {

    @Test
    public void test1() {
        String list = "[1,2,3,4,5]";
        ListNode listNode = ListNode.convertStrToList(list);
        ListNode result = reverseList(listNode);
        ListNode.printList(result);
    }

    @Test
    public void test2() {
        String list = "[1,2]";
        ListNode listNode = ListNode.convertStrToList(list);
        ListNode result = reverseList(listNode);
        ListNode.printList(result);
    }

    public ListNode reverseList(ListNode head) {
        return reverseList3(head);
    }


    /**
     *
     */
    public ListNode reverseList0(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);
        ListNode curr = head;
        while (curr.next!=null){
            nodes.add(curr.next);
            curr = curr.next;
        }
        for (int i = 1; i < nodes.size(); i++) {
            nodes.get(i).next=nodes.get(i-1);
        }
        nodes.get(0).next = null;
        return nodes.get(nodes.size()-1);
    }

    /**
     * 迭代
     */
    public ListNode reverseList1(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode[] nodes = new ListNode[1];
        nodes[0] = head;
        int num = 1;
        int realLen = 1;
        while (nodes[num-1].next!=null){
            if(num>=nodes.length){
                ListNode[] lastNodes = nodes;
                nodes = new ListNode[nodes.length*2];
                for (int i = 0; i < lastNodes.length; i++) {
                    nodes[i]= lastNodes[i];
                }
            }
            nodes[num]=nodes[num-1].next;
            num++;
            realLen++;
        }
        for (int i = 1; i < realLen; i++) {
            nodes[i].next=nodes[i-1];
        }
        nodes[0].next=null;
        return nodes[realLen-1];
    }

    /**
     * 迭代
     * 12345
     * 21345
     * 32145
     * 多指针迭代，未完成
     */
    public ListNode reverseList2(ListNode head) {
        return null;
    }

    /**
     * 迭代-拆成两段链表===》依次从原链表里去除表头，放入新的逆序链表里
     * 神奇的效果
     */
    public ListNode reverseList3(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList_(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        return null;
    }

    private ListNode reAndFindLast(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode result = head.next;
        reAndFindLast(head.next);
        result.next = head;
        return result;
    }

    /**
     * ---------------------------------------------
     */

    @Test
    public void test() {
        String list = "[1,2,3,4,5]";
        ListNode listNode = ListNode.convertStrToList(list);
        ListNode result = reverseList_2021_12_09(listNode);
        ListNode.printList(result);
    }

    public ListNode reverseList_2021_12_09(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode head2 = head;
        head = head.next;
        head2.next=null;
        while(true){
            ListNode tmp1 = head;
            head = tmp1.next;
            ListNode tmp2 = head2;
            head2 =  tmp1;
            head2.next = tmp2;
            if(head==null){
                break;
            }
        }
        // 1,2345
        // 321,45
        return head2;
    }

}
