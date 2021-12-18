package threadlocal;

import java.lang.ref.WeakReference;

/**
 * @author: chenyutao
 * @date: 2021/10/25 5:18 下午
 */
public class Test02 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws InterruptedException {
        //创建弱引用
        WeakReference[] srArr = new WeakReference[1000];

        for(int i = 0; i < srArr.length; i++){
            srArr[i] = new WeakReference(new G2());
        }
        //获取被清除部分
        int n=0;
        int n1=0;
        for(int i = 0; i < srArr.length; i++){
            if(srArr[i].isEnqueued()){
                srArr[i]=null;
                n++;
            }
            if(srArr[i].get()==null){
                n1++;
            }
        }
        System.out.println("第一次GC,清除了"+n+"个");
        System.out.println("-----,清除了"+n1+"个");

        //尝试请求一次GC
        System.gc();

        //获取第二次被清除部分
        int m=0;
        int m1=0;
        for(int i = 0; i < srArr.length; i++){
            if(srArr[i]!=null&&srArr[i].isEnqueued()){
                srArr[i]=null;
                m++;
            }
            if(srArr[i].get()==null){
                m1++;
            }
        }
        System.out.println("第一次GC,清除了"+m+"个");
        System.out.println("-----,清除了"+m1+"个");
    }

    //为了占据内存
    static class G2{
        private  int [] big=new int[1000000];
    }
}

