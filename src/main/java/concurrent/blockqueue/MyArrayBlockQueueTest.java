package concurrent.blockqueue;

import org.junit.Test;

/**
 * @author: chenyutao
 * @date: 2021/11/22 7:07 下午
 */
public class MyArrayBlockQueueTest {

    @Test
    public void test1() {

        try {
            MyArrayBlockQueue<Integer> queue = new MyArrayBlockQueue<>(2);
            Runnable putAction = () -> {
                try {
                    queue.put(3);
                } catch (InterruptedException interruptedException) {
                    System.out.println("interruptedException");
                }
            };
            Thread thread1 = new Thread(putAction);
            Thread thread2 = new Thread(putAction);
            Thread thread3 = new Thread(putAction);
            Thread thread4 = new Thread(() -> {
                Integer value = queue.poll();
                System.out.println("thread4_value:" + value);
            });

            thread1.start();
            thread2.start();
            thread3.start();
            Thread.sleep(1000* 30);
            thread4.start();

            Thread.sleep(1000* 60* 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
