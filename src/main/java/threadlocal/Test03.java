package threadlocal;

import com.alibaba.fastjson.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenyutao
 * @date: 2021/10/25 5:18 下午
 */
public class Test03 {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) throws InterruptedException {
        //创建弱引用
        int size = 100;
        List<WeakReference> srArr = new ArrayList<>(size);
//        MyEntry[] srArr = new MyEntry[100];
//      WeakReference[]  srArr = new WeakReference[100];
        System.out.println("------------ start");
        for (int i = 0; i < size; i++) {
//            srArr.add(i,new WeakReference(new Test03.G3()));
            srArr.add(i,new MyEntry(new JSONObject()));
//            weakReference = new WeakReference(new Test03.G3());
        }
        System.out.println("------------ prepare end");
        //获取被清除部分
        int n = 0;
        for (WeakReference weakReference : srArr) {
            if (weakReference.get() == null) {
                n++;
            }
        }
        System.out.println("------------ before gc, clean obj num: " + n);
        //尝试请求一次GC
        System.gc();
        //获取第二次被清除部分
        int m = 0;
        for (WeakReference weakReference : srArr) {
            if (weakReference.get() == null) {
                m++;
            }
        }
        System.out.println("------------ after gc, clean obj num: " + m);
    }

    static class G3 {
        private byte[] _1M ;

        public G3() {
            _1M = new byte[1 * 1024 * 1024];
        }
    }

    static class MyEntry extends WeakReference{
//        private byte[] _1M ;
        private G3 key;

        public MyEntry(Object referent) {
            super(referent);
//            _1M = new byte[1 * 1024 * 1024];
            key = new G3();
        }
    }
    static class MyEntryWarp {
        private MyEntry entry;

        public MyEntryWarp(Object referent) {
            entry = new MyEntry(referent);
        }
    }

/**
 * 现象1： 直接用WeakReference vs 用WeakReference的继承类，对象回收队徽发生，只回收原本的referent
 * 结论1： 发生gc 的时候，"弱引用"并不是整个 对象/实现类对象 都会变成null，仅仅是其内部的 referent 成员会变成null
 *
 * 现象2： 用数组 vs 用list 效果一样
 * 现象3： 当总数100时，创建过程中 yong_gc 回收了29个，结束后 full_gc 回收了剩下的全部
 * 结论2：
 *
 *
 */

}



// 5120k
// 4837.k
// 5381.8 k 1024*2

// 1024 * x = 12* 1024

