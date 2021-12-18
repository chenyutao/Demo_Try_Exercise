package com.leetcode.normal;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 题述：
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * ==>不考虑空间浪费的损耗
 */
public class Solution_LRU缓存机制 {

    class LRUCache{
        class Tong{
            TongLinkedNode head;
            TongLinkedNode tail;

            public Tong(TongLinkedNode node) {
                this.head = node;
                this.tail = node;
                node.pref=null;
                node.next=null;
            }
        }

        /**
         * 最新的放head；最旧的放tail
         */
        class TongLinkedNode{
            int key;
            DataNode dataNode;
            TongLinkedNode next;
            TongLinkedNode pref;

            public TongLinkedNode(int key, DataNode dataNode) {
                this.key = key;
                this.dataNode = dataNode;
            }
        }

        class DataNode{
            int key;
            int val;
            int hitCount;

            public DataNode(int key, int val) {
                this.key = key;
                this.val = val;
                hitCount =1;
            }
        }

        Tong[] countTongArr;
        DataNode[] dataNodesArr;
        int storeCount;
        int capacity;

        public LRUCache(int capacity) {
            countTongArr = new Tong[capacity+1];
            dataNodesArr = new DataNode[2];
             this.capacity = capacity;
            storeCount = 0;
        }

        public int get(int key) {
            int result = -1;
            if(dataNodesArr.length>=key && dataNodesArr[key]!=null){
                this.addCount(key);
                result = dataNodesArr[key].val;
            }
            System.out.println(result);
            return result;
        }

        private void addCount(int key){
            // 寻找 所属桶
            int hitCount = dataNodesArr[key].hitCount;
            Tong tong = countTongArr[hitCount];
            // 寻找 所属节点
            TongLinkedNode linkedNode  = tong.head;
            while (linkedNode.key!=key){
                linkedNode = linkedNode.next;
            }
            TongLinkedNode curr = linkedNode;
            // 从当前桶的链表中去除
            TongLinkedNode prefNode = linkedNode.pref;
            TongLinkedNode nextNode = linkedNode.next;
            if(prefNode!=null){
                prefNode.next = nextNode;
            }else {
                tong.head = nextNode;
            }
            if(nextNode!=null){
                nextNode.pref = prefNode;
            }else {
                tong.tail = prefNode;
            }
            // 加入下一个桶的链表
            Tong nextTong = countTongArr[hitCount + 1];
            if(nextTong==null) {
                countTongArr[hitCount + 1] = new Tong(curr);
            }else {
                curr.next = nextTong.head;
                nextTong.head = curr;
                curr.pref = null;
            }
            // 计数值+1
            dataNodesArr[key].hitCount =  hitCount+1;
        }

        private void removeLeastUse(){
            int keyToDel;
            int delIndex = 1;
            while (true){
                Tong tong = countTongArr[delIndex];
                if(tong.head==null){
                    delIndex++;
                    continue;
                }
                TongLinkedNode node = tong.tail;
                keyToDel = node.dataNode.key;
                // 执行删除
                dataNodesArr[keyToDel]=null;
                if(node.pref!=null){
                    tong.tail = node.pref;
                    node.pref.next=null;
                }else {
                    tong.tail=null;
                    tong.head=null;
                }
                return;
            }

        }

        public void put(int key, int value) {
            // 直接计数+1
            if (key<capacity && dataNodesArr[key] != null) {
                dataNodesArr[key].val = value;
                this.addCount(key);
                return;
            }
            // 存储数组扩容
            if(key>=dataNodesArr.length&& dataNodesArr.length<=capacity){
                DataNode[] lastDataNodesArr= dataNodesArr;
                int targetLength = lastDataNodesArr.length;
                while (targetLength<=key){
                    targetLength = targetLength*2;
                }
                dataNodesArr = new DataNode[targetLength];
                for (int i = 0; i < lastDataNodesArr.length; i++) {
                    dataNodesArr[i] = lastDataNodesArr[i];
                }
            }
            // 存储打满,删除旧的
            if(storeCount==capacity){
               this.removeLeastUse();
                storeCount--;
            }
            // 创建存储节点
            DataNode dataNode = new DataNode(key,value);
            dataNodesArr[key]=dataNode;
            // 创建计数桶节点
            if(countTongArr[1]==null || countTongArr[1].head==null){
                countTongArr[1] = new Tong(new TongLinkedNode(key,dataNode));
            }else {
                TongLinkedNode lastHead = countTongArr[1].head;
                TongLinkedNode newHead = new TongLinkedNode(key, dataNode);
                countTongArr[1].head = newHead;
                countTongArr[1].head.next = lastHead;
                lastHead.pref = newHead;
            }
            storeCount++;
        }

    }

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }


}
