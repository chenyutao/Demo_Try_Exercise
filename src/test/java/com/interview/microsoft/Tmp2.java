package com.interview.microsoft;

import org.junit.Test;

/**
 *
 * @author: chenyutao
 * @date: 2022/1/26 11:17 上午
 */
public class Tmp2 {
    /**
     * 实现一个简单的hashMap
     * put、get  数组+链表
     */

    @Test
    public void test() {
        MyMap myMap = new MyMap();
        myMap.put("hhh","1111");
        System.out.println(myMap.get("hhh"));
        System.out.println(myMap.get("hhh-"));
    }

    @Test
    public void test2() {
        MyMap myMap = new MyMap();
        Object obj1 = new Object() {
            @Override
            public int hashCode() {
                return 10;
            }
        };
        Object obj2 = new Object() {
            @Override
            public int hashCode() {
                return MyMap.defaultLength+10;
            }
        };
        Object obj3 = new Object() {
            @Override
            public int hashCode() {
                return MyMap.defaultLength*2+10;
            }
        };
        myMap.put(obj1,1);
//        myMap.put(obj2,2);
        myMap.put(obj3,3);
        System.out.println(myMap.get(obj1));
        System.out.println(myMap.get(obj2));
    }

    public static class MyMap{
        private static Integer defaultLength = 16;
        private Slot[] dataArr;
        class Slot {
            Object key;
            Object val;
            Slot next;

            public Slot(Object key, Object val, Slot next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }

        public MyMap() {
        }

        public void put(Object k, Object v){
            if(dataArr==null){
                dataArr = new Slot[defaultLength];
            }
            int index = k.hashCode() % dataArr.length;
            if(dataArr[index]==null){
                dataArr[index] = new Slot(k,v,null);
            }else {
                //
                updateSlotVal(index,k,v);
            }
        }

        private void updateSlotVal(int index,Object key,Object value){
            Slot slot = dataArr[index] ;
            while (slot!=null){
                if(slot.key.equals(key)){
                     slot.val = value;
                     return;
                }else {
                   slot = slot.next;
                }
            }
            dataArr[index] = new Slot(key,value, dataArr[index]);
        }

        public Object get(Object k){
            if(dataArr==null){
                return null;
            }
            int index = k.hashCode() % dataArr.length;
            return getSlotVal(dataArr[index],k);
        }

        private Object getSlotVal(Slot slot,Object key){
            while (slot!=null){
                if(slot.key.equals(key)){
                    return slot.val;
                }else {
                    slot = slot.next;
                }
            }
            return null;
        }
    }


}
