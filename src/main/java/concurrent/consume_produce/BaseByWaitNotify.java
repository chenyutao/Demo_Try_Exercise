package concurrent.consume_produce;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: chenyutao
 * @date: 2021/12/2 9:48 下午
 */
public class BaseByWaitNotify implements AbstractTemplate {
    Object lock = new Object();

    /**
     * 竞争 synchronized 锁 时，线程是monitor状态 即Block状态
     * wait执行后，是 wait状态
     * notify执行后，一个之前wait的线程进入monitor状态;
     * notifyAll后，全部之前wait的线程进入monitor状态
     * 被notify后，再然后锁被执行notify的线程释放（synchronized代码块执行结束）后，拿到锁的一个线程，进入running；其它线程继续 monitor
     *
     * @param queue
     * @throws InterruptedException
     */
    @Override
    public void consume(Queue<Object> queue) throws InterruptedException {
        synchronized (lock) {
            int i=0;
            while (queue.isEmpty()) {
                lock.wait(1000*100);// wait先，被notify后monitor
                i++;
            }
            System.out.println(Thread.currentThread().getName() + " : wait " + i);
            queue.poll();
            lock.notifyAll();
        }
    }

    @Override
    public void produce(Queue<Object> queue, Integer maxSize) throws InterruptedException {
        synchronized (lock) {// monitor
            int i=0;
            while (queue.size() >= maxSize) {
                lock.wait(1000*100);
                i++;
            }
            System.out.println(Thread.currentThread().getName() + " : wait " + i);
            queue.add(new Object());
            lock.notifyAll();
        }
    }


    public static void main(String[] args) {
        BaseByWaitNotify factory = new BaseByWaitNotify();
        Queue<Object> queue = new LinkedList<>();
        Integer maxSize = 10;
        AtomicInteger consumeCount = new AtomicInteger();
        AtomicInteger produceCount = new AtomicInteger();

        Runnable consumeTask = () -> {
            try {
                while (true) {
                    factory.consume(queue);
                    System.out.println(Thread.currentThread().getName() + " : consume " + consumeCount.incrementAndGet());
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        };

        Runnable produceTask = () -> {
            try {
                while (true) {
                    factory.produce(queue, maxSize);
                    System.out.println(Thread.currentThread().getName() +
                            " : produce " + produceCount.incrementAndGet());
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        };

        new Thread(produceTask,"produce-1").start();
        new Thread(consumeTask,"consume-1").start();
        new Thread(consumeTask,"consume-2").start();
        try {
            Thread.sleep(1000 * 3600);
            System.out.println("end");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            System.out.println("end");
        }

    }

    @Test
    public void test() throws InterruptedException{
        System.out.println("---start");
        // TIMED_WAITING (sleeping)
        Thread.sleep(1000* 10);
        System.out.println("---end");
    }

    // wait   WAITING
    // monitor BLOCKED


}
