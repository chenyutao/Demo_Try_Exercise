package threadlocal;

import org.junit.Test;

import java.lang.ref.WeakReference;

/**
 * @author: chenyutao
 * @date: 2021/10/25 5:02 下午
 */
public class TestThreadLocal {
    @Test
    public void test222() throws Exception{
        new ThreadLocal<>();
        MyObj myObj = buildObj();
        Thread.sleep(10);
        System.gc();
        Thread.sleep(10);
        System.out.println("------");
        System.out.println(myObj);
        System.out.println("------");
    }

    private MyObj buildObj(){
        MyObj myObj = new MyObj();
        myObj.setField1(new WeakReference<>("hh1"));
        myObj.setField2("hh2");
        myObj.setField3(new MyEntry("hh3","lllll"));
        return myObj;
    }

    class MyObj {
        private WeakReference<Object> field1;
        private Object field2;
        private MyEntry field3;

        public void setField1(WeakReference<Object> field1) {
            this.field1 = field1;
        }

        public void setField2(Object field2) {
            this.field2 = field2;
        }

        public void setField3(MyEntry field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "MyObj{" +
                    "field1=" + field1 +
                    ", field2=" + field2 +
                    ", field3=" + field3 +
                    '}';
        }
    }

    class MyEntry extends WeakReference<Object> {
        Object value;

        MyEntry(Object k, Object v) {
            super(k);
            value = v;
        }

        @Override
        public String toString() {
            return "MyEntry{" +
                    "value=" + value +
                    "referent=" + get() +
                    '}';
        }
    }


}
