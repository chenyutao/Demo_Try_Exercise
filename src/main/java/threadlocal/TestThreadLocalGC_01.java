package threadlocal;

import com.alibaba.fastjson.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenyutao
 * @date: 2021/10/25 5:18 下午
 */
public class TestThreadLocalGC_01 {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws InterruptedException {
        //创建弱引用
        int size = 100;
        List<MyRef> srArr = new ArrayList<>(size);
        System.out.println("------------ start");
        for (int i = 0; i < size; i++) {
            srArr.add(i,new MyEntryWarp(new JSONObject()));

        }
        System.out.println("------------ prepare end");
        //获取被清除部分
        int n = 0;
        for (MyRef entry : srArr) {
            if (entry.get() == null) {
                n++;
            }
        }
        System.out.println("------------ before gc, clean obj num: " + n);
        //尝试请求一次GC
        System.gc();
        //获取第二次被清除部分
        int m = 0;
        for (MyRef entry : srArr) {
            if (entry.get() == null) {
                m++;
            }
        }
        System.out.println("------------ after gc, clean obj num: " + m);
    }

    interface MyRef {
        Object get();
    }

    static class MyEntry extends WeakReference{
        private byte[] value;

        public MyEntry(Object referent) {
            super(referent);
            value = new byte[1 * 1024 * 1024];
        }
    }

    static class MyEntryWarp implements MyRef {
        private MyEntry entry;

        public MyEntryWarp(Object referent) {
            entry = new MyEntry(referent);
        }

        @Override
        public Object get(){
            return entry.get();
        }
    }

    static class BizWorkThread extends Thread implements MyRef{
        @Override
        public Object get() {
            return null;
        }
    }


}


