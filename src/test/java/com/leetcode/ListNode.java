package com.leetcode;

/**
 * @author: chenyutao
 * @date: 2021/12/7 9:54 下午
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode convertStrToList(String str){
        ListNode list = new ListNode();

        if (str.length()==2){
            return list;
        }
        String myStr = str.substring(1,str.length()-1);
        String[] split = myStr.split(",");
        ListNode curr = list;
        for (int i = 0; i <= split.length - 1; i++) {
            String s= split[i];
            curr.val = Integer.parseInt(s);
            if(i != split.length - 1){
                curr.next = new ListNode();
                curr = curr.next;
            }else {
                curr = curr.next;
            }
        }
        return list;
    }
    public static void printList(ListNode listNode){
        System.out.print("[");
        while (listNode!=null){
            System.out.print(listNode.val);
            if(listNode.next!=null){
                System.out.print(",");
                listNode = listNode.next;
            }else {
                break;
            }
        }
        System.out.print("]");
        System.out.println();
    }


    public static ListNode convertArrToList(int[] arr){
        ListNode list = new ListNode();
        ListNode tmp = list;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            tmp.val = n;
            if(i!=arr.length-1){
                tmp.next = new ListNode();
                tmp = tmp.next;
            }

        }
        return list;
    }
}
